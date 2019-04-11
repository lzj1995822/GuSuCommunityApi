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
 * 协会管理 VO
 * @author ZLA
 */
@ApiModel(value = "协会管理 VO", description = "协会管理 VO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class AssociationManagementVO extends BaseVO {

    /** 协会名称 */
    @ApiModelProperty(value = "协会名称", position = 1, required = true)
    private String associationName;

    /** 协会注册地址 */
    @ApiModelProperty(value = "协会注册地址", position = 2, required = true)
    private String associationAddress;

    /** 协会统一信用代码编号 */
    @ApiModelProperty(value = "协会统一信用代码编号", position = 3, required = true)
    private String creditCode;

    /** 法人 */
    @ApiModelProperty(value = "法人", position = 4, required = true)
    private String legalPerson;

    /** 法人电话 */
    @ApiModelProperty(value = "法人电话", position = 5, required = true)
    private String legalPersonPhone;

    /** 协会联系电话 */
    @ApiModelProperty(value = "协会联系电话", position = 6, required = true)
    private String associationContactNumber;

    /** 协会联系人 */
    @ApiModelProperty(value = "协会联系人", position = 7, required = true)
    private String associationContacts;

    /** 协会业务范畴 */
    @ApiModelProperty(value = "协会业务范畴", position = 8, required = true)
    private String associationBusiness;

    /** 协会注册日期 */
    @ApiModelProperty(value = "协会注册日期", position = 9, required = true)
    private LocalDate businessRegistrationDate;

    /** 协会有效期 */
    @ApiModelProperty(value = "协会有效期", position = 10, required = true)
    private String validityPeriod;

    /** 所在地理位置 */
    @ApiModelProperty(value = "所在地理位置", position = 11, required = true)
    private String geographicalPosition;

    /** 实景照片 */
    @ApiModelProperty(value = "实景照片", position = 12, required = true)
    private String photo;

}