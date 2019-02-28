package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.FamilyRecords;
import com.cloudkeeper.leasing.identity.repository.FamilyRecordsRepository;
import com.cloudkeeper.leasing.identity.service.FamilyRecordsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

/**
 * 家庭档案 service
 * @author lxw
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FamilyRecordsServiceImpl extends BaseServiceImpl<FamilyRecords> implements FamilyRecordsService {

    /** 类属性配置 repository */
    private final FamilyRecordsRepository familyRecordsRepository;

    @Override
    protected BaseRepository<FamilyRecords> getBaseRepository() {
        return familyRecordsRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("masterName", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("masterSex", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("contact", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("monthIncome", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("basicIncome", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("partyFamily", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("veteranFamily", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("hardFamily", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("disabledFamily", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}
