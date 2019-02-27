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
@Table(name = "economic_business")
public class Business extends BaseEntity {

    /** 名称 */
    @ApiModelProperty(value = "企业名称", position = 10, required = true)
    @Column(length = 60)
    private String name;

    @ApiModelProperty(value = "统一信用代码", position = 10, required = true)
    @Column(length = 60)
    private String creditCode;

    @ApiModelProperty(value = "法人姓名", position = 10, required = true)
    @Column(length = 60)
    private String legalPerson;

    @ApiModelProperty(value = "经营范围", position = 10, required = true)
    @Column(length = 60)
    private String businessScope;

    @ApiModelProperty(value = "公司地址", position = 10, required = true)
    @Column(length = 60)
    private String address;

    @ApiModelProperty(value = "地图点位", position = 10, required = true)
    @Column(length = 60)
    private String mapAddress;

}