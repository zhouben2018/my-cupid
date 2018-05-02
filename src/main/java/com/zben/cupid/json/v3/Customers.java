package com.zben.cupid.json.v3;

import com.zben.cupid.domain.query.CustomerQuery;
import com.zben.cupid.domain.view.CustomerStatusCountView;
import com.zben.cupid.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: zben
 * @Description:
 * @Date: 下午1:56 2018/4/26
 */
@Api(value = "customer_v3", description = "客户相关")
public class Customers {


    @ApiOperation("客户列表分页v3")
    @PostMapping(value = "dashboard")
    public Result<List<CustomerStatusCountView>> getDashboard(@RequestParam(value = "shopCode") String shopCode,
                                                              @RequestParam(value = "department") String department,
                                                              @RequestParam(value = "departments") List<String> departments,
                                                              @RequestParam(value = "belongSales") String belongSales,
                                                              @RequestParam(value = "belongSaleses") List<String> belongSaleses,
                                                              @RequestParam(value = "customerStatus") String customerStatus) {

        Result<List<CustomerStatusCountView>> result = new Result<>();
        //组装查询条件
        CustomerQuery query = new CustomerQuery();
        if (StringUtils.isNotEmpty(shopCode) && AuthNHolder)
        return null;
    }
}







































