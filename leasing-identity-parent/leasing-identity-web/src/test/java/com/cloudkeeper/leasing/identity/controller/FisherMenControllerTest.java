package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.FisherMen;
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
public class FisherMenControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        FisherMen fisherMen = new FisherMen();
        HttpEntity<FisherMen> httpEntity = new HttpEntity<>(fisherMen, httpHeaders);
        ParameterizedTypeReference<Result<FisherMen>> type = new ParameterizedTypeReference<Result<FisherMen>>() {};
        ResponseEntity<Result<FisherMen>> responseEntity = restTemplate.exchange("/fisherMen/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}