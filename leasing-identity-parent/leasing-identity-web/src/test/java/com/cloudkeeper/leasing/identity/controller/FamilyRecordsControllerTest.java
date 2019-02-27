package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.FamilyRecords;
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
public class FamilyRecordsControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        FamilyRecords familyRecords = new FamilyRecords();
        HttpEntity<FamilyRecords> httpEntity = new HttpEntity<>(familyRecords, httpHeaders);
        ParameterizedTypeReference<Result<FamilyRecords>> type = new ParameterizedTypeReference<Result<FamilyRecords>>() {};
        ResponseEntity<Result<FamilyRecords>> responseEntity = restTemplate.exchange("/familyRecords/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}