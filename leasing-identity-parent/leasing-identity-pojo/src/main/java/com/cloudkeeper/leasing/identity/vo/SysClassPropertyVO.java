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
 * @author asher
 */
@ApiModel(value = "类属性配置 VO", description = "类属性配置 VO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class SysClassPropertyVO extends BaseVO {

    /** 类id */
    @ApiModelProperty(value = "类id", position = 1, required = true)
    private String classId;

    /** 属性名 */
    @ApiModelProperty(value = "属性名", position = 3, required = true)
    private String name;

    /** 数据类型 */
    @ApiModelProperty(value = "数据类型", position = 5)
    private String type;

    /** 长度 */
    @ApiModelProperty(value = "长度", position = 7)
    private Integer length;

    /** 属性描述 */
    @ApiModelProperty(value = "属性描述", position = 9)
    private String des;

}