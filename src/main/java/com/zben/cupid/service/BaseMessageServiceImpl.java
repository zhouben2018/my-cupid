package com.zben.cupid.service;

import com.alibaba.fastjson.JSON;
import com.zben.cupid.clue.model.ClueBase;
import com.zben.cupid.clue.model.ClueMessageData;
import com.zben.cupid.commons.UUIDUtil;
import com.zben.cupid.dao.BaseMessageMysqlDao;
import com.zben.cupid.dao.MessageDetailMysqlDao;
import com.zben.cupid.domain.BaseMessageBody;
import com.zben.cupid.domain.MessageDetail;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: zben
 * @Description:
 * @Date: 下午1:53 2018/4/11
 */
@Service
public class BaseMessageServiceImpl implements BaseMessageService {

    @Autowired
    private BaseMessageMysqlDao baseMessageMysqlDao;

    @Autowired
    private MessageDetailMysqlDao messageDetailMysqlDao;

    /**
     * 保存线索
     * @param baseMessageBody
     * @param clue
     * @param isNewCar
     * @param isLeaseCar
     * @return
     */
    @Override
    @Transactional("pkgouTransactionManager")
    public String saveAndDetail(BaseMessageBody baseMessageBody, ClueBase clue, String isNewCar, String isLeaseCar) {
        baseMessageBody.setId(UUIDUtil.getId());
        String str = JSON.toJSONString(baseMessageBody);
        baseMessageBody.setJsonBody(str);
        baseMessageMysqlDao.save(baseMessageBody);
        ClueMessageData clueMessageData = clue.getData();
        MessageDetail messageDetail = new MessageDetail();
        BeanUtils.copyProperties(baseMessageBody, messageDetail);
        messageDetail.setMessageId(clueMessageData.getId());
        messageDetail.setAppId(clueMessageData.getApp_id());
        messageDetail.setIsLeaseCar(0);
        messageDetail.setIsNewCar(0);
        messageDetail.setUserId(clue.getScUserId());

        messageDetailMysqlDao.save(messageDetail);
        return baseMessageBody.getId();
    }
}
































