package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.PartyMember;
import com.cloudkeeper.leasing.identity.repository.PartyMemberRepository;
import com.cloudkeeper.leasing.identity.service.PartyMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

/**
 * 党员 service
 * @author lxw
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PartyMemberServiceImpl extends BaseServiceImpl<PartyMember> implements PartyMemberService {

    /** 类属性配置 repository */
    private final PartyMemberRepository partyMemberRepository;

    @Override
    protected BaseRepository<PartyMember> getBaseRepository() {
        return partyMemberRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("userName", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("identityNumber", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("userSex", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("userNation", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("education", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("partyOrg", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("userJob", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("userAddress", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("phoneNumber", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("fixedTelephone", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}
