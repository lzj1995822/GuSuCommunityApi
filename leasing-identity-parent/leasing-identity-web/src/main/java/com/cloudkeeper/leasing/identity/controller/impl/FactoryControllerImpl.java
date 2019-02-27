package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.FactoryController;
import com.cloudkeeper.leasing.identity.domain.Factory;
import com.cloudkeeper.leasing.identity.dto.factory.FactoryDTO;
import com.cloudkeeper.leasing.identity.dto.factory.FactorySearchable;
import com.cloudkeeper.leasing.identity.service.FactoryService;
import com.cloudkeeper.leasing.identity.vo.FactoryVO;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * 类属性配置 controller
 * @author cqh
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FactoryControllerImpl implements FactoryController {

    /** 类属性配置 service */
    private final FactoryService factoryService;

    @Override
    public Result<FactoryVO> findOne(@ApiParam(value = "类属性配置id", required = true) @PathVariable String id) {
        Optional<Factory> factoryOptional = factoryService.findOptionalById(id);
        return factoryOptional.map(factory -> Result.of(factory.convert(FactoryVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<FactoryVO> add(@ApiParam(value = "类属性配置 DTO", required = true) @RequestBody @Validated FactoryDTO factoryDTO) {
        Factory factory = factoryService.save(factoryDTO.convert(Factory.class));
        return Result.ofAddSuccess(factory.convert(FactoryVO.class));
    }

    @Override
    public Result<FactoryVO> update(@ApiParam(value = "类属性配置id", required = true) @PathVariable String id,
        @ApiParam(value = "类属性配置 DTO", required = true) @RequestBody @Validated FactoryDTO factoryDTO) {
        Optional<Factory> factoryOptional = factoryService.findOptionalById(id);
        if (!factoryOptional.isPresent()) {
            return Result.ofLost();
        }
        Factory factory = factoryOptional.get();
        BeanUtils.copyProperties(factoryDTO, factory);
        factory = factoryService.save(factory);
        return Result.ofUpdateSuccess(factory.convert(FactoryVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "类属性配置id", required = true) @PathVariable String id) {
        factoryService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<FactoryVO>> list(@ApiParam(value = "类属性配置查询条件", required = true) @RequestBody FactorySearchable factorySearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<Factory> factoryList = factoryService.findAll(factorySearchable, sort);
        List<FactoryVO> factoryVOList = Factory.convert(factoryList, FactoryVO.class);
        return Result.of(factoryVOList);
    }

    @Override
    public Result<Page<FactoryVO>> page(@ApiParam(value = "类属性配置查询条件", required = true) @RequestBody FactorySearchable factorySearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<Factory> factoryPage = factoryService.findAll(factorySearchable, pageable);
        Page<FactoryVO> factoryVOPage = Factory.convert(factoryPage, FactoryVO.class);
        return Result.of(factoryVOPage);
    }

}