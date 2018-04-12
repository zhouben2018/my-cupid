package com.zben.cupid.dao;

import com.zben.cupid.domain.CustomerPicMysql;

import java.util.List;

/**
 * @Author: zben
 * @Description:
 * @Date: 下午5:22 2018/4/12
 */
public interface CustomerPicMysqlDao {
    List<CustomerPicMysql> getByCustomerId(String id);
}
