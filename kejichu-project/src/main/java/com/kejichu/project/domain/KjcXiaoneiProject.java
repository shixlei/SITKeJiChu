package com.kejichu.project.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kejichu.common.annotation.Excel;
import com.kejichu.common.core.domain.BaseEntity;

/**
 * 校内项目对象 kjc_xiaonei_project
 * 
 * @author tcl
 * @date 2022-05-26
 */
public class KjcXiaoneiProject extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 校内项目id */
    private Long xnProjectId;

    /** 项目编号 */
    @Excel(name = "项目编号")
    private String xnProjectBianhao;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String xnProjectName;

    /** 项目负责人 */
    @Excel(name = "项目负责人")
    private String xnProjectLeader;

    /** 年份 */
    @Excel(name = "年份")
    private String xnProjectYear;

    /** 学院 */
    @Excel(name = "学院", readConverterExp =
            "1=计算机科学与信息工程学院,2=化工与环境工程学院,3=材料科学与工程学院," +
                    "4=城市建设与安全工程学院,5=机械工程学院,6=电气与电子工程学院," +
                    "7=经济与管理学院,8=人文学院,9=艺术与设计学院,10=生态技术与工程学院," +
                    "11=外国语学院,12=理学院,13=香料香精化妆品学部（香料香精技术与工程学院）," +
                    "14=轨道交通学院,15=体育教育部,16=工程创新学院,17=高等职业学院,18=继续教育学院，" +
                    "19=马克思主义学院,20=国际教育中心,21=香料香精化妆品学部（国际化妆品学院）," +
                    "22=香料香精化妆品学部（东方美谷研究院）,23=香料香精化妆品省部共建协同创新中心")
    private String xnSchool;

    /** 批准经费 */
    @Excel(name = "批准经费")
    private Double xnProjectGrant;

    /** 项目状态 */
    @Excel(name = "项目状态",readConverterExp = "0=立项,1=在研,2=结题 ,3=终止 ,4=延期 " )
    private String xnProjectStatus;

    /** 开始日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date xnStartDate;

    /** 结束 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束", width = 30, dateFormat = "yyyy-MM-dd")
    private Date xnEndDate;

    /** 项目类别 */
    @Excel(name = "项目类别",readConverterExp = "1=引进人才科研启动项目 ,2=中青年教师科技人才发展基金 ,3=科技成果报奖培育基金 ,4=科技发展基金 " )
    private String xnProjectType;

    /** 预算 */
    @Excel(name = "预算")
    private Double xnBudget;

    public void setXnProjectId(Long xnProjectId) 
    {
        this.xnProjectId = xnProjectId;
    }

    public Long getXnProjectId() 
    {
        return xnProjectId;
    }
    public void setXnProjectBianhao(String xnProjectBianhao) 
    {
        this.xnProjectBianhao = xnProjectBianhao;
    }

    public String getXnProjectBianhao() 
    {
        return xnProjectBianhao;
    }
    public void setXnProjectName(String xnProjectName) 
    {
        this.xnProjectName = xnProjectName;
    }

    public String getXnProjectName() 
    {
        return xnProjectName;
    }
    public void setXnProjectLeader(String xnProjectLeader) 
    {
        this.xnProjectLeader = xnProjectLeader;
    }

    public String getXnProjectLeader() 
    {
        return xnProjectLeader;
    }
    public void setXnProjectYear(String xnProjectYear) 
    {
        this.xnProjectYear = xnProjectYear;
    }

    public String getXnProjectYear() 
    {
        return xnProjectYear;
    }
    public void setXnSchool(String xnSchool) 
    {
        this.xnSchool = xnSchool;
    }

    public String getXnSchool() 
    {
        return xnSchool;
    }
    public void setXnProjectGrant(Double xnProjectGrant) 
    {
        this.xnProjectGrant = xnProjectGrant;
    }

    public Double getXnProjectGrant() 
    {
        return xnProjectGrant;
    }
    public void setXnProjectStatus(String xnProjectStatus) 
    {
        this.xnProjectStatus = xnProjectStatus;
    }

    public String getXnProjectStatus() 
    {
        return xnProjectStatus;
    }
    public void setXnStartDate(Date xnStartDate) 
    {
        this.xnStartDate = xnStartDate;
    }

    public Date getXnStartDate() 
    {
        return xnStartDate;
    }
    public void setXnEndDate(Date xnEndDate) 
    {
        this.xnEndDate = xnEndDate;
    }

    public Date getXnEndDate() 
    {
        return xnEndDate;
    }
    public void setXnProjectType(String xnProjectType) 
    {
        this.xnProjectType = xnProjectType;
    }

    public String getXnProjectType() 
    {
        return xnProjectType;
    }
    public void setXnBudget(Double xnBudget) 
    {
        this.xnBudget = xnBudget;
    }

    public Double getXnBudget() 
    {
        return xnBudget;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("xnProjectId", getXnProjectId())
            .append("xnProjectBianhao", getXnProjectBianhao())
            .append("xnProjectName", getXnProjectName())
            .append("xnProjectLeader", getXnProjectLeader())
            .append("xnProjectYear", getXnProjectYear())
            .append("xnSchool", getXnSchool())
            .append("xnProjectGrant", getXnProjectGrant())
            .append("xnProjectStatus", getXnProjectStatus())
            .append("xnStartDate", getXnStartDate())
            .append("xnEndDate", getXnEndDate())
            .append("xnProjectType", getXnProjectType())
            .append("xnBudget", getXnBudget())
            .toString();
    }
}
