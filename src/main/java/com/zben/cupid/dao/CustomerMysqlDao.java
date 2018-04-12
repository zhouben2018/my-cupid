package com.zben.cupid.dao;

import com.zben.cupid.domain.CustomerMysql;

import java.util.Map;

/**
 * @Author: zben
 * @Description:
 * @Date: 下午4:56 2018/4/12
 */
public interface CustomerMysqlDao {
    CustomerMysql getCrmUserIdAndShopCode(Map map);
}
