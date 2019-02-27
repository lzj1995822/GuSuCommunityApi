package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.PopulationRecordsController;
import com.cloudkeeper.leasing.identity.domain.PopulationRecords;
import com.cloudkeeper.leasing.identity.dto.populationrecords.PopulationRecordsDTO;
import com.cloudkeeper.leasing.identity.dto.populationrecords.PopulationRecordsSearchable;
import com.cloudkeeper.leasing.identity.service.PopulationRecordsService;
import com.cloudkeeper.leasing.identity.vo.PopulationRecordsVO;
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
 * @author lxw
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PopulationRecordsControllerImpl implements PopulationRecordsController {

    /** 类属性配置 service */
    private final PopulationRecordsService populationRecordsService;

    @Override
    public Result<PopulationRecordsVO> findOne(@ApiParam(value = "类属性配置id", required = true) @PathVariable String id) {
        Optional<PopulationRecords> populationRecordsOptional = populationRecordsService.findOptionalById(id);
        return populationRecordsOptional.map(populationRecords -> Result.of(populationRecords.convert(PopulationRecordsVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<PopulationRecordsVO> add(@ApiParam(value = "类属性配置 DTO", required = true) @RequestBody @Validated PopulationRecordsDTO populationRecordsDTO) {
        PopulationRecords populationRecords = populationRecordsService.save(populationRecordsDTO.convert(PopulationRecords.class));
        return Result.ofAddSuccess(populationRecords.convert(PopulationRecordsVO.class));
    }

    @Override
    public Result<PopulationRecordsVO> update(@ApiParam(value = "类属性配置id", required = true) @PathVariable String id,
        @ApiParam(value = "类属性配置 DTO", required = true) @RequestBody @Validated PopulationRecordsDTO populationRecordsDTO) {
        Optional<PopulationRecords> populationRecordsOptional = populationRecordsService.findOptionalById(id);
        if (!populationRecordsOptional.isPresent()) {
            return Result.ofLost();
        }
        PopulationRecords populationRecords = populationRecordsOptional.get();
        BeanUtils.copyProperties(populationRecordsDTO, populationRecords);
        populationRecords = populationRecordsService.save(populationRecords);
        return Result.ofUpdateSuccess(populationRecords.convert(PopulationRecordsVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "类属性配置id", required = true) @PathVariable String id) {
        populationRecordsService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<PopulationRecordsVO>> list(@ApiParam(value = "类属性配置查询条件", required = true) @RequestBody PopulationRecordsSearchable populationRecordsSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<PopulationRecords> populationRecordsList = populationRecordsService.findAll(populationRecordsSearchable, sort);
        List<PopulationRecordsVO> populationRecordsVOList = PopulationRecords.convert(populationRecordsList, PopulationRecordsVO.class);
        return Result.of(populationRecordsVOList);
    }

    @Override
    public Result<Page<PopulationRecordsVO>> page(@ApiParam(value = "类属性配置查询条件", required = true) @RequestBody PopulationRecordsSearchable populationRecordsSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<PopulationRecords> populationRecordsPage = populationRecordsService.findAll(populationRecordsSearchable, pageable);
        Page<PopulationRecordsVO> populationRecordsVOPage = PopulationRecords.convert(populationRecordsPage, PopulationRecordsVO.class);
        return Result.of(populationRecordsVOPage);
    }

}