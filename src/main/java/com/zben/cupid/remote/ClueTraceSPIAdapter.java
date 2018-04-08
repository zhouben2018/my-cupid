package com.zben.cupid.remote;

import com.zben.cupid.trace.api.ClueTraceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zben
 * @Description:
 * @Date: 上午9:37 2018/4/8
 */
@Service
@Slf4j
public class ClueTraceSPIAdapter implements ClueTraceSPI {

    @Autowired
    private ClueTraceService clueTraceService;

    public void addClueTrace(String userId, String storeId, String operator, String key, Object value) {
        try {
            clueTraceService.addClueTrace(userId, storeId, operator, key, value);
        } catch (Exception e) {
            log.error("【dubbo添加线索轨迹】错误");
        }
    }
}
