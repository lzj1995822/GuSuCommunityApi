package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.FisherMen;
import com.cloudkeeper.leasing.identity.repository.FisherMenRepository;
import com.cloudkeeper.leasing.identity.service.FisherMenService;
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
public class FisherMenServiceImpl extends BaseServiceImpl<FisherMen> implements FisherMenService {

    /** 类属性配置 repository */
    private final FisherMenRepository fisherMenRepository;

    @Override
    protected BaseRepository<FisherMen> getBaseRepository() {
        return fisherMenRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("sex", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("idType", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("idNumber", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("contact", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("address", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}