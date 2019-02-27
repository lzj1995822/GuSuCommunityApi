package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.Factory;
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
public class FactoryControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        Factory factory = new Factory();
        HttpEntity<Factory> httpEntity = new HttpEntity<>(factory, httpHeaders);
        ParameterizedTypeReference<Result<Factory>> type = new ParameterizedTypeReference<Result<Factory>>() {};
        ResponseEntity<Result<Factory>> responseEntity = restTemplate.exchange("/factory/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}