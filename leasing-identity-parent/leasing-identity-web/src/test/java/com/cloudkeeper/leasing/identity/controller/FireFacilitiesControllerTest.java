package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.FireFacilities;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

/**
 * 消防设施 controller 测试
 * @author ZLA
 */
public class FireFacilitiesControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        FireFacilities fireFacilities = new FireFacilities();
        HttpEntity<FireFacilities> httpEntity = new HttpEntity<>(fireFacilities, httpHeaders);
        ParameterizedTypeReference<Result<FireFacilities>> type = new ParameterizedTypeReference<Result<FireFacilities>>() {};
        ResponseEntity<Result<FireFacilities>> responseEntity = restTemplate.exchange("/fireFacilities/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}