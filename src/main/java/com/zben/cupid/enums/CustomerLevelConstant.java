package com.zben.cupid.enums;

import lombok.Getter;

/**
 * @Author: zben
 * @Description:
 * @Date: 下午6:12 2018/4/12
 */
@Getter
public enum CustomerLevelConstant {
    BUYER_A_LEVEL("buyer_A_level"),//A级
    BUYER_B_LEVEL("buyer_B_level"),//B级
    BUYER_C_LEVEL("buyer_C_level"),//C级
    BUYER_H_LEVEL("buyer_H_level"),//H级
    BUYER_S_LEVEL("buyer_S_level"),//休眠
    BUYER_F_LEVEL("buyer_F_level"),//战败
    BUYER_L_LEVEL("buyer_L_level"),//无效
    BUYER_D_LEVEL("buyer_D_level"),//交车
    BUYER_O_LEVEL("buyer_O_level"),//成交
    ;

    private String code;

    CustomerLevelConstant(String code) {
        this.code = code;
    }
}
