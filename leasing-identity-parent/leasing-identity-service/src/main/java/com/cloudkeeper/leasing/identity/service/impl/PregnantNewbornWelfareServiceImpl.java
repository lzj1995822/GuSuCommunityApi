package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.PregnantNewbornWelfare;
import com.cloudkeeper.leasing.identity.repository.PregnantNewbornWelfareRepository;
import com.cloudkeeper.leasing.identity.service.PregnantNewbornWelfareService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

/**
 * 孕妇新生儿福利 service
 * @author ZLA
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PregnantNewbornWelfareServiceImpl extends BaseServiceImpl<PregnantNewbornWelfare> implements PregnantNewbornWelfareService {

    /** 孕妇新生儿福利 repository */
    private final PregnantNewbornWelfareRepository pregnantNewbornWelfareRepository;

    @Override
    protected BaseRepository<PregnantNewbornWelfare> getBaseRepository() {
        return pregnantNewbornWelfareRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("welfareType", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("grantAmount", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("beneficiaryName", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("beneficiaryPhone", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("address", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("geographicalPosition", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}