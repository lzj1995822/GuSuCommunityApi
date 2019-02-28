package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.PolicyPaper;
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
public class PolicyPaperControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        PolicyPaper policyPaper = new PolicyPaper();
        HttpEntity<PolicyPaper> httpEntity = new HttpEntity<>(policyPaper, httpHeaders);
        ParameterizedTypeReference<Result<PolicyPaper>> type = new ParameterizedTypeReference<Result<PolicyPaper>>() {};
        ResponseEntity<Result<PolicyPaper>> responseEntity = restTemplate.exchange("/policyPaper/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}