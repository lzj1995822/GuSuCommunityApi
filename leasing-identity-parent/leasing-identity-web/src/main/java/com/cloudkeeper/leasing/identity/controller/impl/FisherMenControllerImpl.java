package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.FisherMenController;
import com.cloudkeeper.leasing.identity.domain.FisherMen;
import com.cloudkeeper.leasing.identity.dto.fishermen.FisherMenDTO;
import com.cloudkeeper.leasing.identity.dto.fishermen.FisherMenSearchable;
import com.cloudkeeper.leasing.identity.service.FisherMenService;
import com.cloudkeeper.leasing.identity.vo.FisherMenVO;
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
public class FisherMenControllerImpl implements FisherMenController {

    /** 类属性配置 service */
    private final FisherMenService fisherMenService;

    @Override
    public Result<FisherMenVO> findOne(@ApiParam(value = "类属性配置id", required = true) @PathVariable String id) {
        Optional<FisherMen> fisherMenOptional = fisherMenService.findOptionalById(id);
        return fisherMenOptional.map(fisherMen -> Result.of(fisherMen.convert(FisherMenVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<FisherMenVO> add(@ApiParam(value = "类属性配置 DTO", required = true) @RequestBody @Validated FisherMenDTO fisherMenDTO) {
        FisherMen fisherMen = fisherMenService.save(fisherMenDTO.convert(FisherMen.class));
        return Result.ofAddSuccess(fisherMen.convert(FisherMenVO.class));
    }

    @Override
    public Result<FisherMenVO> update(@ApiParam(value = "类属性配置id", required = true) @PathVariable String id,
        @ApiParam(value = "类属性配置 DTO", required = true) @RequestBody @Validated FisherMenDTO fisherMenDTO) {
        Optional<FisherMen> fisherMenOptional = fisherMenService.findOptionalById(id);
        if (!fisherMenOptional.isPresent()) {
            return Result.ofLost();
        }
        FisherMen fisherMen = fisherMenOptional.get();
        BeanUtils.copyProperties(fisherMenDTO, fisherMen);
        fisherMen = fisherMenService.save(fisherMen);
        return Result.ofUpdateSuccess(fisherMen.convert(FisherMenVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "类属性配置id", required = true) @PathVariable String id) {
        fisherMenService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<FisherMenVO>> list(@ApiParam(value = "类属性配置查询条件", required = true) @RequestBody FisherMenSearchable fisherMenSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<FisherMen> fisherMenList = fisherMenService.findAll(fisherMenSearchable, sort);
        List<FisherMenVO> fisherMenVOList = FisherMen.convert(fisherMenList, FisherMenVO.class);
        return Result.of(fisherMenVOList);
    }

    @Override
    public Result<Page<FisherMenVO>> page(@ApiParam(value = "类属性配置查询条件", required = true) @RequestBody FisherMenSearchable fisherMenSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<FisherMen> fisherMenPage = fisherMenService.findAll(fisherMenSearchable, pageable);
        Page<FisherMenVO> fisherMenVOPage = FisherMen.convert(fisherMenPage, FisherMenVO.class);
        return Result.of(fisherMenVOPage);
    }

}