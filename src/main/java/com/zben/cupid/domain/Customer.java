package com.zben.cupid.domain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: zben
 * @Description:
 * @Date: 下午5:16 2018/4/11
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("客户")
public class Customer extends BaseDomain {
    private static final long serialVersionUID = -5732179517670315985L;

    //@Validate(require=false,failMessage="改客户不存在或者你没有权限操作该客户", userDefinedMethod="com.souche.cupid.validate.SecurityCheck.checkCustomerId")
    private String id="";

    private long sequence;

    private String crmUserId="";

    //	@Validate(failMessage="手机号码不能为空或者长度不能超过20")
    @ApiModelProperty("手机号码")
    private String phone="";

    @ApiModelProperty("名称")
    private String name="";

    @ApiModelProperty("店铺")
    private String shopCode="";

    @ApiModelProperty("性别/0-男/1-女")
    private Integer sex;

    //	@Validate(failMessage="来源不能为空")
    @ApiModelProperty("来源")
    private String source;

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
    private String alipayAccount="";

    @ApiModelProperty("淘宝账号")
    private String taobaoAccount="";

    @ApiModelProperty("地址")
    private String address="";

    @ApiModelProperty("操作人")
    private String operator="";

    @ApiModelProperty("归属销售/空无，销售经理be_allocated")
    private String belongSales="";

    private String belongAppraiser;

    @ApiModelProperty("卖家标签/1有")
    private int sellerLable;

    @ApiModelProperty("上传的图片")
    private List<String> pictures=new ArrayList<String>();

    @ApiModelProperty("coc客户级别")
    private String cocLevel;

    @ApiModelProperty("客户级别")
    private String level;

    private int createType;

    private String creator="";

    @ApiModelProperty("扩展字段")
    private String ext="";

    private long followTime;

    private Date cocFollowTime;

    private Date levelChangeTime;

    @JsonIgnore
    private  boolean isBeAllocated=false;

    @JsonIgnore
    private int isArriveShop;

    private boolean isEx=false;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        if(StringUtils.isNotEmpty(this.phone)&&this.phone.contains("!_!")){
            return phone.split("!_!")[0];
        }
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }


    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }


    public String getDdSource() {
        return ddSource;
    }

    public void setDdSource(String ddSource) {
        this.ddSource = ddSource;
    }

    public String getBackupPhone() {
        return backupPhone;
    }

    public void setBackupPhone(String backupPhone) {
        this.backupPhone = backupPhone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }


    public long getBirthday() {
        return birthday;
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    /**
     * level为无效的时候，销售归属为空
     * @return
     */
    public String getBelongSales() {
        if(StringUtils.isNotEmpty(this.level)&& "buyer_L_level".equals(this.level)){
            return "";
        }
        return belongSales;
    }

    public void setBelongSales(String belongSales) {
        this.belongSales = belongSales;
    }


    public List<String> getPictures() {
        return pictures;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public long getSequence() {
        return sequence;
    }

    public void setSequence(long sequence) {
        this.sequence = sequence;
    }


    public int getSellerLable() {
        return sellerLable;
    }

    public void setSellerLable(int sellerLable) {
        this.sellerLable = sellerLable;
    }

    public String getCrmUserId() {
        return crmUserId;
    }

    public void setCrmUserId(String crmUserId) {
        this.crmUserId = crmUserId;
    }


    public int getCreateType() {
        return createType;
    }

    public void setCreateType(int createType) {
        this.createType = createType;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }



    public Date getLevelChangeTime() {
        return levelChangeTime;
    }

    public void setLevelChangeTime(Date levelChangeTime) {
        this.levelChangeTime = levelChangeTime;
    }

    public String getAlipayAccount() {
        return alipayAccount;
    }

    public void setAlipayAccount(String alipayAccount) {
        this.alipayAccount = alipayAccount;
    }

    public String getTaobaoAccount() {
        return taobaoAccount;
    }

    public void setTaobaoAccount(String taobaoAccount) {
        this.taobaoAccount = taobaoAccount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getFollowTime() {
        return followTime;
    }

    public void setFollowTime(long followTime) {
        this.followTime = followTime;
    }

    public boolean isBeAllocated() {
        return isBeAllocated;
    }

    public void setBeAllocated(boolean isBeAllocated) {
        this.isBeAllocated = isBeAllocated;
    }


    public int getIsArriveShop() {
        return isArriveShop;
    }

    public void setIsArriveShop(int isArriveShop) {
        this.isArriveShop = isArriveShop;
    }


    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public JSONObject getExtJson(){
        if(StringUtils.isEmpty(this.ext)){
            return null;
        }
        try{
            return JSON.parseObject(this.ext);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public boolean isEx() {
        return isEx;
    }

    public void setEx(boolean isEx) {
        this.isEx = isEx;
    }


    public String getBelongAppraiser() {
        return belongAppraiser;
    }

    public void setBelongAppraiser(String belongAppraiser) {
        this.belongAppraiser = belongAppraiser;
    }


    public String getFirstSource() {
        return firstSource;
    }

    public void setFirstSource(String firstSource) {
        this.firstSource = firstSource;
    }

    public String getSecondSource() {
        return secondSource;
    }

    public void setSecondSource(String secondSource) {
        this.secondSource = secondSource;
    }

    public String getThirdSource() {
        return thirdSource;
    }

    public void setThirdSource(String thirdSource) {
        this.thirdSource = thirdSource;
    }

    public String getCocLevel() {
        return cocLevel;
    }

    public void setCocLevel(String cocLevel) {
        this.cocLevel = cocLevel;
    }

    public Date getCocFollowTime() {
        return cocFollowTime;
    }

    public void setCocFollowTime(Date cocFollowTime) {
        this.cocFollowTime = cocFollowTime;
    }
}






































