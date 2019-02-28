package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.UnionMemberController;
import com.cloudkeeper.leasing.identity.domain.UnionMember;
import com.cloudkeeper.leasing.identity.dto.unionmember.UnionMemberDTO;
import com.cloudkeeper.leasing.identity.dto.unionmember.UnionMemberSearchable;
import com.cloudkeeper.leasing.identity.service.UnionMemberService;
import com.cloudkeeper.leasing.identity.vo.UnionMemberVO;
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
 * 工会会员 controller
 * @author lxw
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UnionMemberControllerImpl implements UnionMemberController {

    /** 类属性配置 service */
    private final UnionMemberService unionMemberService;

    @Override
    public Result<UnionMemberVO> findOne(@ApiParam(value = "工会会员id", required = true) @PathVariable String id) {
        Optional<UnionMember> unionMemberOptional = unionMemberService.findOptionalById(id);
        return unionMemberOptional.map(unionMember -> Result.of(unionMember.convert(UnionMemberVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<UnionMemberVO> add(@ApiParam(value = "工会会员 DTO", required = true) @RequestBody @Validated UnionMemberDTO unionMemberDTO) {
        UnionMember unionMember = unionMemberService.save(unionMemberDTO.convert(UnionMember.class));
        return Result.ofAddSuccess(unionMember.convert(UnionMemberVO.class));
    }

    @Override
    public Result<UnionMemberVO> update(@ApiParam(value = "工会会员id", required = true) @PathVariable String id,
        @ApiParam(value = "工会会员 DTO", required = true) @RequestBody @Validated UnionMemberDTO unionMemberDTO) {
        Optional<UnionMember> unionMemberOptional = unionMemberService.findOptionalById(id);
        if (!unionMemberOptional.isPresent()) {
            return Result.ofLost();
        }
        UnionMember unionMember = unionMemberOptional.get();
        BeanUtils.copyProperties(unionMemberDTO, unionMember);
        unionMember = unionMemberService.save(unionMember);
        return Result.ofUpdateSuccess(unionMember.convert(UnionMemberVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "工会会员id", required = true) @PathVariable String id) {
        unionMemberService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<UnionMemberVO>> list(@ApiParam(value = "工会会员查询条件", required = true) @RequestBody UnionMemberSearchable unionMemberSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<UnionMember> unionMemberList = unionMemberService.findAll(unionMemberSearchable, sort);
        List<UnionMemberVO> unionMemberVOList = UnionMember.convert(unionMemberList, UnionMemberVO.class);
        return Result.of(unionMemberVOList);
    }

    @Override
    public Result<Page<UnionMemberVO>> page(@ApiParam(value = "工会会员查询条件", required = true) @RequestBody UnionMemberSearchable unionMemberSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<UnionMember> unionMemberPage = unionMemberService.findAll(unionMemberSearchable, pageable);
        Page<UnionMemberVO> unionMemberVOPage = UnionMember.convert(unionMemberPage, UnionMemberVO.class);
        return Result.of(unionMemberVOPage);
    }

}
