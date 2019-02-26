package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.SupervisoryCommittee;
import com.cloudkeeper.leasing.identity.repository.SupervisoryCommitteeRepository;
import com.cloudkeeper.leasing.identity.service.SupervisoryCommitteeService;
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
public class SupervisoryCommitteeServiceImpl extends BaseServiceImpl<SupervisoryCommittee> implements SupervisoryCommitteeService {

    /** 类属性配置 repository */
    private final SupervisoryCommitteeRepository supervisoryCommitteeRepository;

    @Override
    protected BaseRepository<SupervisoryCommittee> getBaseRepository() {
        return supervisoryCommitteeRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("sex", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("idType", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("idNumber", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("contact", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("department", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("post", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("address", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}