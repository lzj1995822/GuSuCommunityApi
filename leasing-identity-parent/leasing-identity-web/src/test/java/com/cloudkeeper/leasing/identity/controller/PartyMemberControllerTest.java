package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.PartyMember;
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
public class PartyMemberControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        PartyMember partyMember = new PartyMember();
        HttpEntity<PartyMember> httpEntity = new HttpEntity<>(partyMember, httpHeaders);
        ParameterizedTypeReference<Result<PartyMember>> type = new ParameterizedTypeReference<Result<PartyMember>>() {};
        ResponseEntity<Result<PartyMember>> responseEntity = restTemplate.exchange("/partyMember/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}