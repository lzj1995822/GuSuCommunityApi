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
@ApiModel(value = "优秀党员", description = "优秀党员")
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "party_member_excellent")
public class PartyMemberExcellent extends BaseEntity {

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

    @ApiModelProperty(value = "评定时间", position = 10, required = true)
    @Column(length = 36)
    private LocalDate evaluateTime;

    @ApiModelProperty(value = "照片", position = 14, required = true)
    @Column(length = 600)
    private String picture;


}
