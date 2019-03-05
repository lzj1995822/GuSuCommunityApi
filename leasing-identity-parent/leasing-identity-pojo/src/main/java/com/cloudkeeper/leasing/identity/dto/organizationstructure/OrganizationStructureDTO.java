package com.cloudkeeper.leasing.identity.dto.organizationstructure;

import com.cloudkeeper.leasing.base.dto.BaseEditDTO;
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
 * 类属性配置 DTO
 * @author lxw
 */
@ApiModel(value = "组织架构 DTO", description = "组织架构 DTO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationStructureDTO extends BaseEditDTO {

    /** 名字 */
    @ApiModelProperty(value = "名字", position = 1, required = true)
    private String name;

    /** 性别 */
    @ApiModelProperty(value = "性别", position = 3, required = true)
    private String sex;

    /** 职务 */
    @ApiModelProperty(value = "职务", position = 5, required = true)
    private String duties;

    /** 部门 */
    @ApiModelProperty(value = "部门", position = 7, required = true)
    private String aliasName;

    @ApiModelProperty(value = "部门ID", position = 7, required = true)
    private String departmentId;

    /** 职位 */
    @ApiModelProperty(value = "职位", position = 9, required = true)
    private String position;

    /** 联系方式 */
    @ApiModelProperty(value = "联系方式", position = 11, required = true)
    private String contact;

    /** 上级 */
    @ApiModelProperty(value = "上级", position = 13, required = true)
    private String superior;

    /** 照片 */
    @ApiModelProperty(value = "照片", position = 15, required = true)
    private String picture;

}
