package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.UnionMember;
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
public class UnionMemberControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        UnionMember unionMember = new UnionMember();
        HttpEntity<UnionMember> httpEntity = new HttpEntity<>(unionMember, httpHeaders);
        ParameterizedTypeReference<Result<UnionMember>> type = new ParameterizedTypeReference<Result<UnionMember>>() {};
        ResponseEntity<Result<UnionMember>> responseEntity = restTemplate.exchange("/unionMember/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}