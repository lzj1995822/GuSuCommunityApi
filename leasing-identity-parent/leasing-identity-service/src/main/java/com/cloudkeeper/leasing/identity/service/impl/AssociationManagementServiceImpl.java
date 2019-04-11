package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.AssociationManagement;
import com.cloudkeeper.leasing.identity.repository.AssociationManagementRepository;
import com.cloudkeeper.leasing.identity.service.AssociationManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

/**
 * 协会管理 service
 * @author ZLA
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AssociationManagementServiceImpl extends BaseServiceImpl<AssociationManagement> implements AssociationManagementService {

    /** 协会管理 repository */
    private final AssociationManagementRepository associationManagementRepository;

    @Override
    protected BaseRepository<AssociationManagement> getBaseRepository() {
        return associationManagementRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("associationName", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("associationAddress", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("creditCode", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("legalPerson", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("legalPersonPhone", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("associationContactNumber", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("associationContacts", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("associationBusiness", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("validityPeriod", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("geographicalPosition", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("photo", ExampleMatcher.GenericPropertyMatchers.contains());
    }

}