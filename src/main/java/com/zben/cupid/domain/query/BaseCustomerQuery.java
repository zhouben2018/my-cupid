package com.zben.cupid.domain.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.regex.Pattern;

/**
 * @Author: zben
 * @Description:
 * @Date: 下午2:16 2018/4/26
 */
@Data
public class BaseCustomerQuery {
    private String phoneReg = "\\d{11}";
    protected Pattern p = Pattern.compile(phoneReg);

    @ApiModelProperty("用户id的集合, 仅用于任务列表的实现")
    private List<String> ids;

    @ApiModelProperty("uid的集合, 仅用于任务列表的实现")
    private List<String> uids;

    @ApiModelProperty("搜索框")
    private String search;

    private String shopCode;

    private Integer siteId;

    private List<String> shopCodes;

    @ApiModelProperty("销售")
    private String belongSales;

    @ApiModelProperty("销售列表")
    private List<String> belongSaleses;

    @ApiModelProperty("部门")
    private String department;

    @ApiModelProperty("部门列表")
    private List<String> departments;

    private String follower;

    private List<String> levels;

    private String level;

    @ApiModelProperty("只显示卖家，勾上填1/update（卖车需求）:有传1，没有传2，全部不传")
    private Integer sellerLable;

    @ApiModelProperty("二级客户来源")
    private String secondSource;

    @ApiModelProperty("三级客户来源")
    private String thirdSource;

    @ApiModelProperty("是否回访/1待回访")
    private Integer isVisit;

    @ApiModelProperty("是否到店/0全部/1未到店/2已到店")
    private Integer isArrive;

    @ApiModelProperty("是否跟进/0未跟进;1已跟进")
    private String isFollow;

    @ApiModelProperty("买车品牌")
    private String buyBrand;

    @ApiModelProperty("买车车系")
    private String buySeries;

    @ApiModelProperty("买车车型")
    private String buyModel;

    @ApiModelProperty("卖车品牌")
    private String sellBrand;

    @ApiModelProperty("卖车车系")
    private String sellSeries;

    @ApiModelProperty("创建时间开始")
    private long dateCreateFrom;

    @ApiModelProperty("创建时间结束")
    private long dateCreateTo;

    @ApiModelProperty("最新跟进时间开始")
    private long latestFollowTimeFrom;

    @ApiModelProperty("最新跟进时间结束")
    private long latestFollowTimeTo;

    @ApiModelProperty("最近X的跟进时间（单位s)/ex:3天即3*24*60*60")
    private long distanceCurrentOfFollowtime;

    @ApiModelProperty("回访时间开始")
    private long visitTimeFrom;

    @ApiModelProperty("回访时间结束")
    private long visitTimeTo;

    @ApiModelProperty("0/默认排序/1最新跟进时间降序/2最新跟进时间升序/3创建时间降序/4创建时间升序/5等级降序/6等级升序/7状态更新时间降序/8状态更新时间升序")
    private Integer sort;

    @ApiModelProperty("上牌时间最小值")
    private int licencePlateDateFrom;

    @ApiModelProperty("上牌时间最大值")
    private int licencePlateDateTo;

    @ApiModelProperty("预算最大值")
    private double maxBudget;

    @ApiModelProperty("预算最小值")
    private double minBudget;

    @ApiModelProperty("到店状态/none-无;once-一次;twice-二次;many-多次")
    private String arriveStatus;

    @ApiModelProperty("到店状态/none-未设置;need-待回访;overdue-过期未回访")
    private String visitStatus;

    @ApiModelProperty("最近到店时间开始")
    private long lastestArriveTimeFrom;

    @ApiModelProperty("最近到店时间结束")
    private long lastestArriveTimeTo;

    private long levelChangeTimeFrom;

    private long levelChangeTimeTo;

    private int mentionPrice;

    @ApiModelProperty("创建人,none-无创建人")
    private String creator;

    @ApiModelProperty("创建人列表")
    private List<String> creators;

    @ApiModelProperty("创建人部门")
    private String creatorDept;

    @ApiModelProperty("创建人部门列表")
    private List<String> creatorDepts;

    private Boolean isAll;

    private List<Integer> sorts;

    private int page;

    private int pageSize = 10;

    @ApiModelProperty("状态/1-未到店潜客;2-已到店潜客;3-预订客户;4-成交客户;5-无效及战败客户;")
    private String status;

    @ApiModelProperty("状态创建时间开始")
    private long statusCreateTimeFrom;

    @ApiModelProperty("状态创建时间结束")
    private long statusCreateTimeTo;

    @ApiModelProperty("状态更新时间开始")
    private long statusUpdateTimeFrom;

    @ApiModelProperty("状态创建时间结束")
    private long statusUpdateTimeTo;

    @ApiModelProperty("订单Id")
    private String orderId;

    @ApiModelProperty("订单支付类型/全款full;按揭mortgage")
    private String tradingModel;
}

































