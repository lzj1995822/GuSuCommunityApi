package com.cloudkeeper.leasing.identity.service;

import com.cloudkeeper.leasing.identity.domain.Teenagers;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 类属性配置 service 测试
 * @author cqh
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TeenagersServiceTest {

    /** 类属性配置 service */
    @Autowired
    private TeenagersService teenagersService;

    @Test
    public void saveTest() {
        Teenagers teenagers = new Teenagers();
        teenagers = teenagersService.save(teenagers);
        assertNotNull(teenagers.getId());
    }

}