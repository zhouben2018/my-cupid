package com.zben.cupid.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: zben
 * @Description:
 * @Date: 上午11:09 2018/4/11
 */
@Data
public class BaseMessageBody extends BaseDomain {
    private static final long serialVersionUID = -4422474600930260300L;

    private String id;

    private String storeId;

    /**
     * 消息来源
     */
    private String source;
    /**
     * 事件名称
     */
    private String event;

    @JSONField(serialize = false)
    private String extType;

    /**
     * 操作人
     */
    @ApiModelProperty("操作人")
    private String operator;

    @JsonIgnore
    private String jsonBody;

}






































