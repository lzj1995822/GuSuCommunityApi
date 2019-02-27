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
 * @author cqh
 */
@ApiModel(value = "类属性配置", description = "类属性配置")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "economic_factory")
public class Factory extends BaseEntity {

    /** 名称 */
    @ApiModelProperty(value = "厂房名称", position = 10, required = true)
    @Column(length = 60)
    private String name;

    @ApiModelProperty(value = "厂房地址", position = 10, required = true)
    @Column(length = 60)
    private String address;

    @ApiModelProperty(value = "地图点位", position = 10, required = true)
    @Column(length = 60)
    private String mapAddress;

    @ApiModelProperty(value = "建设日期", position = 10, required = true)
    @Column(length = 60)
    private LocalDate constructionDate;

    @ApiModelProperty(value = "占地面积", position = 10, required = true)
    @Column(length = 60)
    private String area;

    @ApiModelProperty(value = "生产内容", position = 10, required = true)
    @Column(length = 60)
    private String production;

}