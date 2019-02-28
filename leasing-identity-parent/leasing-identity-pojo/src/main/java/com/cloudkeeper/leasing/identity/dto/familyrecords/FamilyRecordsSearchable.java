package com.cloudkeeper.leasing.identity.dto.familyrecords;

import com.cloudkeeper.leasing.base.dto.BaseSearchable;
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
 * 类属性配置 查询DTO
 * @author lxw
 */
@ApiModel(value = "家庭档案 查询DTO", description = "家庭档案 查询DTO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class FamilyRecordsSearchable extends BaseSearchable {

    /** 户主ID */
    @ApiModelProperty(value = "户主ID", position = 1, required = true)
    private String masterId;

    /** 户主name */
    @ApiModelProperty(value = "户主name", position = 2, required = true)
    private String masterName;

    /** 户主性别 */
    @ApiModelProperty(value = "户主性别", position = 3, required = true)
    private String masterSex;

    /** 联系方式 */
    @ApiModelProperty(value = "联系方式", position = 4, required = true)
    private String contact;

    /** 家庭月收入 */
    @ApiModelProperty(value = "家庭月收入", position = 5, required = true)
    private String monthIncome;

    /** 家庭成员数 */
    @ApiModelProperty(value = "家庭成员数", position = 6, required = true)
    private Integer familyMembers;

    /** 是否享受低保 */
    @ApiModelProperty(value = "是否享受低保", position = 7, required = true)
    private String basicIncome;

    /** 党员家庭 */
    @ApiModelProperty(value = "党员家庭", position = 8, required = true)
    private String partyFamily ;

    /** 退伍军人家庭 */
    @ApiModelProperty(value = "退伍军人家庭", position = 9, required = true)
    private String veteranFamily ;

    /** 困难家庭 */
    @ApiModelProperty(value = "困难家庭", position = 10, required = true)
    private String hardFamily ;

    /** 残疾家庭 */
    @ApiModelProperty(value = "残疾家庭", position = 11, required = true)
    private String disabledFamily ;

}
