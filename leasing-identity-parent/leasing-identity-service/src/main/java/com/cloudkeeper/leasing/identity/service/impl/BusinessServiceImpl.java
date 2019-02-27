package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.Business;
import com.cloudkeeper.leasing.identity.repository.BusinessRepository;
import com.cloudkeeper.leasing.identity.service.BusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

/**
 * 类属性配置 service
 * @author cqh
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class BusinessServiceImpl extends BaseServiceImpl<Business> implements BusinessService {

    /** 类属性配置 repository */
    private final BusinessRepository businessRepository;

    @Override
    protected BaseRepository<Business> getBaseRepository() {
        return businessRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("creditCode", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("legalPerson", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("businessScope", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("address", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("mapAddress", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}