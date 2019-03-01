package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.PolicyPaper;
import com.cloudkeeper.leasing.identity.repository.PolicyPaperRepository;
import com.cloudkeeper.leasing.identity.service.PolicyPaperService;
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
public class PolicyPaperServiceImpl extends BaseServiceImpl<PolicyPaper> implements PolicyPaperService {

    /** 类属性配置 repository */
    private final PolicyPaperRepository policyPaperRepository;

    @Override
    protected BaseRepository<PolicyPaper> getBaseRepository() {
        return policyPaperRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("title", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("author", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("content", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("enclosure", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("organizationId", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}