package com.zben.cupid.enums;

import lombok.Data;
import lombok.Getter;

/**
 * @Author: zben
 * @Description:
 * @Date: 上午10:04 2018/4/13
 */
@Getter
public enum TypeEnum {

    PHONE_UPDATE(10),
    ;

    private Integer type;

    TypeEnum(Integer type) {
        this.type = type;
    }
}
