package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.PartyMemberExcellent;
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
public class PartyMemberExcellentControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        PartyMemberExcellent partyMemberExcellent = new PartyMemberExcellent();
        HttpEntity<PartyMemberExcellent> httpEntity = new HttpEntity<>(partyMemberExcellent, httpHeaders);
        ParameterizedTypeReference<Result<PartyMemberExcellent>> type = new ParameterizedTypeReference<Result<PartyMemberExcellent>>() {};
        ResponseEntity<Result<PartyMemberExcellent>> responseEntity = restTemplate.exchange("/partyMemberExcellent/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}