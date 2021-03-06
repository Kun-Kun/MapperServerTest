package com.softgroup.authorization.impl.data;

import com.softgroup.authorization.api.cache.ConfirmationRegisterCache;
import com.softgroup.authorization.impl.config.AuthorizationAppCfg;
import com.softgroup.common.conf.SmsServiceAppCfg;
import com.softgroup.common.dao.impl.configuration.CommonDaoAppCfg;
import com.softgroup.common.datamapper.configuration.DataMapperAppCfg;
import com.softgroup.token.config.TokenServiceAppCfg;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by user on 13.04.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AuthorizationAppCfg.class, DataMapperAppCfg.class, TokenServiceAppCfg.class, SmsServiceAppCfg.class, CommonDaoAppCfg.class})
public class ConfirmationRegisterCacheTest {

    @Autowired
    private ConfirmationRegisterCache cache1;

    @Autowired
    private ConfirmationRegisterCache cache2;
    @Test
    public void checkCacheServiceSingleton() throws Exception {
        assertNotNull(cache1);
        assertEquals(cache1,cache2);
    }

}