package com.zben.cupid.clue.process;

import com.alibaba.fastjson.JSON;
import com.zben.cupid.clue.model.ClueBase;
import com.zben.cupid.clue.model.ClueMessageData;
import com.zben.cupid.domain.UnifiedClue;
import com.zben.cupid.service.UnifiedClueService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: zben
 * @Description:线索过滤器
 * @Date: 下午3:19 2018/4/4
 */
@Slf4j
public abstract class AbstractClueProcessor {

    @Autowired
    protected UnifiedClueService unifiedClueService;

    public boolean process(final ClueBase clue) {
        String shopCode = clue.getStoreId();
        if (StringUtils.isNotBlank(shopCode)) {
            clue.setStoreId(shopCode.trim());
        }
        //验证必填项
        if (!this.validate(clue)) {
            log.info("线索必填项校验不通过被遗弃：{}", JSON.toJSONString(clue));
            return false;
        }

        //保存线索
        this.saveClue(clue);
        return false;
    }

    private boolean saveClue(ClueBase clue) {
        ClueMessageData messageData = clue.getData();
        UnifiedClue dbClue = null;
        if (messageData.getId() == null) {
            log.error("messageId 为空：{}", JSON.toJSONString(clue));
            return false;
        }
        try {
            dbClue = unifiedClueService.findByMessageId(messageData.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    /**
     * 验证必填项
     * @param clue
     * @return
     */
    protected boolean validate(ClueBase clue) {
        return StringUtils.isNotEmpty(clue.getClueCategory())
                && StringUtils.isNotEmpty(clue.getHandPhone())
                && StringUtils.isNotEmpty(clue.getPlatform())
                && StringUtils.isNotEmpty(clue.getScUserId())
                && StringUtils.isNotEmpty(clue.getStoreId())
                && clue.getData() != null;
    }
}























