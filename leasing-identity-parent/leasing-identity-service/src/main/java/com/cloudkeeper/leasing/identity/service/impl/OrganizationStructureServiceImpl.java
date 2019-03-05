package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.OrganizationStructure;
import com.cloudkeeper.leasing.identity.repository.OrganizationStructureRepository;
import com.cloudkeeper.leasing.identity.service.OrganizationStructureService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

/**
 * 组织架构 service
 * @author lxw
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrganizationStructureServiceImpl extends BaseServiceImpl<OrganizationStructure> implements OrganizationStructureService {

    /** 类属性配置 repository */
    private final OrganizationStructureRepository organizationStructureRepository;

    @Override
    protected BaseRepository<OrganizationStructure> getBaseRepository() {
        return organizationStructureRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("sex", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("duties", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("aliasName", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("departmentId", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("position", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("contact", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("superior", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("picture", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}
