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
 * @author cqh
 */
@ApiModel(value = "类属性配置", description = "类属性配置")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sys_mail")
public class SysMail extends BaseEntity {

    /** 名称 */
    @ApiModelProperty(value = "姓名", position = 10, required = true)
    @Column(length = 60)
    private String mailName;

    /** 工号 */
    @ApiModelProperty(value = "工号", position = 10, required = true)
    @Column(length = 60)
    private String mailId;

    /** 出生日期 */
    @ApiModelProperty(value = "出生日期", position = 10, required = true)
    @Column(length = 60)
    private LocalDate mailBirth;

    /** 联系方式 */
    @ApiModelProperty(value = "联系方式", position = 10, required = true)
    @Column(length = 60)
    private String mailPhone;

    /** 单位名称 */
    @ApiModelProperty(value = "单位名称", position = 10, required = true)
    @Column(length = 60)
    private String mailCompany;

    /** 部门 */
    @ApiModelProperty(value = "部门", position = 10, required = true)
    @Column(length = 60)
    private String mailDepartment;

    /** 职位 */
    @ApiModelProperty(value = "职位", position = 10, required = true)
    @Column(length = 60)
    private String mailPost;

    /** 家庭地址 */
    @ApiModelProperty(value = "家庭地址", position = 10, required = true)
    @Column(length = 60)
    private String mailAddress;

}