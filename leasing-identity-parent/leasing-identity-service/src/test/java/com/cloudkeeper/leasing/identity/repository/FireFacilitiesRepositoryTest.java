package com.cloudkeeper.leasing.identity.repository;

import com.cloudkeeper.leasing.identity.domain.FireFacilities;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * 消防设施 repository 测试
 * @author ZLA
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FireFacilitiesRepositoryTest {

    /** 消防设施 repository */
    @Autowired
    private FireFacilitiesRepository fireFacilitiesRepository;

    @Test
    public void saveTest() {
        FireFacilities fireFacilities = new FireFacilities();
        fireFacilities = fireFacilitiesRepository.save(fireFacilities);
        assertNotNull(fireFacilities.getId());
    }

}