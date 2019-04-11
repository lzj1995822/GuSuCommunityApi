package com.cloudkeeper.leasing.identity.dto.firefacilities;

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
 * 消防设施 DTO
 * @author ZLA
 */
@ApiModel(value = "消防设施 DTO", description = "消防设施 DTO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class FireFacilitiesDTO extends BaseEditDTO {

    /** 器材类型 */
    @ApiModelProperty(value = "器材类型", position = 1, required = true)
    private String equipmentType;

    /** 器材编号 */
    @ApiModelProperty(value = "器材编号", position = 2, required = true)
    private String equipmentNumber;

    /** 发放时间 */
    @ApiModelProperty(value = "发放时间", position = 3, required = true)
    private LocalDate grantTime;

    /** 有效期 */
    @ApiModelProperty(value = "有效期", position = 4, required = true)
    private String validityPeriod;

    /** 对应家庭户籍编号 */
    @ApiModelProperty(value = "对应家庭户籍编号", position = 5, required = true)
    private String familyId;

    /** 户主姓名 */
    @ApiModelProperty(value = "户主姓名", position = 6, required = true)
    private String masterName;

    /** 户主电话 */
    @ApiModelProperty(value = "户主电话", position = 7, required = true)
    private String masterPhone;

    /** 所在地理位置 */
    @ApiModelProperty(value = "所在地理位置", position = 8, required = true)
    private String geographicalPosition;

}