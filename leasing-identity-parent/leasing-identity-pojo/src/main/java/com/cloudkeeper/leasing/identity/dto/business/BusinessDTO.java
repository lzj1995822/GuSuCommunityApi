package com.cloudkeeper.leasing.identity.dto.business;

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
 * @author cqh
 */
@ApiModel(value = "类属性配置 DTO", description = "类属性配置 DTO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class BusinessDTO extends BaseEditDTO {

    /** 企业名称 */
    @ApiModelProperty(value = "企业名称", position = 10, required = true)
    private String name;

    /** 统一信用代码 */
    @ApiModelProperty(value = "统一信用代码", position = 10, required = true)
    private String creditCode;

    /** 法人姓名 */
    @ApiModelProperty(value = "法人姓名", position = 10, required = true)
    private String legalPerson;

    /** 经营范围 */
    @ApiModelProperty(value = "经营范围", position = 10, required = true)
    private String businessScope;

    /** 公司地址 */
    @ApiModelProperty(value = "公司地址", position = 10, required = true)
    private String address;

    /** 地图点位 */
    @ApiModelProperty(value = "地图点位", position = 10, required = true)
    private String mapAddress;

}