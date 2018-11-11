package com.cloudkeeper.leasing.identity.dto.sysclass;

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
 * 系统java类 查询DTO
 * @author asher
 */
@ApiModel(value = "系统java类 查询DTO", description = "系统java类 查询DTO")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class SysClassSearchable extends BaseSearchable {

    /** 类名 */
    @ApiModelProperty(value = "类名", position = 10, required = true)
    private String name;

    /** 类描述 */
    @ApiModelProperty(value = "类描述", position = 10, required = true)
    private String des;

}