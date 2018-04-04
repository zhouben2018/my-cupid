package com.zben.cupid.clue.process;

import com.alibaba.fastjson.JSON;
import com.zben.cupid.clue.model.ClueBase;
import com.zben.cupid.clue.model.ClueMessageData;
import com.zben.cupid.commons.UUIDUtil;
import com.zben.cupid.domain.UnifiedClue;
import com.zben.cupid.service.UnifiedClueService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

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
            return false;
        }
        if (dbClue != null) {
            log.error("clue already exist:{}", JSON.toJSONString(clue));
            return false;
        }
        UnifiedClue unifiedClue = UnifiedClue.builder()
                .id(UUIDUtil.getId()).ageHeight(messageData.getIntent_age_height())
                .ageLow(messageData.getIntent_age_low()).carId(messageData.getSc_car_id())
                .carLevels(messageData.getIntent_car_level()).clueCategory(clue.getClueCategory())
                .isFiltered(0).clueType(ClueType.BuyCar.name()).colors(messageData.getIntent_colors())
                .messageId(messageData.getId()).mileage(messageData.getMileage())
                .operation(clue.getOperation()).platform(clue.getPlatform()).platform3(messageData.getPlatform3())
                .price(messageData.getSale_price()).priceHeight(messageData.getIntent_price_height())
                .priceLow(messageData.getIntent_age_low()).remark(messageData.getRemark())
                .series(messageData.getIntent_series()).storeId(clue.getStoreId())
                .structures(messageData.getIntent_structure()).userId(clue.getScUserId())
                .clueJson(JSON.toJSONString(clue)).build();

        if (messageData.getClue_date_create() != null) {
            unifiedClue.setClueCreateTime(new Date(messageData.getClue_date_create()));
        }
        try {
            unifiedClueService.save(unifiedClue);
        } catch (Exception e) {
            return false;
        }

        return true;

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























