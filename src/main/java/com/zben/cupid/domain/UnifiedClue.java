package com.zben.cupid.domain;

import lombok.Data;

import java.util.Date;

/**
 * @Author: zben
 * @Description:
 * @Date: 下午3:26 2018/4/4
 */
@Data
public class UnifiedClue extends BaseDomain {
    private static final long serialVersionUID = 5776770536287498523L;
    private String id;
    private String messageId;
    private String clueCategory;
    private String clueType;
    private String operation;
    private Integer isFiltered;
    private String platform;
    private String platform3;
    private String storeId;
    private String carId;
    private String userId;
    private String serieses;
    private Integer priceLow;
    private Integer priceHeight;
    private Integer ageLow;
    private Integer ageHeight;
    private String structures;
    private String carLevels;
    private String colors;
    private String series;
    private Integer price;
    private Date firstLicensePlateDate;
    private Integer mileage;
    private String remark;
    private Date clueCreateTime;
    private String clueJson;
}
