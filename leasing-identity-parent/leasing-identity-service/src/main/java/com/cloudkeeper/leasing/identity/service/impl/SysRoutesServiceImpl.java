package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.SysRoutes;
import com.cloudkeeper.leasing.identity.repository.SysRoutesRepository;
import com.cloudkeeper.leasing.identity.service.SysRoutesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

/**
 * 类属性配置 service
 * @author asher
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SysRoutesServiceImpl extends BaseServiceImpl<SysRoutes> implements SysRoutesService {

    /** 类属性配置 repository */
    private final SysRoutesRepository sysRoutesRepository;

    @Override
    protected BaseRepository<SysRoutes> getBaseRepository() {
        return sysRoutesRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("path", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("component", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("des", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}