package com.cloudkeeper.leasing.identity.domain;

import com.cloudkeeper.leasing.base.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import java.time.LocalDate;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 类属性配置
 * @author lxw
 */
@ApiModel(value = "人口档案", description = "人口档案")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "population_records")
public class PopulationRecords extends BaseEntity {

    /** 名称 */
    @ApiModelProperty(value = "姓名", position = 2, required = true)
    @Column(length = 36)
    private String name;

    @ApiModelProperty(value = "人员ID", position = 1, required = true)
    @Column(length = 36)
    private String personId;

    @ApiModelProperty(value = "性别", position = 3, required = true)
    @Column(length = 36)
    private String sex;

    @ApiModelProperty(value = "出生年月", position = 4, required = true)
    @Column(length = 36)
    private LocalDate birth;

    @ApiModelProperty(value = "政治面貌", position = 5, required = true)
    @Column(length = 36)
    private String politicalStatus;

    @ApiModelProperty(value = "籍贯", position = 6, required = true)
    @Column(length = 36)
    private String nativePlace;

    @ApiModelProperty(value = "民族", position = 7, required = true)
    @Column(length = 36)
    private String nation;

    @ApiModelProperty(value = "学历", position = 8, required = true)
    @Column(length = 36)
    private String education;

    @ApiModelProperty(value = "是否已婚", position = 9, required = true)
    @Column(length = 36)
    private String married;

    @ApiModelProperty(value = "身份证号码", position = 10, required = true)
    @Column(length = 36)
    private String idCard;

    @ApiModelProperty(value = "户口所在地", position = 11, required = true)
    @Column(length = 36)
    private String domicilePlace;

    @ApiModelProperty(value = "现住址", position = 12, required = true)
    @Column(length = 36)
    private String presentAddress;

    @ApiModelProperty(value = "现工作单位", position = 13, required = true)
    @Column(length = 36)
    private String currentEmployer;

    @ApiModelProperty(value = "联系方式", position = 14, required = true)
    @Column(length = 36)
    private String contact;

    @ApiModelProperty(value = "照片", position = 15, required = true)
    @Column(length = 36)
    private String picture;

    @ApiModelProperty(value = "家庭ID", position = 16, required = true)
    @Column(length = 36)
    private String familyId;

    @ApiModelProperty(value = "户主ID", position = 17, required = true)
    @Column(length = 36)
    private String masterId;

    @ApiModelProperty(value = "党员家庭", position = 18, required = true)
    @Column(length = 36)
    private String  partyFamily;

    @ApiModelProperty(value = "退伍军人家庭", position = 19, required = true)
    @Column(length = 36)
    private String veteranFamily;

    @ApiModelProperty(value = "困难家庭", position = 20, required = true)
    @Column(length = 36)
    private String hardFamily;

    @ApiModelProperty(value = "残疾家庭", position = 21, required = true)
    @Column(length = 36)
    private String disabledFamily;


}
