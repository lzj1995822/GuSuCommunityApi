package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.AssociationManagement;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

/**
 * 协会管理 controller 测试
 * @author ZLA
 */
public class AssociationManagementControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        AssociationManagement associationManagement = new AssociationManagement();
        HttpEntity<AssociationManagement> httpEntity = new HttpEntity<>(associationManagement, httpHeaders);
        ParameterizedTypeReference<Result<AssociationManagement>> type = new ParameterizedTypeReference<Result<AssociationManagement>>() {};
        ResponseEntity<Result<AssociationManagement>> responseEntity = restTemplate.exchange("/associationManagement/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}