package com.zben.cupid.service;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.zben.cupid.dao.CustomerMysqlDao;
import com.zben.cupid.dao.CustomerPicMysqlDao;
import com.zben.cupid.domain.Customer;
import com.zben.cupid.domain.CustomerMysql;
import com.zben.cupid.domain.CustomerPicMysql;
import com.zben.cupid.enums.TypeEnum;
import com.zben.cupid.remote.ShieldSPI;
import com.zben.cupid.remote.TrackSPI;
import com.zben.cupid.shield.model.UserVo;
import com.zben.cupid.track.model.SystemTrack;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zben
 * @Description:
 * @Date: 下午6:30 2018/4/12
 */
@Service
@Slf4j
public class CupidServiceImpl implements CupidService {

    @Autowired
    private CustomerMysqlDao customerMysqlDao;

    @Autowired
    private CustomerPicMysqlDao customerPicMysqlDao;

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private ShieldSPI shieldSPI;

    @Autowired
    private TrackSPI trackSPI;

    @Override
    public Customer saveOrUpdateCustomer(Customer customer) {
        if (customer == null) {
            return null;
        }
        if (StringUtils.isEmpty(customer.getPhone()) || StringUtils.isEmpty(customer.getShopCode())) {
            return null;
        }
        Customer old = null;
        if (StringUtils.isEmpty(customer.getCrmUserId())) {
            old = getByShopCodeAndPhone(customer.getShopCode(), customer.getPhone());
        } else {
            old = customerService.getCrmUserIdAndShopCode(customer.getCrmUserId(), customer.getShopCode());
            //判断是否更换电话
            if (old != null && !old.getPhone().equals(customer.getPhone())) {
                String txt = "客户手机号有更换, 新手机号" + customer.getPhone();
                SystemTrack systemTrack = new SystemTrack();
                systemTrack.setMessage(txt.toString());
                systemTrack.setType(TypeEnum.PHONE_UPDATE.getType());
                systemTrack.setUserId(old.getCrmUserId());
                systemTrack.setShopCode(old.getShopCode());
                if (StringUtils.isNotEmpty(customer.getOperator())) {
                    systemTrack.setOperatorId(customer.getOperator());
                    UserVo userVo = shieldSPI.getByUserId(customer.getOperator());
                    systemTrack.setOperatorId(userVo == null ? "" : userVo.getNickname());
                }
                trackSPI.save(systemTrack);
            }
        }
        return null;
    }

    /**
     * 店铺和电话查询
     * @param shopCode
     * @param phone
     * @return
     */
    private Customer getByShopCodeAndPhone(String shopCode, String phone) {
        if (StringUtils.isEmpty(shopCode) || StringUtils.isEmpty(phone)) {
            return null;
        }
        Map<String, String> params = new HashMap<>();
        params.put("shopCode", shopCode);
        params.put("phone", phone);
        CustomerMysql cm = customerMysqlDao.getByShopCodeAndPhone(params);
        if (cm == null) {
            return null;
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(cm, customer);
        List<CustomerPicMysql> pics = customerPicMysqlDao.getByCustomerId(customer.getId());
        if (CollectionUtils.isNotEmpty(pics)) {
            List<String> pictures = new ArrayList<>();
            for (CustomerPicMysql pic : pics) {
                pictures.add(pic.getPicture());
            }
            customer.setPictures(pictures);
        }
        return customer;
    }
}






































