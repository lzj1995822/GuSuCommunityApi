package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.Teenagers;
import com.cloudkeeper.leasing.identity.repository.TeenagersRepository;
import com.cloudkeeper.leasing.identity.service.TeenagersService;
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
public class TeenagersServiceImpl extends BaseServiceImpl<Teenagers> implements TeenagersService {

    /** 类属性配置 repository */
    private final TeenagersRepository teenagersRepository;

    @Override
    protected BaseRepository<Teenagers> getBaseRepository() {
        return teenagersRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("sex", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("politicalStatus", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("school", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("grade", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("contact", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("address", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}