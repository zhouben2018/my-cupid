package com.zben.cupid.service;

import com.zben.cupid.domain.Customer;

/**
 * @Author: zben
 * @Description:
 * @Date: 下午5:50 2018/4/11
 */
public interface CustomerService {
    Customer addOrGetCustomerFroUser(String scUserId, String storeId, String source, String belongSales, String operator, String level, Integer sex);
}
