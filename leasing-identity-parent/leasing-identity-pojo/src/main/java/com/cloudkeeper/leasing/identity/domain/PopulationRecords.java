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
 * @author lxw
 */
@ApiModel(value = "类属性配置", description = "类属性配置")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "population_records")
public class PopulationRecords extends BaseEntity {

    /** 名称 */
    @ApiModelProperty(value = "名称", position = 10, required = true)
    @Column(length = 60)
    private String name;

//    personId
//            name
//    sex
//            birth
//    politicalStatus
//            nativePlace
//    nation
//            education
//    married
//            idCard
//    domicilePlace
//            presentAddress
//    currentEmployer
//            contact
//    picture
//            familyId
//    masterId
//            partyFamily
//    veteranFamily
//            hardFamily
//    disabledFamily


}
