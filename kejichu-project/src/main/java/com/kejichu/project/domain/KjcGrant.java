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

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

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

    /** 负责人姓名 */
    @Excel(name = "负责人姓名")
    private String grantManager;

    /** 学院 */
    @Excel(name = "学院",readConverterExp =
            "1=计算机科学与信息工程学院,2=化工与环境工程学院,3=材料科学与工程学院," +
                    "4=城市建设与安全工程学院,5=机械工程学院,6=电气与电子工程学院," +
                    "7=经济与管理学院,8=人文学院,9=艺术与设计学院,10=生态技术与工程学院," +
                    "11=外国语学院,12=理学院,13=香料香精化妆品学部（香料香精技术与工程学院）," +
                    "14=轨道交通学院,15=体育教育部,16=工程创新学院,17=高等职业学院,18=继续教育学院，" +
                    "19=马克思主义学院,20=国际教育中心,21=香料香精化妆品学部（国际化妆品学院）," +
                    "22=香料香精化妆品学部（东方美谷研究院）,23=香料香精化妆品省部共建协同创新中心")
    private String grantAcademy;

    /** 备注 */
    @Excel(name = "备注")
    private String grantRemark;

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

    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }

    public String getProjectName()
    {
        return projectName;
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
    public void setGrantManager(String grantManager) { this.grantManager = grantManager; }
    public String getGrantManager() { return grantManager; }
    public void setGrantAcademy(String grantAcademy)
    {
        this.grantAcademy = grantAcademy;
    }

    public String getGrantAcademy()
    {
        return grantAcademy;
    }
    public void setGrantRemark(String grantRemark)
    {
        this.grantRemark = grantRemark;
    }

    public String getGrantRemark()
    {
        return grantRemark;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("grantId", getGrantId())
            .append("projectBianhao", getProjectBianhao())
            .append("projectName", getProjectName())
            .append("grantPici", getGrantPici())
            .append("grantTime", getGrantTime())
            .append("grantMoney", getGrantMoney())
            .append("jixiao", getJixiao())
            .append("guanlifei", getGuanlifei())
            .append("grantLaiyuan", getGrantLaiyuan())
            .append("grantManager", getGrantManager())
            .append("grantAcademy", getGrantAcademy())
            .append("grantRemark", getGrantRemark())
            .toString();
    }
}
