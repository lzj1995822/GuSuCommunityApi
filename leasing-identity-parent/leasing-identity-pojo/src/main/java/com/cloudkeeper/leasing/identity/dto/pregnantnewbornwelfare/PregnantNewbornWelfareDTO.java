package com.cloudkeeper.leasing.identity.dto.pregnantnewbornwelfare;

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
 * 孕妇新生儿福利 DTO
 * @author ZLA
 */
@ApiModel(value = "孕妇新生儿福利 DTO", description = "孕妇新生儿福利 DTO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class PregnantNewbornWelfareDTO extends BaseEditDTO {

    /** 福利类型 */
    @ApiModelProperty(value = "福利类型", position = 1, required = true)
    private String welfareType;

    /** 发放时间 */
    @ApiModelProperty(value = "发放时间", position = 2, required = true)
    private LocalDate grantTime;

    /** 发放金额 */
    @ApiModelProperty(value = "发放金额", position = 3, required = true)
    private String grantAmount;

    /** 享受人姓名 */
    @ApiModelProperty(value = "享受人姓名", position = 4, required = true)
    private String beneficiaryName;

    /** 享受人电话 */
    @ApiModelProperty(value = "享受人电话", position = 5, required = true)
    private String beneficiaryPhone;

    /** 家庭住址 */
    @ApiModelProperty(value = "家庭住址", position = 6, required = true)
    private String address;

    /** 家庭户编号 */
    @ApiModelProperty(value = "家庭户编号", position = 7, required = true)
    private String familyId;

    /** 所在地理位置 */
    @ApiModelProperty(value = "所在地理位置", position = 8, required = true)
    private String geographicalPosition;

}