package com.zben.cupid.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;

/**
 * @Author: zben
 * @Description:
 * @Date: 下午5:20 2018/4/12
 */
public class CustomerPicMysql {
    public static final String IMG_PREFIX="http://img.souche.com/";

    private int id;

    private String customerId;

    private String picture;

    private int sortIndex;

    @JsonIgnore
    private long dateCreate;

    @JsonIgnore
    private Date timeCreate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * 兼容没加上前缀的图片
     * @return
     */
    public String getPicture() {
        if(StringUtils.isNotEmpty(this.picture)&&!this.picture.startsWith("http")){
            this.picture=IMG_PREFIX+this.picture;
        }
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public long getDateCreate() {
        if(this.timeCreate!=null){
            return this.timeCreate.getTime();
        }
        if(this.dateCreate==0){
            return System.currentTimeMillis();
        }
        return dateCreate;
    }

    public void setDateCreate(long dateCreate) {
        this.dateCreate = dateCreate;
    }

    public int getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(int sortIndex) {
        this.sortIndex = sortIndex;
    }

    public Date getTimeCreate() {
        if(this.getDateCreate()!=0){
            return new Date(this.getDateCreate());
        }
        return timeCreate;
    }

    public void setTimeCreate(Date timeCreate) {
        this.timeCreate = timeCreate;
    }



}
