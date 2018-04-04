package com.zben.cupid.clue.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClueBase implements Serializable {
	private static final long serialVersionUID = -2909614395009943746L;
	/** 线索类别 */
	private String clueCategory; // 二级来源
	/** 手机号码 */
	private String handPhone;
	/** 操作类型 */
	private String operation;
	/** 平台 */
	private String platform; // 一级来源
	/** 用户id */
	private String scUserId;
	/** 店铺 */
	private String storeId;
	/** 发送时间 */
	private Long time;
	/** 发送消息内容 */
	private ClueMessageData data;
}