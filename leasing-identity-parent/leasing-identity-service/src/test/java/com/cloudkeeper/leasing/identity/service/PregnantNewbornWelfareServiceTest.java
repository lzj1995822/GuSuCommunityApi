package com.cloudkeeper.leasing.identity.service;

import com.cloudkeeper.leasing.identity.domain.PregnantNewbornWelfare;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 孕妇新生儿福利 service 测试
 * @author ZLA
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PregnantNewbornWelfareServiceTest {

    /** 孕妇新生儿福利 service */
    @Autowired
    private PregnantNewbornWelfareService pregnantNewbornWelfareService;

    @Test
    public void saveTest() {
        PregnantNewbornWelfare pregnantNewbornWelfare = new PregnantNewbornWelfare();
        pregnantNewbornWelfare = pregnantNewbornWelfareService.save(pregnantNewbornWelfare);
        assertNotNull(pregnantNewbornWelfare.getId());
    }

}