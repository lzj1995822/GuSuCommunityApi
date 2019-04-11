package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.PregnantNewbornWelfare;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 孕妇新生儿福利 repository 测试
 * @author ZLA
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PregnantNewbornWelfareRepositoryTest {

    /** 孕妇新生儿福利 repository */
    @Autowired
    private PregnantNewbornWelfareRepository pregnantNewbornWelfareRepository;

    @Test
    public void saveTest() {
        PregnantNewbornWelfare pregnantNewbornWelfare = new PregnantNewbornWelfare();
        pregnantNewbornWelfare = pregnantNewbornWelfareRepository.save(pregnantNewbornWelfare);
        assertNotNull(pregnantNewbornWelfare.getId());
    }

}