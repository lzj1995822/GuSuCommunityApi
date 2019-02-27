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
 * @author cqh
 */
@ApiModel(value = "类属性配置 VO", description = "类属性配置 VO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class FactoryVO extends BaseVO {

    /** 厂房名称 */
    @ApiModelProperty(value = "厂房名称", position = 10, required = true)
    private String name;

    /** 厂房地址 */
    @ApiModelProperty(value = "厂房地址", position = 10, required = true)
    private String address;

    /** 地图点位 */
    @ApiModelProperty(value = "地图点位", position = 10, required = true)
    private String mapAddress;

    /** 建设日期 */
    @ApiModelProperty(value = "建设日期", position = 10, required = true)
    private LocalDate constructionDate;

    /** 占地面积 */
    @ApiModelProperty(value = "占地面积", position = 10, required = true)
    private String area;

    /** 生产内容 */
    @ApiModelProperty(value = "生产内容", position = 10, required = true)
    private String production;

}