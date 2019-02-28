package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.PartyMemberController;
import com.cloudkeeper.leasing.identity.domain.PartyMember;
import com.cloudkeeper.leasing.identity.dto.partymember.PartyMemberDTO;
import com.cloudkeeper.leasing.identity.dto.partymember.PartyMemberSearchable;
import com.cloudkeeper.leasing.identity.service.PartyMemberService;
import com.cloudkeeper.leasing.identity.vo.PartyMemberVO;
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
 * 党员 controller
 * @author lxw
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PartyMemberControllerImpl implements PartyMemberController {

    /** 类属性配置 service */
    private final PartyMemberService partyMemberService;

    @Override
    public Result<PartyMemberVO> findOne(@ApiParam(value = "党员id", required = true) @PathVariable String id) {
        Optional<PartyMember> partyMemberOptional = partyMemberService.findOptionalById(id);
        return partyMemberOptional.map(partyMember -> Result.of(partyMember.convert(PartyMemberVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<PartyMemberVO> add(@ApiParam(value = "党员 DTO", required = true) @RequestBody @Validated PartyMemberDTO partyMemberDTO) {
        PartyMember partyMember = partyMemberService.save(partyMemberDTO.convert(PartyMember.class));
        return Result.ofAddSuccess(partyMember.convert(PartyMemberVO.class));
    }

    @Override
    public Result<PartyMemberVO> update(@ApiParam(value = "党员id", required = true) @PathVariable String id,
        @ApiParam(value = "党员 DTO", required = true) @RequestBody @Validated PartyMemberDTO partyMemberDTO) {
        Optional<PartyMember> partyMemberOptional = partyMemberService.findOptionalById(id);
        if (!partyMemberOptional.isPresent()) {
            return Result.ofLost();
        }
        PartyMember partyMember = partyMemberOptional.get();
        BeanUtils.copyProperties(partyMemberDTO, partyMember);
        partyMember = partyMemberService.save(partyMember);
        return Result.ofUpdateSuccess(partyMember.convert(PartyMemberVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "党员id", required = true) @PathVariable String id) {
        partyMemberService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<PartyMemberVO>> list(@ApiParam(value = "党员查询条件", required = true) @RequestBody PartyMemberSearchable partyMemberSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<PartyMember> partyMemberList = partyMemberService.findAll(partyMemberSearchable, sort);
        List<PartyMemberVO> partyMemberVOList = PartyMember.convert(partyMemberList, PartyMemberVO.class);
        return Result.of(partyMemberVOList);
    }

    @Override
    public Result<Page<PartyMemberVO>> page(@ApiParam(value = "党员查询条件", required = true) @RequestBody PartyMemberSearchable partyMemberSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<PartyMember> partyMemberPage = partyMemberService.findAll(partyMemberSearchable, pageable);
        Page<PartyMemberVO> partyMemberVOPage = PartyMember.convert(partyMemberPage, PartyMemberVO.class);
        return Result.of(partyMemberVOPage);
    }

}
