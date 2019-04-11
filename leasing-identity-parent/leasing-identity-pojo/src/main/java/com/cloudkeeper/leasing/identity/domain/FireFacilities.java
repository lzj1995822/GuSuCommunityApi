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
 * @author ZLA
 */
@ApiModel(value = "消防设施", description = "消防设施")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "fire_facilities")
public class FireFacilities extends BaseEntity {

    /** 器材类型 */
    @ApiModelProperty(value = "器材类型", position = 1, required = true)
    @Column(length = 36)
    private String equipmentType;

    /** 器材编号 */
    @ApiModelProperty(value = "器材编号", position = 2, required = true)
    @Column(length = 36)
    private String equipmentNumber;

    /** 发放时间 */
    @ApiModelProperty(value = "发放时间", position = 3, required = true)
    @Column(length = 36)
    private LocalDate grantTime;

    /** 有效期 */
    @ApiModelProperty(value = "有效期", position = 4, required = true)
    @Column(length = 36)
    private String validityPeriod;

    /** 对应家庭户籍编号 */
    @ApiModelProperty(value = "对应家庭户籍编号", position = 5, required = true)
    @Column(length = 36)
    private String familyId;

    /** 户主姓名 */
    @ApiModelProperty(value = "户主姓名", position = 6, required = true)
    @Column(length = 36)
    private String masterName;

    /** 户主电话 */
    @ApiModelProperty(value = "户主电话", position = 7, required = true)
    @Column(length = 36)
    private String masterPhone;

    /** 所在地理位置 */
    @ApiModelProperty(value = "所在地理位置", position = 8, required = true)
    @Column(length = 36)
    private String geographicalPosition;

}