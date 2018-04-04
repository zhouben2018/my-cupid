package com.zben.cupid.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: zben
 * @Description:
 * @Date: 下午3:27 2018/4/4
 */
public class BaseDomain implements Serializable {
    private static final long serialVersionUID = 2076310985810497033L;

    private long dateCreate;

    @JsonIgnore
    private long dateUpdate;

    @JsonIgnore
    private long dateDelete;

    @JsonIgnore
    private Date timeCreate;

    @JsonIgnore
    private Date timeUpdate;

    @JsonIgnore
    private Date timeDelete;

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


    public long getDateUpdate() {
        if(this.timeUpdate!=null){
            return this.timeUpdate.getTime();
        }
//		if(this.dateUpdate==0){
//			return System.currentTimeMillis();
//		}
        return dateUpdate;
    }


    public void setDateUpdate(long dateUpdate) {
        this.dateUpdate = dateUpdate;
    }


    public long getDateDelete() {
        if(this.timeDelete!=null){
            return this.timeDelete.getTime();
        }
        return dateDelete;
    }
    public void setDateDelete(long dateDelete) {
        this.dateDelete = dateDelete;
    }


    public Date getTimeCreate() {
        if(this.getDateCreate()!=0&&this.timeCreate==null){
            return new Date(this.getDateCreate());
        }
        return timeCreate;
    }


    public void setTimeCreate(Date timeCreate) {
        this.timeCreate = timeCreate;
    }


    public Date getTimeUpdate() {
        if(this.getDateUpdate()!=0&&this.timeUpdate==null){
            return new Date(this.getDateUpdate());
        }
        return timeUpdate;
    }


    public void setTimeUpdate(Date timeUpdate) {
        this.timeUpdate = timeUpdate;
    }


    public Date getTimeDelete() {
        if(this.getDateDelete()!=0&&this.timeDelete==null){
            return new Date(this.getDateDelete());
        }
        return timeDelete;
    }


    public void setTimeDelete(Date timeDelete) {
        this.timeDelete = timeDelete;
    }
}
