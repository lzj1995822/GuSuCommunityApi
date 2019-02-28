package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.PartyMemberExcellent;
import com.cloudkeeper.leasing.identity.repository.PartyMemberExcellentRepository;
import com.cloudkeeper.leasing.identity.service.PartyMemberExcellentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

/**
 * 优秀党员 service
 * @author lxw
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PartyMemberExcellentServiceImpl extends BaseServiceImpl<PartyMemberExcellent> implements PartyMemberExcellentService {

    /** 优秀党员 repository */
    private final PartyMemberExcellentRepository partyMemberExcellentRepository;

    @Override
    protected BaseRepository<PartyMemberExcellent> getBaseRepository() {
        return partyMemberExcellentRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("userName", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("identityNumber", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("userSex", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("userNation", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("education", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("partyOrg", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}
