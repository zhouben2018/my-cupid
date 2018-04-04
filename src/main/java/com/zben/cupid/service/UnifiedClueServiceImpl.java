package com.zben.cupid.service;

import com.zben.cupid.dao.UnifiedClueMysqlDao;
import com.zben.cupid.domain.UnifiedClue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zben
 * @Description:
 * @Date: 下午4:05 2018/4/4
 */
@Service
@Slf4j
public class UnifiedClueServiceImpl implements UnifiedClueService {

    @Autowired
    private UnifiedClueMysqlDao unifiedClueMysqlDao;

    public UnifiedClue findByMessageId(String messageId) {

        try {
            return unifiedClueMysqlDao.findByMessageId(messageId);
        } catch (Exception e) {
            log.debug("{}, {}", messageId, e);
            e.printStackTrace();
        }
        return null;
    }
}
