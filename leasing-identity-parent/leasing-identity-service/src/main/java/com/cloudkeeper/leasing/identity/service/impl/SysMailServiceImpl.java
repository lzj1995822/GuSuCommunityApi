package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.SysMail;
import com.cloudkeeper.leasing.identity.repository.SysMailRepository;
import com.cloudkeeper.leasing.identity.service.SysMailService;
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
public class SysMailServiceImpl extends BaseServiceImpl<SysMail> implements SysMailService {

    /** 类属性配置 repository */
    private final SysMailRepository sysMailRepository;

    @Override
    protected BaseRepository<SysMail> getBaseRepository() {
        return sysMailRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("mailName", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("mailId", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("mailBirth", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("mailPhone", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("mailCompany", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("mailDepartment", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("mailPost", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("mailAddress", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}