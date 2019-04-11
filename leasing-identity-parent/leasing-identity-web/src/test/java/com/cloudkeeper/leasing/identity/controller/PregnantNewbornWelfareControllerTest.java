package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.PregnantNewbornWelfare;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

/**
 * 孕妇新生儿福利 controller 测试
 * @author ZLA
 */
public class PregnantNewbornWelfareControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        PregnantNewbornWelfare pregnantNewbornWelfare = new PregnantNewbornWelfare();
        HttpEntity<PregnantNewbornWelfare> httpEntity = new HttpEntity<>(pregnantNewbornWelfare, httpHeaders);
        ParameterizedTypeReference<Result<PregnantNewbornWelfare>> type = new ParameterizedTypeReference<Result<PregnantNewbornWelfare>>() {};
        ResponseEntity<Result<PregnantNewbornWelfare>> responseEntity = restTemplate.exchange("/pregnantNewbornWelfare/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}