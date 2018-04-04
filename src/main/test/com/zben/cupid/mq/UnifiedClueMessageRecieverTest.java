package com.zben.cupid.mq;

import com.alibaba.fastjson.JSON;
import com.zben.cupid.clue.model.ClueBase;
import com.zben.cupid.clue.process.BuyCarClueProcessor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @Author: zben
 * @Description:
 * @Date: 下午4:23 2018/4/4
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UnifiedClueMessageRecieverTest {

    @Autowired
    private BuyCarClueProcessor buyCarClueProcessor;

    @Test
    public void onRecived() {
        String clueJson =  "{\"clue_category\":\"che168_sale_clue_3\",\"handphone\":\"0311-66662680\",\"operation\":\"ADD\",\"platform\":\"che168\",\"time\":1500009361209,\"_msgId\":\"0A9708A300002A9F00001ADBB2127B3C\",\"data\":{\"tp_series_name\":[],\"clue_category\":\"che168_sale_clue_3\",\"tag\":{\"auth_user\":false},\"type\":\"电话\",\"serial_version_uid\":1,\"date_update\":1500009360000,\"clue_id\":\"8599879\",\"tp_dealer_id\":\"234640\",\"brand_name\":\"\",\"model_name\":\"\",\"id\":\"OvAVSNcqAGext\",\"level\":\"buyer_B_level\",\"struct\":[],\"description\":\"\",\"model_code\":\"\",\"site\":\"che168\",\"handphone\":\"0311-66662680\",\"platform\":\"che168\",\"date_create\":1500009360000,\"clue_date_create\":1500002199000,\"status\":0,\"series_name\":\"\",\"store_id\":\"00102217\",\"site_id\":565436,\"brand_code\":\"\",\"sc_user_id\":\"61Oattq4b4\",\"duration\":118,\"source\":\"二手车之家\",\"other_id\":\"che168_8599879_1499973399_008695\",\"operate\":\"ADD\",\"referer\":\"\",\"created_time\":\"2017-07-14 13:16:00\",\"souche_dealer_type\":\"business\",\"series_code\":\"\",\"follow_time\":\"2013-12-14 22:06:10\"},\"store_id\":\"00102217\",\"sc_user_id\":\"aecLQGGyPy\"}";
        ClueBase clueBase = JSON.parseObject(clueJson,ClueBase.class);
        System.out.println("1");
        buyCarClueProcessor.process(clueBase);
    }
}