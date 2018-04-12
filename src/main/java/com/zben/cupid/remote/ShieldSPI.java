package com.zben.cupid.remote;

import com.zben.cupid.shield.model.UserVo;

/**
 * @Author: zben
 * @Description:
 * @Date: 下午3:39 2018/4/11
 */
public interface ShieldSPI {
    String getAccountById(String salespersonId);

    UserVo getUserVoByAccount(String clueSaler);
}
