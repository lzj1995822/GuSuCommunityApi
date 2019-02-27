package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.FamilyRecordsController;
import com.cloudkeeper.leasing.identity.domain.FamilyRecords;
import com.cloudkeeper.leasing.identity.dto.familyrecords.FamilyRecordsDTO;
import com.cloudkeeper.leasing.identity.dto.familyrecords.FamilyRecordsSearchable;
import com.cloudkeeper.leasing.identity.service.FamilyRecordsService;
import com.cloudkeeper.leasing.identity.vo.FamilyRecordsVO;
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
public class FamilyRecordsControllerImpl implements FamilyRecordsController {

    /** 类属性配置 service */
    private final FamilyRecordsService familyRecordsService;

    @Override
    public Result<FamilyRecordsVO> findOne(@ApiParam(value = "类属性配置id", required = true) @PathVariable String id) {
        Optional<FamilyRecords> familyRecordsOptional = familyRecordsService.findOptionalById(id);
        return familyRecordsOptional.map(familyRecords -> Result.of(familyRecords.convert(FamilyRecordsVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<FamilyRecordsVO> add(@ApiParam(value = "类属性配置 DTO", required = true) @RequestBody @Validated FamilyRecordsDTO familyRecordsDTO) {
        FamilyRecords familyRecords = familyRecordsService.save(familyRecordsDTO.convert(FamilyRecords.class));
        return Result.ofAddSuccess(familyRecords.convert(FamilyRecordsVO.class));
    }

    @Override
    public Result<FamilyRecordsVO> update(@ApiParam(value = "类属性配置id", required = true) @PathVariable String id,
        @ApiParam(value = "类属性配置 DTO", required = true) @RequestBody @Validated FamilyRecordsDTO familyRecordsDTO) {
        Optional<FamilyRecords> familyRecordsOptional = familyRecordsService.findOptionalById(id);
        if (!familyRecordsOptional.isPresent()) {
            return Result.ofLost();
        }
        FamilyRecords familyRecords = familyRecordsOptional.get();
        BeanUtils.copyProperties(familyRecordsDTO, familyRecords);
        familyRecords = familyRecordsService.save(familyRecords);
        return Result.ofUpdateSuccess(familyRecords.convert(FamilyRecordsVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "类属性配置id", required = true) @PathVariable String id) {
        familyRecordsService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<FamilyRecordsVO>> list(@ApiParam(value = "类属性配置查询条件", required = true) @RequestBody FamilyRecordsSearchable familyRecordsSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<FamilyRecords> familyRecordsList = familyRecordsService.findAll(familyRecordsSearchable, sort);
        List<FamilyRecordsVO> familyRecordsVOList = FamilyRecords.convert(familyRecordsList, FamilyRecordsVO.class);
        return Result.of(familyRecordsVOList);
    }

    @Override
    public Result<Page<FamilyRecordsVO>> page(@ApiParam(value = "类属性配置查询条件", required = true) @RequestBody FamilyRecordsSearchable familyRecordsSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<FamilyRecords> familyRecordsPage = familyRecordsService.findAll(familyRecordsSearchable, pageable);
        Page<FamilyRecordsVO> familyRecordsVOPage = FamilyRecords.convert(familyRecordsPage, FamilyRecordsVO.class);
        return Result.of(familyRecordsVOPage);
    }

}