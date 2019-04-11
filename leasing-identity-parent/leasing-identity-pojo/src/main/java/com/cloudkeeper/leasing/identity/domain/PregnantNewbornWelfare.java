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
 * 孕妇新生儿福利
 * @author ZLA
 */
@ApiModel(value = "孕妇新生儿福利", description = "孕妇新生儿福利")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pregnant_newborn_welfare")
public class PregnantNewbornWelfare extends BaseEntity {

    /** 福利类型 */
    @ApiModelProperty(value = "福利类型", position = 1, required = true)
    @Column(length = 36)
    private String welfareType;
    /** 发放时间 */
    @ApiModelProperty(value = "发放时间", position = 2, required = true)
    @Column(length = 36)
    private LocalDate grantTime;
    /** 发放金额 */
    @ApiModelProperty(value = "发放金额", position = 3, required = true)
    @Column(length = 36)
    private String grantAmount;
    /** 享受人姓名 */
    @ApiModelProperty(value = "享受人姓名", position = 4, required = true)
    @Column(length = 36)
    private String beneficiaryName;
    /** 享受人电话 */
    @ApiModelProperty(value = "享受人电话", position = 5, required = true)
    @Column(length = 36)
    private String beneficiaryPhone;
    /** 家庭住址 */
    @ApiModelProperty(value = "家庭住址", position = 6, required = true)
    @Column(length = 60)
    private String address;
    /** 家庭户编号 */
    @ApiModelProperty(value = "家庭户编号", position = 7, required = true)
    @Column(length = 36)
    private String familyId;
    /** 所在地理位置 */
    @ApiModelProperty(value = "所在地理位置", position = 8, required = true)
    @Column(length = 60)
    private String geographicalPosition;


}