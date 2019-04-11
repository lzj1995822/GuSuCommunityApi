package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.AssociationManagementController;
import com.cloudkeeper.leasing.identity.domain.AssociationManagement;
import com.cloudkeeper.leasing.identity.dto.associationmanagement.AssociationManagementDTO;
import com.cloudkeeper.leasing.identity.dto.associationmanagement.AssociationManagementSearchable;
import com.cloudkeeper.leasing.identity.service.AssociationManagementService;
import com.cloudkeeper.leasing.identity.vo.AssociationManagementVO;
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
 * 协会管理 controller
 * @author ZLA
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AssociationManagementControllerImpl implements AssociationManagementController {

    /** 协会管理 service */
    private final AssociationManagementService associationManagementService;

    @Override
    public Result<AssociationManagementVO> findOne(@ApiParam(value = "协会管理id", required = true) @PathVariable String id) {
        Optional<AssociationManagement> associationManagementOptional = associationManagementService.findOptionalById(id);
        return associationManagementOptional.map(associationManagement -> Result.of(associationManagement.convert(AssociationManagementVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<AssociationManagementVO> add(@ApiParam(value = "协会管理 DTO", required = true) @RequestBody @Validated AssociationManagementDTO associationManagementDTO) {
        AssociationManagement associationManagement = associationManagementService.save(associationManagementDTO.convert(AssociationManagement.class));
        return Result.ofAddSuccess(associationManagement.convert(AssociationManagementVO.class));
    }

    @Override
    public Result<AssociationManagementVO> update(@ApiParam(value = "协会管理id", required = true) @PathVariable String id,
        @ApiParam(value = "协会管理 DTO", required = true) @RequestBody @Validated AssociationManagementDTO associationManagementDTO) {
        Optional<AssociationManagement> associationManagementOptional = associationManagementService.findOptionalById(id);
        if (!associationManagementOptional.isPresent()) {
            return Result.ofLost();
        }
        AssociationManagement associationManagement = associationManagementOptional.get();
        BeanUtils.copyProperties(associationManagementDTO, associationManagement);
        associationManagement = associationManagementService.save(associationManagement);
        return Result.ofUpdateSuccess(associationManagement.convert(AssociationManagementVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "协会管理id", required = true) @PathVariable String id) {
        associationManagementService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<AssociationManagementVO>> list(@ApiParam(value = "协会管理查询条件", required = true) @RequestBody AssociationManagementSearchable associationManagementSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<AssociationManagement> associationManagementList = associationManagementService.findAll(associationManagementSearchable, sort);
        List<AssociationManagementVO> associationManagementVOList = AssociationManagement.convert(associationManagementList, AssociationManagementVO.class);
        return Result.of(associationManagementVOList);
    }

    @Override
    public Result<Page<AssociationManagementVO>> page(@ApiParam(value = "协会管理查询条件", required = true) @RequestBody AssociationManagementSearchable associationManagementSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<AssociationManagement> associationManagementPage = associationManagementService.findAll(associationManagementSearchable, pageable);
        Page<AssociationManagementVO> associationManagementVOPage = AssociationManagement.convert(associationManagementPage, AssociationManagementVO.class);
        return Result.of(associationManagementVOPage);
    }

}