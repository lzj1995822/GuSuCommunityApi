package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.OrganizationStructure;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

/**
 * 类属性配置 controller 测试
 * @author lxw
 */
public class OrganizationStructureControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        OrganizationStructure organizationStructure = new OrganizationStructure();
        HttpEntity<OrganizationStructure> httpEntity = new HttpEntity<>(organizationStructure, httpHeaders);
        ParameterizedTypeReference<Result<OrganizationStructure>> type = new ParameterizedTypeReference<Result<OrganizationStructure>>() {};
        ResponseEntity<Result<OrganizationStructure>> responseEntity = restTemplate.exchange("/organizationStructure/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}