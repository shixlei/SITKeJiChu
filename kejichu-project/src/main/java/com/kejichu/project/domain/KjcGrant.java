package com.kejichu.project.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kejichu.common.annotation.Excel;
import com.kejichu.common.core.domain.BaseEntity;


/**
 * 拨款记录对象 kjc_grant
 * 
 * @author sxl
 * @date 2021-10-09
 */
public class KjcGrant extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long grantId;

    /** 项目编号 */
    @Excel(name = "项目编号")
    private String projectBianhao;

    /** 拨款批次 */
    @Excel(name = "拨款批次")
    private Long grantPici;

    /** 拨款日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "拨款日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date grantTime;

    /** 本期拨款金额 */
    @Excel(name = "本期拨款金额")
    private BigDecimal grantMoney;

    /** 绩效 */
    @Excel(name = "绩效")
    private BigDecimal jixiao;

    /** 管理费 */
    @Excel(name = "管理费")
    private BigDecimal guanlifei;

    /** 款项来源 */
    @Excel(name = "款项来源")
    private String grantLaiyuan;

    public void setGrantId(Long grantId) 
    {
        this.grantId = grantId;
    }

    public Long getGrantId() 
    {
        return grantId;
    }
    public void setProjectBianhao(String projectBianhao) 
    {
        this.projectBianhao = projectBianhao;
    }

    public String getProjectBianhao() 
    {
        return projectBianhao;
    }
    public void setGrantPici(Long grantPici) 
    {
        this.grantPici = grantPici;
    }

    public Long getGrantPici() 
    {
        return grantPici;
    }
    public void setGrantTime(Date grantTime) 
    {
        this.grantTime = grantTime;
    }

    public Date getGrantTime() 
    {
        return grantTime;
    }
    public void setGrantMoney(BigDecimal grantMoney) 
    {
        this.grantMoney = grantMoney;
    }

    public BigDecimal getGrantMoney() 
    {
        return grantMoney;
    }
    public void setJixiao(BigDecimal jixiao) 
    {
        this.jixiao = jixiao;
    }

    public BigDecimal getJixiao() 
    {
        return jixiao;
    }
    public void setGuanlifei(BigDecimal guanlifei) 
    {
        this.guanlifei = guanlifei;
    }

    public BigDecimal getGuanlifei() 
    {
        return guanlifei;
    }
    public void setGrantLaiyuan(String grantLaiyuan) 
    {
        this.grantLaiyuan = grantLaiyuan;
    }

    public String getGrantLaiyuan() 
    {
        return grantLaiyuan;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("grantId", getGrantId())
            .append("projectBianhao", getProjectBianhao())
            .append("grantPici", getGrantPici())
            .append("grantTime", getGrantTime())
            .append("grantMoney", getGrantMoney())
            .append("jixiao", getJixiao())
            .append("guanlifei", getGuanlifei())
            .append("grantLaiyuan", getGrantLaiyuan())
            .toString();
    }
}
