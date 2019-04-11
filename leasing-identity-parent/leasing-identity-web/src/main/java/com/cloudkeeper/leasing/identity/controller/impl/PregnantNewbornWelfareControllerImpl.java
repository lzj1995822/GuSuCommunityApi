package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.PregnantNewbornWelfareController;
import com.cloudkeeper.leasing.identity.domain.PregnantNewbornWelfare;
import com.cloudkeeper.leasing.identity.dto.pregnantnewbornwelfare.PregnantNewbornWelfareDTO;
import com.cloudkeeper.leasing.identity.dto.pregnantnewbornwelfare.PregnantNewbornWelfareSearchable;
import com.cloudkeeper.leasing.identity.service.PregnantNewbornWelfareService;
import com.cloudkeeper.leasing.identity.vo.PregnantNewbornWelfareVO;
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
 * 孕妇新生儿福利 controller
 * @author ZLA
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PregnantNewbornWelfareControllerImpl implements PregnantNewbornWelfareController {

    /** 孕妇新生儿福利 service */
    private final PregnantNewbornWelfareService pregnantNewbornWelfareService;

    @Override
    public Result<PregnantNewbornWelfareVO> findOne(@ApiParam(value = "孕妇新生儿福利id", required = true) @PathVariable String id) {
        Optional<PregnantNewbornWelfare> pregnantNewbornWelfareOptional = pregnantNewbornWelfareService.findOptionalById(id);
        return pregnantNewbornWelfareOptional.map(pregnantNewbornWelfare -> Result.of(pregnantNewbornWelfare.convert(PregnantNewbornWelfareVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<PregnantNewbornWelfareVO> add(@ApiParam(value = "孕妇新生儿福利 DTO", required = true) @RequestBody @Validated PregnantNewbornWelfareDTO pregnantNewbornWelfareDTO) {
        PregnantNewbornWelfare pregnantNewbornWelfare = pregnantNewbornWelfareService.save(pregnantNewbornWelfareDTO.convert(PregnantNewbornWelfare.class));
        return Result.ofAddSuccess(pregnantNewbornWelfare.convert(PregnantNewbornWelfareVO.class));
    }

    @Override
    public Result<PregnantNewbornWelfareVO> update(@ApiParam(value = "孕妇新生儿福利id", required = true) @PathVariable String id,
        @ApiParam(value = "孕妇新生儿福利 DTO", required = true) @RequestBody @Validated PregnantNewbornWelfareDTO pregnantNewbornWelfareDTO) {
        Optional<PregnantNewbornWelfare> pregnantNewbornWelfareOptional = pregnantNewbornWelfareService.findOptionalById(id);
        if (!pregnantNewbornWelfareOptional.isPresent()) {
            return Result.ofLost();
        }
        PregnantNewbornWelfare pregnantNewbornWelfare = pregnantNewbornWelfareOptional.get();
        BeanUtils.copyProperties(pregnantNewbornWelfareDTO, pregnantNewbornWelfare);
        pregnantNewbornWelfare = pregnantNewbornWelfareService.save(pregnantNewbornWelfare);
        return Result.ofUpdateSuccess(pregnantNewbornWelfare.convert(PregnantNewbornWelfareVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "孕妇新生儿福利id", required = true) @PathVariable String id) {
        pregnantNewbornWelfareService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<PregnantNewbornWelfareVO>> list(@ApiParam(value = "孕妇新生儿福利查询条件", required = true) @RequestBody PregnantNewbornWelfareSearchable pregnantNewbornWelfareSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<PregnantNewbornWelfare> pregnantNewbornWelfareList = pregnantNewbornWelfareService.findAll(pregnantNewbornWelfareSearchable, sort);
        List<PregnantNewbornWelfareVO> pregnantNewbornWelfareVOList = PregnantNewbornWelfare.convert(pregnantNewbornWelfareList, PregnantNewbornWelfareVO.class);
        return Result.of(pregnantNewbornWelfareVOList);
    }

    @Override
    public Result<Page<PregnantNewbornWelfareVO>> page(@ApiParam(value = "孕妇新生儿福利查询条件", required = true) @RequestBody PregnantNewbornWelfareSearchable pregnantNewbornWelfareSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<PregnantNewbornWelfare> pregnantNewbornWelfarePage = pregnantNewbornWelfareService.findAll(pregnantNewbornWelfareSearchable, pageable);
        Page<PregnantNewbornWelfareVO> pregnantNewbornWelfareVOPage = PregnantNewbornWelfare.convert(pregnantNewbornWelfarePage, PregnantNewbornWelfareVO.class);
        return Result.of(pregnantNewbornWelfareVOPage);
    }

}