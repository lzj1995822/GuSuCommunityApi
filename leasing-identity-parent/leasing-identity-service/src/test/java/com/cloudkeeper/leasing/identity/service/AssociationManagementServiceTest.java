package com.cloudkeeper.leasing.identity.service;

import com.cloudkeeper.leasing.identity.domain.AssociationManagement;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 协会管理 service 测试
 * @author ZLA
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class AssociationManagementServiceTest {

    /** 协会管理 service */
    @Autowired
    private AssociationManagementService associationManagementService;

    @Test
    public void saveTest() {
        AssociationManagement associationManagement = new AssociationManagement();
        associationManagement = associationManagementService.save(associationManagement);
        assertNotNull(associationManagement.getId());
    }

}