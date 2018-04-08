package com.zben.cupid.remote;

/**
 * @Author: zben
 * @Description:
 * @Date: 上午9:34 2018/4/8
 */
public interface ClueTraceSPI {

    /**
     * 添加线索轨迹信息
     * @param userId
     * @param storeId
     * @param operator
     * @param key
     * @param value
     */
    void addClueTrace(String userId, String storeId, String operator, String key, Object value);
}
