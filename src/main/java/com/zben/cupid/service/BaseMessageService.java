package com.zben.cupid.service;

import com.zben.cupid.clue.model.ClueBase;
import com.zben.cupid.domain.BaseMessageBody;
import com.zben.cupid.domain.CarMessageView; /**
 * @Author: zben
 * @Description:
 * @Date: 上午11:03 2018/4/11
 */
public interface BaseMessageService {

    //保存线索
    String saveAndDetail(BaseMessageBody baseMessageBody, ClueBase clue, String isNewCar, String isLeaseCar);
}
