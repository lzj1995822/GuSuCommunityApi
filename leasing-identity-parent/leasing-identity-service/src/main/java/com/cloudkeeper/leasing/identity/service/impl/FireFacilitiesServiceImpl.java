package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.FireFacilities;
import com.cloudkeeper.leasing.identity.repository.FireFacilitiesRepository;
import com.cloudkeeper.leasing.identity.service.FireFacilitiesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

/**
 * 消防设施 service
 * @author ZLA
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FireFacilitiesServiceImpl extends BaseServiceImpl<FireFacilities> implements FireFacilitiesService {

    /** 消防设施 repository */
    private final FireFacilitiesRepository fireFacilitiesRepository;

    @Override
    protected BaseRepository<FireFacilities> getBaseRepository() {
        return fireFacilitiesRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("equipmentType", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("equipmentNumber", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("validityPeriod", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("masterName", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("masterPhone", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("geographicalPosition", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}