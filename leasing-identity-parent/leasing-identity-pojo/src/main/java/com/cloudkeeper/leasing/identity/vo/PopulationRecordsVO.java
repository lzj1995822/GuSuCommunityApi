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
public class PopulationRecordsVO extends BaseVO {

    /** 姓名 */
    @ApiModelProperty(value = "姓名", position = 2, required = true)
    private String name;

    /** 人员ID */
    @ApiModelProperty(value = "人员ID", position = 1, required = true)
    private String personId;

    /** 性别 */
    @ApiModelProperty(value = "性别", position = 3, required = true)
    private String sex;

    /** 出生年月 */
    @ApiModelProperty(value = "出生年月", position = 4, required = true)
    private LocalDate birth;

    /** 政治面貌 */
    @ApiModelProperty(value = "政治面貌", position = 5, required = true)
    private String politicalStatus;

    /** 籍贯 */
    @ApiModelProperty(value = "籍贯", position = 6, required = true)
    private String nativePlace;

    /** 民族 */
    @ApiModelProperty(value = "民族", position = 7, required = true)
    private String nation;

    /** 学历 */
    @ApiModelProperty(value = "学历", position = 8, required = true)
    private String education;

    /** 是否已婚 */
    @ApiModelProperty(value = "是否已婚", position = 9, required = true)
    private String married;

    /** 身份证号码 */
    @ApiModelProperty(value = "身份证号码", position = 10, required = true)
    private String idCard;

    /** 户口所在地 */
    @ApiModelProperty(value = "户口所在地", position = 11, required = true)
    private String domicilePlace;

    /** 现住址 */
    @ApiModelProperty(value = "现住址", position = 12, required = true)
    private String presentAddress;

    /** 现工作单位 */
    @ApiModelProperty(value = "现工作单位", position = 13, required = true)
    private String currentEmployer;

    /** 联系方式 */
    @ApiModelProperty(value = "联系方式", position = 14, required = true)
    private String contact;

    /** 照片 */
    @ApiModelProperty(value = "照片", position = 15, required = true)
    private String picture;

    /** 家庭ID */
    @ApiModelProperty(value = "家庭ID", position = 16, required = true)
    private String familyId;

    /** 户主ID */
    @ApiModelProperty(value = "户主ID", position = 17, required = true)
    private String masterId;

    /** 党员家庭 */
    @ApiModelProperty(value = "党员家庭", position = 18, required = true)
    private String partyFamily;

    /** 退伍军人家庭 */
    @ApiModelProperty(value = "退伍军人家庭", position = 19, required = true)
    private String veteranFamily;

    /** 困难家庭 */
    @ApiModelProperty(value = "困难家庭", position = 20, required = true)
    private String hardFamily;

    /** 残疾家庭 */
    @ApiModelProperty(value = "残疾家庭", position = 21, required = true)
    private String disabledFamily;

}