package com.zben.cupid.mq;

import com.alibaba.fastjson.JSON;
import com.zben.cupid.clue.model.ClueBase;
import com.zben.cupid.clue.process.BuyCarClueProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @Author: zben
 * @Description:线索管理
 * @Date: 下午2:59 2018/4/4
 */
@Slf4j
public class UnifiedClueMessageReciever implements MQConsumer {

    @Autowired
    private BuyCarClueProcessor buyCarClueProcessor;

    public ConsumerResult onRecived(Map<String, Object> map) {
        if (map == null || map.size() == 0) {
            return ConsumerResult.CommitMessage;
        }
        String json = null;
        try {
            json = JSON.toJSONString(map, false);
            log.info("_msgId:{}---:{}", map.get("_msgId"), json);
            final ClueBase clue = JSON.parseObject(json, ClueBase.class);

            try {
                boolean b = buyCarClueProcessor.process(clue);
                log.info("{}", b);
            } catch (Exception e) {
                log.error("处理消息失败",e);
                e.printStackTrace();
            }
        } catch (Exception e) {
            log.error("处理消息失败",e);
            e.printStackTrace();
        } finally {
            return ConsumerResult.CommitMessage;
        }

    }
}








































































