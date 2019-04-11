package com.cloudkeeper.leasing.identity.service;

import com.cloudkeeper.leasing.identity.domain.FireFacilities;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 消防设施 service 测试
 * @author ZLA
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FireFacilitiesServiceTest {

    /** 消防设施 service */
    @Autowired
    private FireFacilitiesService fireFacilitiesService;

    @Test
    public void saveTest() {
        FireFacilities fireFacilities = new FireFacilities();
        fireFacilities = fireFacilitiesService.save(fireFacilities);
        assertNotNull(fireFacilities.getId());
    }

}