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
 * @author lxw
 */
@ApiModel(value = "组织架构", description = "组织架构")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "organization_structure")
public class OrganizationStructure extends BaseEntity {


    @ApiModelProperty(value = "名字", position = 1, required = true)
    @Column(length = 60)
    private String name;

    @ApiModelProperty(value = "性别", position = 3, required = true)
    @Column(length = 60)
    private String sex;

    @ApiModelProperty(value = "职务", position = 5, required = true)
    @Column(length = 60)
    private String duties;

    @ApiModelProperty(value = "部门", position = 7, required = true)
    @Column(length = 60)
    private String departmentName;

    @ApiModelProperty(value = "部门ID", position = 7, required = true)
    @Column(length = 60)
    private String departmentId;

    @ApiModelProperty(value = "职位", position = 9, required = true)
    @Column(length = 60)
    private String position;

    @ApiModelProperty(value = "联系方式", position = 11, required = true)
    @Column(length = 60)
    private String contact;

    @ApiModelProperty(value = "上级", position = 13, required = true)
    @Column(length = 60)
    private String superior;

    @ApiModelProperty(value = "照片", position = 15, required = true)
    @Column(length = 60)
    private String picture;

}
