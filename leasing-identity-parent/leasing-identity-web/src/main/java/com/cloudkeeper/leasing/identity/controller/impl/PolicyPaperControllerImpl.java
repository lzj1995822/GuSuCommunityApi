package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.PolicyPaperController;
import com.cloudkeeper.leasing.identity.domain.PolicyPaper;
import com.cloudkeeper.leasing.identity.dto.policypaper.PolicyPaperDTO;
import com.cloudkeeper.leasing.identity.dto.policypaper.PolicyPaperSearchable;
import com.cloudkeeper.leasing.identity.service.PolicyPaperService;
import com.cloudkeeper.leasing.identity.vo.PolicyPaperVO;
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
public class PolicyPaperControllerImpl implements PolicyPaperController {

    /** 类属性配置 service */
    private final PolicyPaperService policyPaperService;

    @Override
    public Result<PolicyPaperVO> findOne(@ApiParam(value = "类属性配置id", required = true) @PathVariable String id) {
        Optional<PolicyPaper> policyPaperOptional = policyPaperService.findOptionalById(id);
        return policyPaperOptional.map(policyPaper -> Result.of(policyPaper.convert(PolicyPaperVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<PolicyPaperVO> add(@ApiParam(value = "类属性配置 DTO", required = true) @RequestBody @Validated PolicyPaperDTO policyPaperDTO) {
        PolicyPaper policyPaper = policyPaperService.save(policyPaperDTO.convert(PolicyPaper.class));
        return Result.ofAddSuccess(policyPaper.convert(PolicyPaperVO.class));
    }

    @Override
    public Result<PolicyPaperVO> update(@ApiParam(value = "类属性配置id", required = true) @PathVariable String id,
        @ApiParam(value = "类属性配置 DTO", required = true) @RequestBody @Validated PolicyPaperDTO policyPaperDTO) {
        Optional<PolicyPaper> policyPaperOptional = policyPaperService.findOptionalById(id);
        if (!policyPaperOptional.isPresent()) {
            return Result.ofLost();
        }
        PolicyPaper policyPaper = policyPaperOptional.get();
        BeanUtils.copyProperties(policyPaperDTO, policyPaper);
        policyPaper = policyPaperService.save(policyPaper);
        return Result.ofUpdateSuccess(policyPaper.convert(PolicyPaperVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "类属性配置id", required = true) @PathVariable String id) {
        policyPaperService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<PolicyPaperVO>> list(@ApiParam(value = "类属性配置查询条件", required = true) @RequestBody PolicyPaperSearchable policyPaperSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<PolicyPaper> policyPaperList = policyPaperService.findAll(policyPaperSearchable, sort);
        List<PolicyPaperVO> policyPaperVOList = PolicyPaper.convert(policyPaperList, PolicyPaperVO.class);
        return Result.of(policyPaperVOList);
    }

    @Override
    public Result<Page<PolicyPaperVO>> page(@ApiParam(value = "类属性配置查询条件", required = true) @RequestBody PolicyPaperSearchable policyPaperSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<PolicyPaper> policyPaperPage = policyPaperService.findAll(policyPaperSearchable, pageable);
        Page<PolicyPaperVO> policyPaperVOPage = PolicyPaper.convert(policyPaperPage, PolicyPaperVO.class);
        return Result.of(policyPaperVOPage);
    }

}