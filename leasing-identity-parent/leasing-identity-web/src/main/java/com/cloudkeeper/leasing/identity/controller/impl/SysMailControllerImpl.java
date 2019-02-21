package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.SysMailController;
import com.cloudkeeper.leasing.identity.domain.SysMail;
import com.cloudkeeper.leasing.identity.dto.sysmail.SysMailDTO;
import com.cloudkeeper.leasing.identity.dto.sysmail.SysMailSearchable;
import com.cloudkeeper.leasing.identity.service.SysMailService;
import com.cloudkeeper.leasing.identity.vo.SysMailVO;
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
public class SysMailControllerImpl implements SysMailController {

    /** 类属性配置 service */
    private final SysMailService sysMailService;

    @Override
    public Result<SysMailVO> findOne(@ApiParam(value = "类属性配置id", required = true) @PathVariable String id) {
        Optional<SysMail> sysMailOptional = sysMailService.findOptionalById(id);
        return sysMailOptional.map(sysMail -> Result.of(sysMail.convert(SysMailVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<SysMailVO> add(@ApiParam(value = "类属性配置 DTO", required = true) @RequestBody @Validated SysMailDTO sysMailDTO) {
        SysMail sysMail = sysMailService.save(sysMailDTO.convert(SysMail.class));
        return Result.ofAddSuccess(sysMail.convert(SysMailVO.class));
    }

    @Override
    public Result<SysMailVO> update(@ApiParam(value = "类属性配置id", required = true) @PathVariable String id,
        @ApiParam(value = "类属性配置 DTO", required = true) @RequestBody @Validated SysMailDTO sysMailDTO) {
        Optional<SysMail> sysMailOptional = sysMailService.findOptionalById(id);
        if (!sysMailOptional.isPresent()) {
            return Result.ofLost();
        }
        SysMail sysMail = sysMailOptional.get();
        BeanUtils.copyProperties(sysMailDTO, sysMail);
        sysMail = sysMailService.save(sysMail);
        return Result.ofUpdateSuccess(sysMail.convert(SysMailVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "类属性配置id", required = true) @PathVariable String id) {
        sysMailService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<SysMailVO>> list(@ApiParam(value = "类属性配置查询条件", required = true) @RequestBody SysMailSearchable sysMailSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<SysMail> sysMailList = sysMailService.findAll(sysMailSearchable, sort);
        List<SysMailVO> sysMailVOList = SysMail.convert(sysMailList, SysMailVO.class);
        return Result.of(sysMailVOList);
    }

    @Override
    public Result<Page<SysMailVO>> page(@ApiParam(value = "类属性配置查询条件", required = true) @RequestBody SysMailSearchable sysMailSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<SysMail> sysMailPage = sysMailService.findAll(sysMailSearchable, pageable);
        Page<SysMailVO> sysMailVOPage = SysMail.convert(sysMailPage, SysMailVO.class);
        return Result.of(sysMailVOPage);
    }

}