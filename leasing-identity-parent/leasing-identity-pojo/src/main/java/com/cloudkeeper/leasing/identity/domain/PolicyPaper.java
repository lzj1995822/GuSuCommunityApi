package com.cloudkeeper.leasing.identity.domain;

import com.cloudkeeper.leasing.base.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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

    @ApiModelProperty(value = "所属部门", position = 10, required = true)
    @Column(length = 60)
    private String organizationId;
}