package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.SupervisoryCommittee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 类属性配置 repository 测试
 * @author cqh
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SupervisoryCommitteeRepositoryTest {

    /** 类属性配置 repository */
    @Autowired
    private SupervisoryCommitteeRepository supervisoryCommitteeRepository;

    @Test
    public void saveTest() {
        SupervisoryCommittee supervisoryCommittee = new SupervisoryCommittee();
        supervisoryCommittee = supervisoryCommitteeRepository.save(supervisoryCommittee);
        assertNotNull(supervisoryCommittee.getId());
    }

}