package com.cloudkeeper.leasing.identity.dto.teenagers;

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
public class TeenagersSearchable extends BaseSearchable {

    /** 姓名 */
    @ApiModelProperty(value = "姓名", position = 10, required = true)
    private String name;

    /** 性别 */
    @ApiModelProperty(value = "性别", position = 10, required = true)
    private String sex;

    /** 出生日期 */
    @ApiModelProperty(value = "出生日期", position = 10, required = true)
    private LocalDate birth;

    /** 政治面貌 */
    @ApiModelProperty(value = "政治面貌", position = 10, required = true)
    private String politicalStatus;

    /** 就读学校 */
    @ApiModelProperty(value = "就读学校", position = 10, required = true)
    private String school;

    /** 班级 */
    @ApiModelProperty(value = "班级", position = 10, required = true)
    private String grade;

    /** 联系方式 */
    @ApiModelProperty(value = "联系方式", position = 10, required = true)
    private String contact;

    /** 家庭地址 */
    @ApiModelProperty(value = "家庭地址", position = 10, required = true)
    private String address;

}