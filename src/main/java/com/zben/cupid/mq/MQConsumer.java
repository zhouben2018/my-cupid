package com.zben.cupid.mq;

import java.util.Map;

/**
 * @Author: zben
 * @Description:
 * @Date: 下午3:02 2018/4/4
 */
public interface MQConsumer {
    ConsumerResult onRecived(Map<String, Object> map);
}
