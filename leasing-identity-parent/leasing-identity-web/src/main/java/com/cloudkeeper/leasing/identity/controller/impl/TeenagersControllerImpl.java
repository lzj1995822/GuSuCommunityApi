package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.TeenagersController;
import com.cloudkeeper.leasing.identity.domain.Teenagers;
import com.cloudkeeper.leasing.identity.dto.teenagers.TeenagersDTO;
import com.cloudkeeper.leasing.identity.dto.teenagers.TeenagersSearchable;
import com.cloudkeeper.leasing.identity.service.TeenagersService;
import com.cloudkeeper.leasing.identity.vo.TeenagersVO;
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
public class TeenagersControllerImpl implements TeenagersController {

    /** 类属性配置 service */
    private final TeenagersService teenagersService;

    @Override
    public Result<TeenagersVO> findOne(@ApiParam(value = "类属性配置id", required = true) @PathVariable String id) {
        Optional<Teenagers> teenagersOptional = teenagersService.findOptionalById(id);
        return teenagersOptional.map(teenagers -> Result.of(teenagers.convert(TeenagersVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<TeenagersVO> add(@ApiParam(value = "类属性配置 DTO", required = true) @RequestBody @Validated TeenagersDTO teenagersDTO) {
        Teenagers teenagers = teenagersService.save(teenagersDTO.convert(Teenagers.class));
        return Result.ofAddSuccess(teenagers.convert(TeenagersVO.class));
    }

    @Override
    public Result<TeenagersVO> update(@ApiParam(value = "类属性配置id", required = true) @PathVariable String id,
        @ApiParam(value = "类属性配置 DTO", required = true) @RequestBody @Validated TeenagersDTO teenagersDTO) {
        Optional<Teenagers> teenagersOptional = teenagersService.findOptionalById(id);
        if (!teenagersOptional.isPresent()) {
            return Result.ofLost();
        }
        Teenagers teenagers = teenagersOptional.get();
        BeanUtils.copyProperties(teenagersDTO, teenagers);
        teenagers = teenagersService.save(teenagers);
        return Result.ofUpdateSuccess(teenagers.convert(TeenagersVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "类属性配置id", required = true) @PathVariable String id) {
        teenagersService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<TeenagersVO>> list(@ApiParam(value = "类属性配置查询条件", required = true) @RequestBody TeenagersSearchable teenagersSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<Teenagers> teenagersList = teenagersService.findAll(teenagersSearchable, sort);
        List<TeenagersVO> teenagersVOList = Teenagers.convert(teenagersList, TeenagersVO.class);
        return Result.of(teenagersVOList);
    }

    @Override
    public Result<Page<TeenagersVO>> page(@ApiParam(value = "类属性配置查询条件", required = true) @RequestBody TeenagersSearchable teenagersSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<Teenagers> teenagersPage = teenagersService.findAll(teenagersSearchable, pageable);
        Page<TeenagersVO> teenagersVOPage = Teenagers.convert(teenagersPage, TeenagersVO.class);
        return Result.of(teenagersVOPage);
    }

}