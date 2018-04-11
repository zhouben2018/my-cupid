package com.zben.cupid.dao;

import com.zben.cupid.domain.BaseMessageBody;

/**
 * @Author: zben
 * @Description:
 * @Date: 下午1:58 2018/4/11
 */
public interface BaseMessageMysqlDao {

    void save(BaseMessageBody baseMessageBody);
}
