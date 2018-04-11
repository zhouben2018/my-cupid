package com.zben.cupid.domain;

import lombok.Data;

/**
 * @Author: zben
 * @Description:
 * @Date: 下午2:37 2018/4/11
 */
@Data
public class MessageDetail extends BaseMessageBody {
    private static final long serialVersionUID = 1917135049412205939L;

    private String userId;

    private String messageId;

    private String clueCategory;

    private String platform;

    private String platform3;

    private Integer appId;

    private Integer isLeaseCar;

    private Integer isNewCar;
}
