package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.Factory;
import com.cloudkeeper.leasing.identity.repository.FactoryRepository;
import com.cloudkeeper.leasing.identity.service.FactoryService;
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
public class FactoryServiceImpl extends BaseServiceImpl<Factory> implements FactoryService {

    /** 类属性配置 repository */
    private final FactoryRepository factoryRepository;

    @Override
    protected BaseRepository<Factory> getBaseRepository() {
        return factoryRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("address", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("mapAddress", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("constructionDate", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("area", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("production", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}