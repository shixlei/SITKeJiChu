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

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 绩效总金额 */
    @Excel(name = "绩效总金额")
    private BigDecimal projectPerformance;

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

    /** 学院 */
    @Excel(name = "学院",readConverterExp =
            "1=计算机科学与信息工程学院,2=化工与环境工程学院,3=材料科学与工程学院," +
                    "4=城市建设与安全工程学院,5=机械工程学院,6=电气与电子工程学院," +
                    "7=经济与管理学院,8=人文学院,9=艺术与设计学院,10=生态技术与工程学院," +
                    "11=外国语学院,12=理学院,13=香料香精化妆品学部（香料香精技术与工程学院）," +
                    "14=轨道交通学院,15=体育教育部,16=工程创新学院,17=高等职业学院,18=继续教育学院，" +
                    "19=马克思主义学院,20=国际教育中心,21=香料香精化妆品学部（国际化妆品学院）," +
                    "22=香料香精化妆品学部（东方美谷研究院）,23=香料香精化妆品省部共建协同创新中心")
    private String deptName;

    /** 负责人 */
    @Excel(name = "负责人")
    private String projectLeader;

    /** 备注 */
    @Excel(name = "备注")
    private String jixiaoRemark;

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
    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }

    public String getProjectName()
    {
        return projectName;
    }
    public void setProjectPerformance(BigDecimal projectPerformance)
    {
        this.projectPerformance = projectPerformance;
    }

    public BigDecimal getProjectPerformance()
    {
        return projectPerformance;
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
    public void setDeptName(String deptName)
    {
        this.deptName = deptName;
    }

    public String getDeptName()
    {
        return deptName;
    }

    public void setProjectLeader(String projectLeader)
    {
        this.projectLeader = projectLeader;
    }
    public String getProjectLeader()
    {
        return projectLeader;
    }

    public void setJixiaoRemark(String jixiaoRemark)
    {
        this.jixiaoRemark = jixiaoRemark;
    }
    public String getJixiaoRemark() { return jixiaoRemark; }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("jixiaoId", getJixiaoId())
            .append("projectBianhao", getProjectBianhao())
            .append("projectName", getProjectName())
            .append("projectPerformance", getProjectPerformance())
            .append("jixiaoLixiangMoney", getJixiaoLixiangMoney())
            .append("jixiaoLixiangDate", getJixiaoLixiangDate())
            .append("jixiaoJietiMoney", getJixiaoJietiMoney())
            .append("jixiaoJietiDate", getJixiaoJietiDate())
            .append("jixiaoWeifafang", getJixiaoWeifafang())
            .append("deptName", getDeptName())
            .append("projectLeader", getProjectLeader())
            .append("jixiaoRemark", getJixiaoRemark())
            .toString();
    }
}
