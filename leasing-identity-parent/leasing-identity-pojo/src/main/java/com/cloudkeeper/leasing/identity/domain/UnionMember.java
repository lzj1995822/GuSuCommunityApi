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
import java.time.LocalDate;

/**
 * 类属性配置
 * @author lxw
 */
@ApiModel(value = "类属性配置", description = "类属性配置")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "union_member")
public class UnionMember extends BaseEntity {

    @ApiModelProperty(value = "编号", position = 1, required = true)
    @Column(length = 60)
    private String code;

    @ApiModelProperty(value = "姓名", position = 2, required = true)
    @Column(length = 60)
    private String name;

    @ApiModelProperty(value = "性别", position = 3, required = true)
    @Column(length = 60)
    private String sex;

    @ApiModelProperty(value = "出生年月", position = 4, required = true)
    @Column(length = 60)
    private LocalDate birthDate;

    @ApiModelProperty(value = "民族", position = 5, required = true)
    @Column(length = 60)
    private String userNation;

    @ApiModelProperty(value = "学历", position = 6, required = true)
    @Column(length = 60)
    private String education;

    @ApiModelProperty(value = "是否已婚", position = 7, required = true)
    @Column(length = 60)
    private String married;

    @ApiModelProperty(value = "参加工作时间", position = 8, required = true)
    @Column(length = 60)
    private LocalDate joinTime;

    @ApiModelProperty(value = "籍贯", position = 9, required = true)
    @Column(length = 60)
    private String nativePlace;

    @ApiModelProperty(value = "职称及技能等级", position = 11, required = true)
    @Column(length = 250)
    private String skillLevel;

    @ApiModelProperty(value = "工作部门及岗位", position = 12, required = true)
    @Column(length = 250)
    private String workDepartments;

    @ApiModelProperty(value = "家庭主要成员及其工作单位", position = 13, required = true)
    @Column(length = 250)
    private String familMembers;

    @ApiModelProperty(value = "个人简历", position = 14, required = true)
    @Column(length = 250)
    private String resume;

}
