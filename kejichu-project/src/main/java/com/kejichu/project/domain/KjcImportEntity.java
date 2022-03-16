package com.kejichu.project.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kejichu.common.annotation.Excel;
import com.kejichu.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

public class KjcImportEntity extends BaseEntity {

    //项目信息对象 kjc_project

    /** 项目编号 */
    @Excel(name = "项目编号")
    private String projectBianhao;

    /** 负责人名字 */
    @Excel(name = "负责人")
    private String projectLeader;

    /** 项目状态 */
    @Excel(name = "项目状态")
    private String projectStatus;

    /*****************************************/
    //绩效记录对象 kjc_jixiao

    /** 绩效总金额 */
    @Excel(name = "绩效总金额")
    private BigDecimal jixiaoMoney;

    /*********************************/
    //拨款记录对象 kjc_grant

    /** 拨款批次 */
    @Excel(name = "拨款批次")
    private Long grantPici;

    /** 拨款日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "拨款日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date grantTime;


    public String getProjectBianhao() {
        return projectBianhao;
    }

    public void setProjectBianhao(String projectBianhao) {
        this.projectBianhao = projectBianhao;
    }

    public String getProjectLeader() {
        return projectLeader;
    }

    public void setProjectLeader(String projectLeader) {
        this.projectLeader = projectLeader;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public BigDecimal getJixiaoMoney() {
        return jixiaoMoney;
    }

    public void setJixiaoMoney(BigDecimal jixiaoMoney) {
        this.jixiaoMoney = jixiaoMoney;
    }

    public Long getGrantPici() {
        return grantPici;
    }

    public void setGrantPici(Long grantPici) {
        this.grantPici = grantPici;
    }

    public Date getGrantTime() {
        return grantTime;
    }

    public void setGrantTime(Date grantTime) {
        this.grantTime = grantTime;
    }
}
