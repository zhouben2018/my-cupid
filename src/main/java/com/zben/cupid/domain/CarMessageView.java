package com.zben.cupid.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: zben
 * @Description:
 * @Date: 上午11:09 2018/4/11
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarMessageView extends BaseMessageBody {
    private static final long serialVersionUID = 1250147048223622764L;

    @ApiModelProperty("线索类型")
    private String clueType;

    @ApiModelProperty("标题栏")
    private String titleBar = "";

    @ApiModelProperty("分类命名")
    private String categoryName;

    @ApiModelProperty("分类颜色RGB值")
    private String categoryColor;

    @ApiModelProperty("车辆信息")
    private String followMark;

    @ApiModelProperty("事件来源")
    private String eventSource;

    private String platform;

    private List<ClueCar> cars;
}





























