package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.AssociationManagement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 协会管理 repository 测试
 * @author ZLA
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AssociationManagementRepositoryTest {

    /** 协会管理 repository */
    @Autowired
    private AssociationManagementRepository associationManagementRepository;

    @Test
    public void saveTest() {
        AssociationManagement associationManagement = new AssociationManagement();
        associationManagement = associationManagementRepository.save(associationManagement);
        assertNotNull(associationManagement.getId());
    }

}