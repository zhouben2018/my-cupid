package com.zben.cupid.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author: zben
 * @Description:
 * @Date: 下午5:07 2018/4/12
 */
@Data
public class CustomerMysql extends BaseDomain {
    private static final long serialVersionUID = -6833069403626329374L;

    private String id="";

    private long sequence;

    private String crmUserId="";

    @ApiModelProperty("手机号码")
    private String phone="";

    @ApiModelProperty("名称")
    private String name="";

    @ApiModelProperty("店铺")
    private String shopCode="";

    @ApiModelProperty("集团")
    private Integer siteId;

    @ApiModelProperty("性别/0-男/1-女")
    private Integer sex;

    @ApiModelProperty("来源")
    private String source="";

    @ApiModelProperty("一级类别来源")
    private String firstSource;

    @ApiModelProperty("二级类别来源")
    private String secondSource;

    @ApiModelProperty("三级类别来源")
    private String thirdSource;

    @ApiModelProperty("dd来源")
    private String ddSource="";

    @ApiModelProperty("备胎手机")
    private String backupPhone="";

    @ApiModelProperty("身份证号码")
    private String identificationNumber="";

    @ApiModelProperty("QQ")
    private String qq="";

    @ApiModelProperty("微信")
    private String wechat="";

    @ApiModelProperty("省份")
    private String province="";

    @ApiModelProperty("城市")
    private String city="";

    @ApiModelProperty("地区")
    private String district="";

    @ApiModelProperty("生日")
    private long birthday;

    @ApiModelProperty("备注")
    private String remark="";

    @ApiModelProperty("支付宝账号")
    private String alipayAccount;

    @ApiModelProperty("淘宝账号")
    private String taobaoAccount;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("操作人")
    private String operator="";

    @ApiModelProperty("归属销售")
    private String belongSales="";

    @ApiModelProperty("归属评估师")
    private String belongAppraiser="";

    @ApiModelProperty("卖家标签/1有")
    private int sellerLable;

    @ApiModelProperty("coc客户等级")
    private String cocLevel;

    /**
     * 用于订单取消后，将客户级别修改会下单前状态
     */
    @ApiModelProperty("下单前客户级别")
    private String beforeOrderLevel="";

    @ApiModelProperty("客户级别")
    private String level="";

    private String creator="";

    private int createType;

    private String ext;

    @ApiModelProperty("用户轨迹的最后跟进时间")
    private long followTime;

    private Date levelChangeTime;

    private Date cocFollowTime;//coc同步客户跟进时间

    private Date followTimeDate;

    private int isArriveShop;


}
