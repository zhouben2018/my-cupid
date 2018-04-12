package com.zben.cupid.service;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import com.zben.cupid.clue.model.CUser;
import com.zben.cupid.dao.CustomerMysqlDao;
import com.zben.cupid.dao.CustomerPicMysqlDao;
import com.zben.cupid.domain.Customer;
import com.zben.cupid.domain.CustomerMysql;
import com.zben.cupid.domain.CustomerPicMysql;
import com.zben.cupid.enums.CustomerLevelConstant;
import com.zben.cupid.shield.api.UserService;
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
 * @Date: 下午3:57 2018/4/12
 */
@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerMysqlDao customerMysqlDao;

    @Autowired
    private CustomerPicMysqlDao customerPicMysqlDao;

    @Override
    public Customer addOrGetCustomerFroUser(String scUserId, String storeId, String source,
                                            String belongSales, String operator, String cocLevel, Integer sex) {
        if (scUserId == null) {
            return null;
        }
        CUser cUser = userService.getCrmId(scUserId);
        if (cUser == null) {
            log.info("user is not exist, userId is " + scUserId);
            return null;
        }

        Customer oldCustomer = getCrmUserIdAndShopCode(scUserId, storeId);
        if (null != oldCustomer) {
            return oldCustomer;
        }
        oldCustomer = Customer.builder().crmUserId(scUserId)
                .phone(cUser.getPhone()).name(cUser.getName()).shopCode(storeId)
                .belongSales(belongSales).sex(sex).operator(operator)
                .createType(5).build();
        String level = getCustomerLevel(cocLevel);
        if (level != null) {
            oldCustomer.setLevel(level);
        }


        return null;
    }

    private String getCustomerLevel(String cocLevel) {
        if(StringUtils.isEmpty(cocLevel)){
            return null;
        }
        if("H".equals(cocLevel)){
            return CustomerLevelConstant.BUYER_H_LEVEL.getCode();
        }
        if("A".equals(cocLevel)){
            return CustomerLevelConstant.BUYER_A_LEVEL.getCode();
        }
        if("B".equals(cocLevel)){
            return CustomerLevelConstant.BUYER_B_LEVEL.getCode();
        }
        if("C".equals(cocLevel)){
            return CustomerLevelConstant.BUYER_C_LEVEL.getCode();
        }
        if("L".equals(cocLevel)){
            return CustomerLevelConstant.BUYER_L_LEVEL.getCode();
        }
        return null;
    }

    /**
     * 根据crmUserId和shopCode
     * @param scUserId
     * @param storeId
     * @return
     */
    private Customer getCrmUserIdAndShopCode(String scUserId, String storeId) {
        if (StringUtils.isEmpty(scUserId) || StringUtils.isEmpty(storeId)) {
            return null;
        }
        Map<String, String> params = new HashMap<>();
        params.put("crmUserId", scUserId);
        params.put("shopCode", storeId);
        CustomerMysql cm = customerMysqlDao.getCrmUserIdAndShopCode(params);
        Customer customer = new Customer();
        if (cm == null) {
            return null;
        }
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




















































