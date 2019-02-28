package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.UnionMember;
import com.cloudkeeper.leasing.identity.repository.UnionMemberRepository;
import com.cloudkeeper.leasing.identity.service.UnionMemberService;
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
public class UnionMemberServiceImpl extends BaseServiceImpl<UnionMember> implements UnionMemberService {

    /** 类属性配置 repository */
    private final UnionMemberRepository unionMemberRepository;

    @Override
    protected BaseRepository<UnionMember> getBaseRepository() {
        return unionMemberRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("code", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("sex", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("userNation", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("education", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("married", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("nativePlace", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("skillLevel", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("workDepartments", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("familMembers", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("resume", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}