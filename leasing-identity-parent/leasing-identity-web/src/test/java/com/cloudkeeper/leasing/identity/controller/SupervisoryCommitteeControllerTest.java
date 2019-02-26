package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.SupervisoryCommittee;
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
public class SupervisoryCommitteeControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        SupervisoryCommittee supervisoryCommittee = new SupervisoryCommittee();
        HttpEntity<SupervisoryCommittee> httpEntity = new HttpEntity<>(supervisoryCommittee, httpHeaders);
        ParameterizedTypeReference<Result<SupervisoryCommittee>> type = new ParameterizedTypeReference<Result<SupervisoryCommittee>>() {};
        ResponseEntity<Result<SupervisoryCommittee>> responseEntity = restTemplate.exchange("/supervisoryCommittee/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}