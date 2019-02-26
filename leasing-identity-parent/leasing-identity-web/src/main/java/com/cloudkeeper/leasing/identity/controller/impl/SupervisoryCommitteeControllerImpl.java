package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.SupervisoryCommitteeController;
import com.cloudkeeper.leasing.identity.domain.SupervisoryCommittee;
import com.cloudkeeper.leasing.identity.dto.supervisorycommittee.SupervisoryCommitteeDTO;
import com.cloudkeeper.leasing.identity.dto.supervisorycommittee.SupervisoryCommitteeSearchable;
import com.cloudkeeper.leasing.identity.service.SupervisoryCommitteeService;
import com.cloudkeeper.leasing.identity.vo.SupervisoryCommitteeVO;
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
public class SupervisoryCommitteeControllerImpl implements SupervisoryCommitteeController {

    /** 类属性配置 service */
    private final SupervisoryCommitteeService supervisoryCommitteeService;

    @Override
    public Result<SupervisoryCommitteeVO> findOne(@ApiParam(value = "类属性配置id", required = true) @PathVariable String id) {
        Optional<SupervisoryCommittee> supervisoryCommitteeOptional = supervisoryCommitteeService.findOptionalById(id);
        return supervisoryCommitteeOptional.map(supervisoryCommittee -> Result.of(supervisoryCommittee.convert(SupervisoryCommitteeVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<SupervisoryCommitteeVO> add(@ApiParam(value = "类属性配置 DTO", required = true) @RequestBody @Validated SupervisoryCommitteeDTO supervisoryCommitteeDTO) {
        SupervisoryCommittee supervisoryCommittee = supervisoryCommitteeService.save(supervisoryCommitteeDTO.convert(SupervisoryCommittee.class));
        return Result.ofAddSuccess(supervisoryCommittee.convert(SupervisoryCommitteeVO.class));
    }

    @Override
    public Result<SupervisoryCommitteeVO> update(@ApiParam(value = "类属性配置id", required = true) @PathVariable String id,
        @ApiParam(value = "类属性配置 DTO", required = true) @RequestBody @Validated SupervisoryCommitteeDTO supervisoryCommitteeDTO) {
        Optional<SupervisoryCommittee> supervisoryCommitteeOptional = supervisoryCommitteeService.findOptionalById(id);
        if (!supervisoryCommitteeOptional.isPresent()) {
            return Result.ofLost();
        }
        SupervisoryCommittee supervisoryCommittee = supervisoryCommitteeOptional.get();
        BeanUtils.copyProperties(supervisoryCommitteeDTO, supervisoryCommittee);
        supervisoryCommittee = supervisoryCommitteeService.save(supervisoryCommittee);
        return Result.ofUpdateSuccess(supervisoryCommittee.convert(SupervisoryCommitteeVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "类属性配置id", required = true) @PathVariable String id) {
        supervisoryCommitteeService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<SupervisoryCommitteeVO>> list(@ApiParam(value = "类属性配置查询条件", required = true) @RequestBody SupervisoryCommitteeSearchable supervisoryCommitteeSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<SupervisoryCommittee> supervisoryCommitteeList = supervisoryCommitteeService.findAll(supervisoryCommitteeSearchable, sort);
        List<SupervisoryCommitteeVO> supervisoryCommitteeVOList = SupervisoryCommittee.convert(supervisoryCommitteeList, SupervisoryCommitteeVO.class);
        return Result.of(supervisoryCommitteeVOList);
    }

    @Override
    public Result<Page<SupervisoryCommitteeVO>> page(@ApiParam(value = "类属性配置查询条件", required = true) @RequestBody SupervisoryCommitteeSearchable supervisoryCommitteeSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<SupervisoryCommittee> supervisoryCommitteePage = supervisoryCommitteeService.findAll(supervisoryCommitteeSearchable, pageable);
        Page<SupervisoryCommitteeVO> supervisoryCommitteeVOPage = SupervisoryCommittee.convert(supervisoryCommitteePage, SupervisoryCommitteeVO.class);
        return Result.of(supervisoryCommitteeVOPage);
    }

}