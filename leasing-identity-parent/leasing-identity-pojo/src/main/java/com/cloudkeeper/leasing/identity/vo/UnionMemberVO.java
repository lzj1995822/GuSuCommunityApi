package com.cloudkeeper.leasing.identity.vo;

import com.cloudkeeper.leasing.base.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 类属性配置 VO
 * @author lxw
 */
@ApiModel(value = "类属性配置 VO", description = "类属性配置 VO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class UnionMemberVO extends BaseVO {

    /** 编号 */
    @ApiModelProperty(value = "编号", position = 1, required = true)
    private String code;

    /** 姓名 */
    @ApiModelProperty(value = "姓名", position = 2, required = true)
    private String name;

    /** 性别 */
    @ApiModelProperty(value = "性别", position = 3, required = true)
    private String sex;

    /** 出生年月 */
    @ApiModelProperty(value = "出生年月", position = 4, required = true)
    private LocalDate birthDate;

    /** 民族 */
    @ApiModelProperty(value = "民族", position = 5, required = true)
    private String userNation;

    /** 学历 */
    @ApiModelProperty(value = "学历", position = 6, required = true)
    private String education;

    /** 是否已婚 */
    @ApiModelProperty(value = "是否已婚", position = 7, required = true)
    private String married;

    /** 参加工作时间 */
    @ApiModelProperty(value = "参加工作时间", position = 8, required = true)
    private LocalDate joinTime;

    /** 籍贯 */
    @ApiModelProperty(value = "籍贯", position = 9, required = true)
    private String nativePlace;

    /** 职称及技能等级 */
    @ApiModelProperty(value = "职称及技能等级", position = 11, required = true)
    private String skillLevel;

    /** 工作部门及岗位 */
    @ApiModelProperty(value = "工作部门及岗位", position = 12, required = true)
    private String workDepartments;

    /** 家庭主要成员及其工作单位 */
    @ApiModelProperty(value = "家庭主要成员及其工作单位", position = 13, required = true)
    private String familMembers;

    /** 个人简历 */
    @ApiModelProperty(value = "个人简历", position = 14, required = true)
    private String resume;

}