package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.FireFacilitiesController;
import com.cloudkeeper.leasing.identity.domain.FireFacilities;
import com.cloudkeeper.leasing.identity.dto.firefacilities.FireFacilitiesDTO;
import com.cloudkeeper.leasing.identity.dto.firefacilities.FireFacilitiesSearchable;
import com.cloudkeeper.leasing.identity.service.FireFacilitiesService;
import com.cloudkeeper.leasing.identity.vo.FireFacilitiesVO;
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
 * 消防设施 controller
 * @author ZLA
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FireFacilitiesControllerImpl implements FireFacilitiesController {

    /** 消防设施 service */
    private final FireFacilitiesService fireFacilitiesService;

    @Override
    public Result<FireFacilitiesVO> findOne(@ApiParam(value = "消防设施id", required = true) @PathVariable String id) {
        Optional<FireFacilities> fireFacilitiesOptional = fireFacilitiesService.findOptionalById(id);
        return fireFacilitiesOptional.map(fireFacilities -> Result.of(fireFacilities.convert(FireFacilitiesVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<FireFacilitiesVO> add(@ApiParam(value = "消防设施 DTO", required = true) @RequestBody @Validated FireFacilitiesDTO fireFacilitiesDTO) {
        FireFacilities fireFacilities = fireFacilitiesService.save(fireFacilitiesDTO.convert(FireFacilities.class));
        return Result.ofAddSuccess(fireFacilities.convert(FireFacilitiesVO.class));
    }

    @Override
    public Result<FireFacilitiesVO> update(@ApiParam(value = "消防设施id", required = true) @PathVariable String id,
        @ApiParam(value = "消防设施 DTO", required = true) @RequestBody @Validated FireFacilitiesDTO fireFacilitiesDTO) {
        Optional<FireFacilities> fireFacilitiesOptional = fireFacilitiesService.findOptionalById(id);
        if (!fireFacilitiesOptional.isPresent()) {
            return Result.ofLost();
        }
        FireFacilities fireFacilities = fireFacilitiesOptional.get();
        BeanUtils.copyProperties(fireFacilitiesDTO, fireFacilities);
        fireFacilities = fireFacilitiesService.save(fireFacilities);
        return Result.ofUpdateSuccess(fireFacilities.convert(FireFacilitiesVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "消防设施id", required = true) @PathVariable String id) {
        fireFacilitiesService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<FireFacilitiesVO>> list(@ApiParam(value = "消防设施查询条件", required = true) @RequestBody FireFacilitiesSearchable fireFacilitiesSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<FireFacilities> fireFacilitiesList = fireFacilitiesService.findAll(fireFacilitiesSearchable, sort);
        List<FireFacilitiesVO> fireFacilitiesVOList = FireFacilities.convert(fireFacilitiesList, FireFacilitiesVO.class);
        return Result.of(fireFacilitiesVOList);
    }

    @Override
    public Result<Page<FireFacilitiesVO>> page(@ApiParam(value = "消防设施查询条件", required = true) @RequestBody FireFacilitiesSearchable fireFacilitiesSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<FireFacilities> fireFacilitiesPage = fireFacilitiesService.findAll(fireFacilitiesSearchable, pageable);
        Page<FireFacilitiesVO> fireFacilitiesVOPage = FireFacilities.convert(fireFacilitiesPage, FireFacilitiesVO.class);
        return Result.of(fireFacilitiesVOPage);
    }

}