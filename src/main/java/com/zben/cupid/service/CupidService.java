package com.zben.cupid.service;

import com.zben.cupid.domain.Customer;
/**
 * @Author: zben
 * @Description:
 * @Date: 下午6:28 2018/4/12
 */
public interface CupidService {
    Customer saveOrUpdateCustomer(Customer oldCustomer);
}
