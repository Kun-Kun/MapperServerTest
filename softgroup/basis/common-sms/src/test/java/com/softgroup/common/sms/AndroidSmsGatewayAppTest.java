package com.softgroup.common.sms;

import com.softgroup.common.conf.SmsServiceAppCfg;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by user on 14.04.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SmsServiceAppCfg.class)
public class AndroidSmsGatewayAppTest {

    @Autowired
    private SmsService smsGateway;
    @Test
    public void send() throws Exception {
        smsGateway.send("0635658875","test msg");
    }

}