package com.cloudkeeper.leasing.identity.service;

import com.cloudkeeper.leasing.identity.domain.OrganizationStructure;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 类属性配置 service 测试
 * @author lxw
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrganizationStructureServiceTest {

    /** 类属性配置 service */
    @Autowired
    private OrganizationStructureService organizationStructureService;

    @Test
    public void saveTest() {
        OrganizationStructure organizationStructure = new OrganizationStructure();
        organizationStructure = organizationStructureService.save(organizationStructure);
        assertNotNull(organizationStructure.getId());
    }

}