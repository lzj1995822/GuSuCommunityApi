package com.cloudkeeper.leasing.identity.service.impl;

import com.cloudkeeper.leasing.base.dto.BaseSearchable;
import com.cloudkeeper.leasing.base.repository.BaseRepository;
import com.cloudkeeper.leasing.base.service.impl.BaseServiceImpl;
import com.cloudkeeper.leasing.identity.domain.SysLoginLog;
import com.cloudkeeper.leasing.identity.dto.sysloginlog.SysLoginLogSearchable;
import com.cloudkeeper.leasing.identity.repository.SysLoginLogRepository;
import com.cloudkeeper.leasing.identity.service.SysLoginLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Nonnull;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * 类属性配置 service
 * @author lxw
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SysLoginLogServiceImpl extends BaseServiceImpl<SysLoginLog> implements SysLoginLogService {

    /** 类属性配置 repository */
    private final SysLoginLogRepository sysLoginLogRepository;

    @Override
    protected BaseRepository<SysLoginLog> getBaseRepository() {
        return sysLoginLogRepository;
    }

    @Override
    public ExampleMatcher defaultExampleMatcher() {
        return super.defaultExampleMatcher()
                .withMatcher("userName", ExampleMatcher.GenericPropertyMatchers.contains())
                .withMatcher("success", ExampleMatcher.GenericPropertyMatchers.contains());
    }

    @Nonnull
    @Override
    public Page<SysLoginLog> findAll(@Nonnull BaseSearchable searchable, @Nonnull Pageable pageable) {
        SysLoginLogSearchable sysLoginLogSearchable =  (SysLoginLogSearchable)searchable;
        List<Predicate> predicateList = new ArrayList<>();
        Specification specification = (Specification) (root, query, criteriaBuilder) -> {
            if (!StringUtils.isEmpty(sysLoginLogSearchable.getStartTime()) && !StringUtils.isEmpty(sysLoginLogSearchable.getEndTime())) {
                predicateList.add(criteriaBuilder.between(root.get("loginTime"), sysLoginLogSearchable.getStartTime(), sysLoginLogSearchable.getEndTime()));
            }
            if (!StringUtils.isEmpty(sysLoginLogSearchable.getStartTime()) && StringUtils.isEmpty(sysLoginLogSearchable.getEndTime())) {
                predicateList.add(criteriaBuilder.greaterThan(root.get("loginTime"), sysLoginLogSearchable.getStartTime()));
            }
            if (StringUtils.isEmpty(sysLoginLogSearchable.getStartTime()) && !StringUtils.isEmpty(sysLoginLogSearchable.getEndTime())) {
                predicateList.add(criteriaBuilder.lessThan(root.get("loginTime"), sysLoginLogSearchable.getEndTime()));
            }
            if (!StringUtils.isEmpty(sysLoginLogSearchable.getUserName())){
                predicateList.add(criteriaBuilder.like(root.get("userName"), "%" + sysLoginLogSearchable.getUserName() + "%"));
            }
            return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
        };
        return super.findAll(specification, pageable);
    }
}
