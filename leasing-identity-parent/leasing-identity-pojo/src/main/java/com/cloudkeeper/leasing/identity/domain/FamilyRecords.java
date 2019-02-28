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
@ApiModel(value = "家庭档案", description = "家庭档案")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "family_records")
public class FamilyRecords extends BaseEntity {

    /** 名称 */
    @ApiModelProperty(value = "户主ID", position = 1, required = true)
    @Column(length = 36)
    private String masterId;

    @ApiModelProperty(value = "户主name", position = 2, required = true)
    @Column(length = 36)
    private String masterName;

    @ApiModelProperty(value = "户主性别", position = 3, required = true)
    @Column(length = 36)
    private String masterSex;

    @ApiModelProperty(value = "联系方式", position = 4, required = true)
    @Column(length = 36)
    private String contact;

    @ApiModelProperty(value = "家庭月收入", position = 5, required = true)
    @Column(length = 36)
    private String monthIncome;

    @ApiModelProperty(value = "家庭成员数", position = 6, required = true)
    @Column(length = 36)
    private Integer  familyMembers;

    @ApiModelProperty(value = "是否享受低保", position = 7, required = true)
    @Column(length = 36)
    private String basicIncome;


    @ApiModelProperty(value = "党员家庭", position = 8, required = true)
    @Column(length = 36)
    private String partyFamily;

    @ApiModelProperty(value = "退伍军人家庭", position = 9, required = true)
    @Column(length = 36)
    private String veteranFamily;

    @ApiModelProperty(value = "困难家庭", position = 10, required = true)
    @Column(length = 36)
    private String hardFamily;

    @ApiModelProperty(value = "残疾家庭", position = 11, required = true)
    @Column(length = 36)
    private String disabledFamily;


}
