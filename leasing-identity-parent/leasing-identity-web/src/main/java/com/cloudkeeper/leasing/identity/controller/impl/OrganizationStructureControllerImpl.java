package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.OrganizationStructureController;
import com.cloudkeeper.leasing.identity.domain.OrganizationStructure;
import com.cloudkeeper.leasing.identity.dto.organizationstructure.OrganizationStructureDTO;
import com.cloudkeeper.leasing.identity.dto.organizationstructure.OrganizationStructureSearchable;
import com.cloudkeeper.leasing.identity.service.OrganizationStructureService;
import com.cloudkeeper.leasing.identity.vo.OrganizationStructureVO;
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
 * 组织架构 controller
 * @author lxw
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrganizationStructureControllerImpl implements OrganizationStructureController {

    /** 组织架构 service */
    private final OrganizationStructureService organizationStructureService;

    @Override
    public Result<OrganizationStructureVO> findOne(@ApiParam(value = "组织架构id", required = true) @PathVariable String id) {
        Optional<OrganizationStructure> organizationStructureOptional = organizationStructureService.findOptionalById(id);
        return organizationStructureOptional.map(organizationStructure -> Result.of(organizationStructure.convert(OrganizationStructureVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<OrganizationStructureVO> add(@ApiParam(value = "组织架构 DTO", required = true) @RequestBody @Validated OrganizationStructureDTO organizationStructureDTO) {
        OrganizationStructure organizationStructure = organizationStructureService.save(organizationStructureDTO.convert(OrganizationStructure.class));
        return Result.ofAddSuccess(organizationStructure.convert(OrganizationStructureVO.class));
    }

    @Override
    public Result<OrganizationStructureVO> update(@ApiParam(value = "组织架构id", required = true) @PathVariable String id,
        @ApiParam(value = "组织架构 DTO", required = true) @RequestBody @Validated OrganizationStructureDTO organizationStructureDTO) {
        Optional<OrganizationStructure> organizationStructureOptional = organizationStructureService.findOptionalById(id);
        if (!organizationStructureOptional.isPresent()) {
            return Result.ofLost();
        }
        OrganizationStructure organizationStructure = organizationStructureOptional.get();
        BeanUtils.copyProperties(organizationStructureDTO, organizationStructure);
        organizationStructure = organizationStructureService.save(organizationStructure);
        return Result.ofUpdateSuccess(organizationStructure.convert(OrganizationStructureVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "组织架构id", required = true) @PathVariable String id) {
        organizationStructureService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<OrganizationStructureVO>> list(@ApiParam(value = "组织架构查询条件", required = true) @RequestBody OrganizationStructureSearchable organizationStructureSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<OrganizationStructure> organizationStructureList = organizationStructureService.findAll(organizationStructureSearchable, sort);
        List<OrganizationStructureVO> organizationStructureVOList = OrganizationStructure.convert(organizationStructureList, OrganizationStructureVO.class);
        return Result.of(organizationStructureVOList);
    }

    @Override
    public Result<Page<OrganizationStructureVO>> page(@ApiParam(value = "组织架构查询条件", required = true) @RequestBody OrganizationStructureSearchable organizationStructureSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<OrganizationStructure> organizationStructurePage = organizationStructureService.findAll(organizationStructureSearchable, pageable);
        Page<OrganizationStructureVO> organizationStructureVOPage = OrganizationStructure.convert(organizationStructurePage, OrganizationStructureVO.class);
        return Result.of(organizationStructureVOPage);
    }

}
