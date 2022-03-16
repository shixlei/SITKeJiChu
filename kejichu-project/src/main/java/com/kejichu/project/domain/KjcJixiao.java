package com.kejichu.project.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kejichu.common.annotation.Excel;
import com.kejichu.common.core.domain.BaseEntity;

/**
 * 绩效记录对象 kjc_jixiao
 * 
 * @author sxl
 * @date 2021-10-09
 */
public class KjcJixiao extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long jixiaoId;

    /** 项目编号 */
    @Excel(name = "项目编号")
    private String projectBianhao;

    /** 绩效总金额 */
    @Excel(name = "绩效总金额")
    private BigDecimal jixiaoMoney;

    /** 立项绩效发放金额 */
    @Excel(name = "立项绩效发放金额")
    private BigDecimal jixiaoLixiangMoney;

    /** 立项绩效发放时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "立项绩效发放时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date jixiaoLixiangDate;

    /** 结题绩效发放金额 */
    @Excel(name = "结题绩效发放金额")
    private BigDecimal jixiaoJietiMoney;

    /** 结题绩效发放时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结题绩效发放时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date jixiaoJietiDate;

    /** 绩效未发放金额 */
    @Excel(name = "绩效未发放金额")
    private BigDecimal jixiaoWeifafang;

    public void setJixiaoId(Long jixiaoId) 
    {
        this.jixiaoId = jixiaoId;
    }

    public Long getJixiaoId() 
    {
        return jixiaoId;
    }
    public void setProjectBianhao(String projectBianhao) 
    {
        this.projectBianhao = projectBianhao;
    }

    public String getProjectBianhao() 
    {
        return projectBianhao;
    }
    public void setJixiaoMoney(BigDecimal jixiaoMoney) 
    {
        this.jixiaoMoney = jixiaoMoney;
    }

    public BigDecimal getJixiaoMoney() 
    {
        return jixiaoMoney;
    }
    public void setJixiaoLixiangMoney(BigDecimal jixiaoLixiangMoney) 
    {
        this.jixiaoLixiangMoney = jixiaoLixiangMoney;
    }

    public BigDecimal getJixiaoLixiangMoney() 
    {
        return jixiaoLixiangMoney;
    }
    public void setJixiaoLixiangDate(Date jixiaoLixiangDate) 
    {
        this.jixiaoLixiangDate = jixiaoLixiangDate;
    }

    public Date getJixiaoLixiangDate() 
    {
        return jixiaoLixiangDate;
    }
    public void setJixiaoJietiMoney(BigDecimal jixiaoJietiMoney) 
    {
        this.jixiaoJietiMoney = jixiaoJietiMoney;
    }

    public BigDecimal getJixiaoJietiMoney() 
    {
        return jixiaoJietiMoney;
    }
    public void setJixiaoJietiDate(Date jixiaoJietiDate) 
    {
        this.jixiaoJietiDate = jixiaoJietiDate;
    }

    public Date getJixiaoJietiDate() 
    {
        return jixiaoJietiDate;
    }
    public void setJixiaoWeifafang(BigDecimal jixiaoWeifafang) 
    {
        this.jixiaoWeifafang = jixiaoWeifafang;
    }

    public BigDecimal getJixiaoWeifafang() 
    {
        return jixiaoWeifafang;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("jixiaoId", getJixiaoId())
            .append("projectBianhao", getProjectBianhao())
            .append("jixiaoMoney", getJixiaoMoney())
            .append("jixiaoLixiangMoney", getJixiaoLixiangMoney())
            .append("jixiaoLixiangDate", getJixiaoLixiangDate())
            .append("jixiaoJietiMoney", getJixiaoJietiMoney())
            .append("jixiaoJietiDate", getJixiaoJietiDate())
            .append("jixiaoWeifafang", getJixiaoWeifafang())
            .toString();
    }
}
