package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.Business;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

/**
 * 类属性配置 controller 测试
 * @author cqh
 */
public class BusinessControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        Business business = new Business();
        HttpEntity<Business> httpEntity = new HttpEntity<>(business, httpHeaders);
        ParameterizedTypeReference<Result<Business>> type = new ParameterizedTypeReference<Result<Business>>() {};
        ResponseEntity<Result<Business>> responseEntity = restTemplate.exchange("/business/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}