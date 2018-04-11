package com.zben.cupid.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: zben
 * @Description:线索车辆
 * @Date: 上午11:30 2018/4/11
 */
@Data
public class ClueCar implements Serializable {
    private static final long serialVersionUID = 5922178868321267601L;

    @ApiModelProperty("carid")
    protected String ID;

    protected String carShortName;

    protected String registerDate;

    protected String pictures;

    protected String shopCode;

    @ApiModelProperty("跳转链接")
    protected String jumpLink;

    @ApiModelProperty("排放")
    protected String emissions;

    @ApiModelProperty("价格")
    protected String price;

    @ApiModelProperty("指导价")
    protected String priceGuide;

    @ApiModelProperty("品牌")
    protected String brand;
    protected String brandCode;

    @ApiModelProperty("车型")
    protected String model;
    protected String modelCode;

    @ApiModelProperty("车系")
    protected String series;
    protected String seriesCode;

    @ApiModelProperty("上牌时间")
    protected String cardTime;

    @ApiModelProperty("里程")
    protected String mile;

    @ApiModelProperty("状态")
    protected String carStatus;

    @ApiModelProperty("H5 地址")
    protected String html5Url;

    @ApiModelProperty("喜欢")
    protected String like;

    @ApiModelProperty("其他内容")
    protected String memo;

    @ApiModelProperty("是否是弹个车新车")
    protected String isNewCar;

    @ApiModelProperty("是否是弹个车")
    protected String isLeaseCar;

    @ApiModelProperty("操作人")
    protected String operator;
}


































