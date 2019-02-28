package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.PartyMemberExcellentController;
import com.cloudkeeper.leasing.identity.domain.PartyMemberExcellent;
import com.cloudkeeper.leasing.identity.dto.partymemberexcellent.PartyMemberExcellentDTO;
import com.cloudkeeper.leasing.identity.dto.partymemberexcellent.PartyMemberExcellentSearchable;
import com.cloudkeeper.leasing.identity.service.PartyMemberExcellentService;
import com.cloudkeeper.leasing.identity.vo.PartyMemberExcellentVO;
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
 * 优秀党员 controller
 * @author lxw
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PartyMemberExcellentControllerImpl implements PartyMemberExcellentController {

    /** 类属性配置 service */
    private final PartyMemberExcellentService partyMemberExcellentService;

    @Override
    public Result<PartyMemberExcellentVO> findOne(@ApiParam(value = "优秀党员id", required = true) @PathVariable String id) {
        Optional<PartyMemberExcellent> partyMemberExcellentOptional = partyMemberExcellentService.findOptionalById(id);
        return partyMemberExcellentOptional.map(partyMemberExcellent -> Result.of(partyMemberExcellent.convert(PartyMemberExcellentVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<PartyMemberExcellentVO> add(@ApiParam(value = "优秀党员 DTO", required = true) @RequestBody @Validated PartyMemberExcellentDTO partyMemberExcellentDTO) {
        PartyMemberExcellent partyMemberExcellent = partyMemberExcellentService.save(partyMemberExcellentDTO.convert(PartyMemberExcellent.class));
        return Result.ofAddSuccess(partyMemberExcellent.convert(PartyMemberExcellentVO.class));
    }

    @Override
    public Result<PartyMemberExcellentVO> update(@ApiParam(value = "优秀党员id", required = true) @PathVariable String id,
        @ApiParam(value = "优秀党员 DTO", required = true) @RequestBody @Validated PartyMemberExcellentDTO partyMemberExcellentDTO) {
        Optional<PartyMemberExcellent> partyMemberExcellentOptional = partyMemberExcellentService.findOptionalById(id);
        if (!partyMemberExcellentOptional.isPresent()) {
            return Result.ofLost();
        }
        PartyMemberExcellent partyMemberExcellent = partyMemberExcellentOptional.get();
        BeanUtils.copyProperties(partyMemberExcellentDTO, partyMemberExcellent);
        partyMemberExcellent = partyMemberExcellentService.save(partyMemberExcellent);
        return Result.ofUpdateSuccess(partyMemberExcellent.convert(PartyMemberExcellentVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "优秀党员id", required = true) @PathVariable String id) {
        partyMemberExcellentService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<PartyMemberExcellentVO>> list(@ApiParam(value = "优秀党员查询条件", required = true) @RequestBody PartyMemberExcellentSearchable partyMemberExcellentSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<PartyMemberExcellent> partyMemberExcellentList = partyMemberExcellentService.findAll(partyMemberExcellentSearchable, sort);
        List<PartyMemberExcellentVO> partyMemberExcellentVOList = PartyMemberExcellent.convert(partyMemberExcellentList, PartyMemberExcellentVO.class);
        return Result.of(partyMemberExcellentVOList);
    }

    @Override
    public Result<Page<PartyMemberExcellentVO>> page(@ApiParam(value = "优秀党员查询条件", required = true) @RequestBody PartyMemberExcellentSearchable partyMemberExcellentSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<PartyMemberExcellent> partyMemberExcellentPage = partyMemberExcellentService.findAll(partyMemberExcellentSearchable, pageable);
        Page<PartyMemberExcellentVO> partyMemberExcellentVOPage = PartyMemberExcellent.convert(partyMemberExcellentPage, PartyMemberExcellentVO.class);
        return Result.of(partyMemberExcellentVOPage);
    }

}
