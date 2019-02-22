package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.SysMail;
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
public class SysMailControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        SysMail sysMail = new SysMail();
        HttpEntity<SysMail> httpEntity = new HttpEntity<>(sysMail, httpHeaders);
        ParameterizedTypeReference<Result<SysMail>> type = new ParameterizedTypeReference<Result<SysMail>>() {};
        ResponseEntity<Result<SysMail>> responseEntity = restTemplate.exchange("/sysMail/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}