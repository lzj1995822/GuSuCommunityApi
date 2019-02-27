package com.cloudkeeper.leasing.identity.controller;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.domain.PopulationRecords;
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
public class PopulationRecordsControllerTest extends BaseControllerTest {

    @Test
    public void add() {
        PopulationRecords populationRecords = new PopulationRecords();
        HttpEntity<PopulationRecords> httpEntity = new HttpEntity<>(populationRecords, httpHeaders);
        ParameterizedTypeReference<Result<PopulationRecords>> type = new ParameterizedTypeReference<Result<PopulationRecords>>() {};
        ResponseEntity<Result<PopulationRecords>> responseEntity = restTemplate.exchange("/populationRecords/add", HttpMethod.POST, httpEntity, type);
        assertEquals(responseEntity.getStatusCodeValue(), 200);
        assertNotNull(responseEntity.getBody().getContent());
    }

}