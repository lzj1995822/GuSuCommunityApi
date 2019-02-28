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
 * @author lxw
 */
@ApiModel(value = "类属性配置", description = "类属性配置")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "party_member")
public class PartyMember extends BaseEntity {

    @ApiModelProperty(value = "姓名", position = 1, required = true)
    @Column(length = 36)
    private String userName;

    @ApiModelProperty(value = "身份证", position = 2, required = true)
    @Column(length = 36)
    private String identityNumber;

    @ApiModelProperty(value = "性别", position = 3, required = true)
    @Column(length = 36)
    private String userSex;

    @ApiModelProperty(value = "民族", position = 4, required = true)
    @Column(length = 36)
    private String userNation;

    @ApiModelProperty(value = "出生日期", position = 5, required = true)
    @Column(length = 36)
    private LocalDate birthDate;

    @ApiModelProperty(value = "学历", position = 6, required = true)
    @Column(length = 36)
        private String education;

    @ApiModelProperty(value = "所在党组织", position = 7, required = true)
    @Column(length = 36)
    private String partyOrg;

    @ApiModelProperty(value = "入党时间", position = 8, required = true)
    @Column(length = 36)
    private LocalDate joinTime;

    @ApiModelProperty(value = "转正时间", position = 9, required = true)
    @Column(length = 36)
    private LocalDate fullTime;

    @ApiModelProperty(value = "工作岗位", position = 10, required = true)
    @Column(length = 36)
    private String userJob;

    @ApiModelProperty(value = "家庭地址", position = 11, required = true)
    @Column(length = 36)
    private String userAddress;

    @ApiModelProperty(value = "联系电话", position = 12, required = true)
    @Column(length = 36)
    private String phoneNumber;

    @ApiModelProperty(value = "固定电话", position = 13, required = true)
    @Column(length = 36)
    private String fixedTelephone;



}
