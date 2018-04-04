package com.zben.cupid.service;

import com.zben.cupid.domain.UnifiedClue;

/**
 * @Author: zben
 * @Description:
 * @Date: 下午3:34 2018/4/4
 */
public interface UnifiedClueService {

    UnifiedClue findByMessageId(String messageId) throws Exception;

    void save(UnifiedClue unifiedClue);
}
