package com.cloudkeeper.leasing.identity.dto.sysmail;

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
public class SysMailSearchable extends BaseSearchable {

    /** 姓名 */
    @ApiModelProperty(value = "姓名", position = 10, required = true)
    private String mailName;

    /** 工号 */
    @ApiModelProperty(value = "工号", position = 10, required = true)
    private String mailId;

    /** 出生日期 */
    @ApiModelProperty(value = "出生日期", position = 10, required = true)
    private LocalDate mailBirth;

    /** 联系方式 */
    @ApiModelProperty(value = "联系方式", position = 10, required = true)
    private String mailPhone;

    /** 单位名称 */
    @ApiModelProperty(value = "单位名称", position = 10, required = true)
    private String mailCompany;

    /** 部门 */
    @ApiModelProperty(value = "部门", position = 10, required = true)
    private String mailDepartment;

    /** 职位 */
    @ApiModelProperty(value = "职位", position = 10, required = true)
    private String mailPost;

    /** 家庭地址 */
    @ApiModelProperty(value = "家庭地址", position = 10, required = true)
    private String mailAddress;

}