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
@Table(name = "party_supervisory_committee")
public class SupervisoryCommittee extends BaseEntity {

    /** 名称 */
    @ApiModelProperty(value = "姓名", position = 10, required = true)
    @Column(length = 60)
    private String name;

    @ApiModelProperty(value = "性别", position = 10, required = true)
    @Column(length = 60)
    private String sex;

    @ApiModelProperty(value = "出生日期", position = 10, required = true)
    @Column(length = 60)
    private LocalDate birth;

    @ApiModelProperty(value = "证件类型", position = 10, required = true)
    @Column(length = 60)
    private String idType;

    @ApiModelProperty(value = "证件号码", position = 10, required = true)
    @Column(length = 60)
    private String idNumber;

    @ApiModelProperty(value = "联系方式", position = 10, required = true)
    @Column(length = 60)
    private String contact;

    @ApiModelProperty(value = "部门", position = 10, required = true)
    @Column(length = 60)
    private String department;

    @ApiModelProperty(value = "职位", position = 10, required = true)
    @Column(length = 60)
    private String post;

    @ApiModelProperty(value = "地址", position = 10, required = true)
    @Column(length = 60)
    private String address;

}