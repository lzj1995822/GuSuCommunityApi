package com.cloudkeeper.leasing.identity.dto.partymemberexcellent;

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
 * 类属性配置 DTO
 * @author lxw
 */
@ApiModel(value = "优秀党员 DTO", description = "优秀党员 DTO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class PartyMemberExcellentDTO extends BaseEditDTO {

    /** 姓名 */
    @ApiModelProperty(value = "姓名", position = 1, required = true)
    private String userName;

    /** 身份证 */
    @ApiModelProperty(value = "身份证", position = 2, required = true)
    private String identityNumber;

    /** 性别 */
    @ApiModelProperty(value = "性别", position = 3, required = true)
    private String userSex;

    /** 民族 */
    @ApiModelProperty(value = "民族", position = 4, required = true)
    private String userNation;

    /** 出生日期 */
    @ApiModelProperty(value = "出生日期", position = 5, required = true)
    private LocalDate birthDate;

    /** 学历 */
    @ApiModelProperty(value = "学历", position = 6, required = true)
    private String education;

    /** 所在党组织 */
    @ApiModelProperty(value = "所在党组织", position = 7, required = true)
    private String partyOrg;

    /** 入党时间 */
    @ApiModelProperty(value = "入党时间", position = 8, required = true)
    private LocalDate joinTime;

    /** 转正时间 */
    @ApiModelProperty(value = "转正时间", position = 9, required = true)
    private LocalDate fullTime;

    /** 评定时间 */
    @ApiModelProperty(value = "评定时间", position = 10, required = true)
    private LocalDate evaluateTime;

}
