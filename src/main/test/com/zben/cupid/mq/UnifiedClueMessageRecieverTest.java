package com.zben.cupid.mq;

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
        System.out.println("1");
    }
}