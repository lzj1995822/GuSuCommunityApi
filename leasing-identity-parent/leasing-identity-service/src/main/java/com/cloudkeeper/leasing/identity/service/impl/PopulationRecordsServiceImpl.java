package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.PopulationRecords;
import com.cloudkeeper.leasing.identity.repository.PopulationRecordsRepository;
import com.cloudkeeper.leasing.identity.service.PopulationRecordsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

/**
 * 类属性配置 service
 * @author lxw
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PopulationRecordsServiceImpl extends BaseServiceImpl<PopulationRecords> implements PopulationRecordsService {

    /** 类属性配置 repository */
    private final PopulationRecordsRepository populationRecordsRepository;

    @Override
    protected BaseRepository<PopulationRecords> getBaseRepository() {
        return populationRecordsRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("sex", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("politicalStatus", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("nativePlace", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("nation", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("education", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("married", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("idCard", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("domicilePlace", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("presentAddress", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("currentEmployer", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("contact", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("picture", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("partyFamily", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("veteranFamily", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("hardFamily", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("disabledFamily", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}