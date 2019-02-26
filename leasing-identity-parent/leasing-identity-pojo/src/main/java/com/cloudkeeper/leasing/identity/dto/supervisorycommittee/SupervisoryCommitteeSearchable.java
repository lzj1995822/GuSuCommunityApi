package com.cloudkeeper.leasing.identity.dto.supervisorycommittee;

import com.cloudkeeper.leasing.base.dto.BaseSearchable;
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
 * 类属性配置 查询DTO
 * @author cqh
 */
@ApiModel(value = "类属性配置 查询DTO", description = "类属性配置 查询DTO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class SupervisoryCommitteeSearchable extends BaseSearchable {

    /** 姓名 */
    @ApiModelProperty(value = "姓名", position = 10, required = true)
    private String name;

    /** 性别 */
    @ApiModelProperty(value = "性别", position = 10, required = true)
    private String sex;

    /** 出生日期 */
    @ApiModelProperty(value = "出生日期", position = 10, required = true)
    private LocalDate birth;

    /** 证件类型 */
    @ApiModelProperty(value = "证件类型", position = 10, required = true)
    private String idType;

    /** 证件号码 */
    @ApiModelProperty(value = "证件号码", position = 10, required = true)
    private String idNumber;

    /** 联系方式 */
    @ApiModelProperty(value = "联系方式", position = 10, required = true)
    private String contact;

    /** 部门 */
    @ApiModelProperty(value = "部门", position = 10, required = true)
    private String department;

    /** 职位 */
    @ApiModelProperty(value = "职位", position = 10, required = true)
    private String post;

    /** 地址 */
    @ApiModelProperty(value = "地址", position = 10, required = true)
    private String address;

}