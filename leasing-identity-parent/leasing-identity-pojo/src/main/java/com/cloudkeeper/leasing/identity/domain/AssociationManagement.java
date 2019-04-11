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
 * 协会管理
 * @author ZLA
 */
@ApiModel(value = "协会管理", description = "协会管理")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "association_management")
public class AssociationManagement extends BaseEntity {

    /** 协会名称 */
    @ApiModelProperty(value = "协会名称", position = 1, required = true)
    @Column(length = 36)
    private String associationName;

    /** 协会注册地址 */
    @ApiModelProperty(value = "协会注册地址", position = 2, required = true)
    @Column(length = 36)
    private String associationAddress;

    /** 协会统一信用代码编号 */
    @ApiModelProperty(value = "协会统一信用代码编号", position = 3, required = true)
    @Column(length = 36)
    private String creditCode;

    /** 法人 */
    @ApiModelProperty(value = "法人", position = 4, required = true)
    @Column(length = 36)
    private String legalPerson;

    /** 法人电话 */
    @ApiModelProperty(value = "法人电话", position = 5, required = true)
    @Column(length = 36)
    private String legalPersonPhone;

    /** 协会联系电话 */
    @ApiModelProperty(value = "协会联系电话", position = 6, required = true)
    @Column(length = 36)
    private String associationContactNumber;

    /** 协会联系人 */
    @ApiModelProperty(value = "协会联系人", position = 7, required = true)
    @Column(length = 36)
    private String associationContacts;

    /** 协会业务范畴 */
    @ApiModelProperty(value = "协会业务范畴", position = 8, required = true)
    @Column(length = 60)
    private String associationBusiness;

    /** 协会注册日期 */
    @ApiModelProperty(value = "协会注册日期", position = 9, required = true)
    @Column(length = 36)
    private LocalDate businessRegistrationDate;

    /** 协会有效期 */
    @ApiModelProperty(value = "协会有效期", position = 10, required = true)
    @Column(length = 36)
    private String validityPeriod;

    /** 所在地理位置 */
    @ApiModelProperty(value = "所在地理位置", position = 11, required = true)
    @Column(length = 60)
    private String geographicalPosition;

    /** 实景照片 */
    @ApiModelProperty(value = "实景照片", position = 12, required = true)
    @Column(length = 60)
    private String photo;

}