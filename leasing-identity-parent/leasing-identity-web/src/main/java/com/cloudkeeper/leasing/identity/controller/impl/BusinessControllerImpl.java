package com.cloudkeeper.leasing.identity.controller.impl;

import com.cloudkeeper.leasing.base.model.Result;
import com.cloudkeeper.leasing.identity.controller.BusinessController;
import com.cloudkeeper.leasing.identity.domain.Business;
import com.cloudkeeper.leasing.identity.dto.business.BusinessDTO;
import com.cloudkeeper.leasing.identity.dto.business.BusinessSearchable;
import com.cloudkeeper.leasing.identity.service.BusinessService;
import com.cloudkeeper.leasing.identity.vo.BusinessVO;
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
public class BusinessControllerImpl implements BusinessController {

    /** 类属性配置 service */
    private final BusinessService businessService;

    @Override
    public Result<BusinessVO> findOne(@ApiParam(value = "类属性配置id", required = true) @PathVariable String id) {
        Optional<Business> businessOptional = businessService.findOptionalById(id);
        return businessOptional.map(business -> Result.of(business.convert(BusinessVO.class))).orElseGet(Result::ofNotFound);
    }

    @Override
    public Result<BusinessVO> add(@ApiParam(value = "类属性配置 DTO", required = true) @RequestBody @Validated BusinessDTO businessDTO) {
        Business business = businessService.save(businessDTO.convert(Business.class));
        return Result.ofAddSuccess(business.convert(BusinessVO.class));
    }

    @Override
    public Result<BusinessVO> update(@ApiParam(value = "类属性配置id", required = true) @PathVariable String id,
        @ApiParam(value = "类属性配置 DTO", required = true) @RequestBody @Validated BusinessDTO businessDTO) {
        Optional<Business> businessOptional = businessService.findOptionalById(id);
        if (!businessOptional.isPresent()) {
            return Result.ofLost();
        }
        Business business = businessOptional.get();
        BeanUtils.copyProperties(businessDTO, business);
        business = businessService.save(business);
        return Result.ofUpdateSuccess(business.convert(BusinessVO.class));
    }

    @Override
    public Result delete(@ApiParam(value = "类属性配置id", required = true) @PathVariable String id) {
        businessService.deleteById(id);
        return Result.ofDeleteSuccess();
    }

    @Override
    public Result<List<BusinessVO>> list(@ApiParam(value = "类属性配置查询条件", required = true) @RequestBody BusinessSearchable businessSearchable,
        @ApiParam(value = "排序条件", required = true) Sort sort) {
        List<Business> businessList = businessService.findAll(businessSearchable, sort);
        List<BusinessVO> businessVOList = Business.convert(businessList, BusinessVO.class);
        return Result.of(businessVOList);
    }

    @Override
    public Result<Page<BusinessVO>> page(@ApiParam(value = "类属性配置查询条件", required = true) @RequestBody BusinessSearchable businessSearchable,
        @ApiParam(value = "分页参数", required = true) Pageable pageable) {
        Page<Business> businessPage = businessService.findAll(businessSearchable, pageable);
        Page<BusinessVO> businessVOPage = Business.convert(businessPage, BusinessVO.class);
        return Result.of(businessVOPage);
    }

}