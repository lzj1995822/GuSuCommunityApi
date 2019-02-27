package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.Teenagers;
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
public class TeenagersControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        Teenagers teenagers = new Teenagers();
        HttpEntity<Teenagers> httpEntity = new HttpEntity<>(teenagers, httpHeaders);
        ParameterizedTypeReference<Result<Teenagers>> type = new ParameterizedTypeReference<Result<Teenagers>>() {};
        ResponseEntity<Result<Teenagers>> responseEntity = restTemplate.exchange("/teenagers/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}