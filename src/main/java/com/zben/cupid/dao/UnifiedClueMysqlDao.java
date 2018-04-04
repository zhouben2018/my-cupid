package com.zben.cupid.dao;

import com.zben.cupid.domain.UnifiedClue;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: zben
 * @Description:
 * @Date: 下午4:06 2018/4/4
 */
public interface UnifiedClueMysqlDao {
    UnifiedClue findByMessageId(@Param("messageId") String messageId);
}
