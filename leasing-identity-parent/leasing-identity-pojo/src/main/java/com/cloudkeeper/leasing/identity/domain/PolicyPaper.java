package com.cloudkeeper.leasing.identity.domain;


import com.cloudkeeper.leasing.base.domain.BaseEntity;
import com.cloudkeeper.leasing.identity.vo.PolicyPaperVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import liquibase.util.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.annotation.Nonnull;
import javax.persistence.*;

/**
 * 类属性配置
 * @author cqh
 */
@ApiModel(value = "类属性配置", description = "类属性配置")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "policy_paper")
public class PolicyPaper extends BaseEntity {

    /** 名称 */
    @ApiModelProperty(value = "标题", position = 10, required = true)
    @Column(length = 60)
    private String title;

    @ApiModelProperty(value = "作者", position = 10, required = true)
    @Column(length = 60)
    private String author;

    @ApiModelProperty(value = "内容", position = 10, required = true)
    @Column(length = 60)
    private String content;

    @ApiModelProperty(value = "附件", position = 10, required = true)
    @Column(length = 60)
    private String enclosure;

    @ApiModelProperty(value = "所属部门id", position = 10, required = true)
    @Column(length = 60)
    private String organizationId;

    @ApiModelProperty(value = "所属部门", position = 10, required = true)
    @ManyToOne
    @JoinColumn(name = "organizationId",insertable = false, updatable = false)
    private Organization organization;

    @Nonnull
    @Override
    public <T> T convert(@Nonnull Class<T> clazz) {
        T convert = super.convert(clazz);
        PolicyPaperVO policyPaperVO = (PolicyPaperVO) convert;
        if(!StringUtils.isEmpty( policyPaperVO.getOrganizationId())) {
            policyPaperVO.setOrganizationName(this.organization.getName());
        }
        return (T) policyPaperVO;
    }
}
