package com.zben.cupid.clue.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ClueMessageData implements Serializable {
	private static final long serialVersionUID = 2161871373650237728L;
	/** 消息id */
	private String id;
	/** app id */
	private Integer app_id;
	/** app 平台 */
	private String app_platform;
	/** 线索创建时间 */
	private Long clue_date_create;
	/** 来路网址 */
	private String referer;
	/** 车辆id */
	private String sc_car_id;
	/***
	 * 评估师id
	 */
	private String appraiser_id;
	/** 销售id */
	private String salesperson_id;
	/** 来源 */
	private String source_text;
	/**
	 * yf 三级来源
	 */
	private String platform3;
	/**
	 * 客户等级
	 */
	private String level;
	/**
	 * coc同步客户跟进时间
	 */
	private String follow_time;
	
	/**
	 * coc跟进记录
	 */
	private String comment;
	
	/** site id */
	private Integer site_id;
	private String called_phone;
	private Integer intent_price_low;
	private String intent_series;
	private Integer intent_price_height;
	private String intent_structure;
	private String intent_car_level;
	private Integer intent_age_height;
	private Integer intent_age_low;
	private String vin_code;
	private Integer mileage;
	private Long first_reg_time;
	private String tp_car_model_name;
	private Integer sale_price;
	private String calling_phone;
	private String calling_city;
	private String calledFlag;
	private String clue_id;
	private String handPhone;
	private String tp_car_id;
	private String tp_dealer_id;
	private String store_id;
	private String c_name;
	private String order_type;
	private String tp_seq_id;
	private String series_code;
	private String model_code;
	private List<String> models;
	private List<String> models_code;
	private String brand_code;
	private String car_province_name;
	private String car_city_name;
	private String hope_expect_time;
	private String reason;
	private String description;
	private String intent_colors;
	private String color_name;
	private String car_city_code;
	private String car_province_code;
	private String flowId;
	private String tp_user_id;
	private String tp_brand_name;
	private Integer duration;
	private String other_id;
	private String reply;
	private String series_name;
	private String brand_name;
	private String model_name;
	private String intent_min_mileage;
	private String intent_max_mileage;
	private String tp_series_name;
	private String remark;
	private String o_brand_code;
	private String o_brand_name;
	private String o_series_code;
	private String o_series_name;
	private String type;
	private String o_model_code;
	private String o_model_name;
	private String is_reply;
	private String is_send_sms;
	private String address;
	private String sc_user_id;
	private Tag tag;
}
