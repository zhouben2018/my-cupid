package com.zben.cupid.domain.view;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: zben
 * @Description:
 * @Date: 下午2:03 2018/4/26
 */
@Data
public class CustomerStatusCountView implements Serializable {
    private static final long serialVersionUID = 5537827959460219451L;

    @ApiModelProperty("状态")
    private String status;

    @ApiModelProperty("状态标签")
    private String statusLabel;

    @ApiModelProperty("状态标签名称")
    private String statusLabelName;

    @ApiModelProperty("客户数")
    private int count;

    @ApiModelProperty("埋点ID")
    private String buryId;
}
































