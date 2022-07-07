package com.kejichu.project.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kejichu.common.annotation.Excel;
import com.kejichu.common.core.domain.BaseEntity;

/**
 * 项目信息对象 kjc_project
 * @author sxl
 * @date 2021-08-28
 */
public class KjcProject extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 项目id */
    private Long projectId;

    /** 项目编号 */
    @Excel(name = "项目编号")
    private String projectBianhao;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 负责人名字 */
    @Excel(name = "负责人名字")
    private String projectLeader;


    /** 所属学院 */
    @Excel(name = "所属学院", readConverterExp =
            "1=计算机科学与信息工程学院,2=化工与环境工程学院,3=材料科学与工程学院," +
            "4=城市建设与安全工程学院,5=机械工程学院,6=电气与电子工程学院," +
            "7=经济与管理学院,8=人文学院,9=艺术与设计学院,10=生态技术与工程学院," +
            "11=外国语学院,12=理学院,13=香料香精化妆品学部（香料香精技术与工程学院）," +
            "14=轨道交通学院,15=体育教育部,16=工程创新学院,17=高等职业学院,18=继续教育学院，" +
            "19=马克思主义学院,20=国际教育中心,21=香料香精化妆品学部（国际化妆品学院）," +
                    "22=香料香精化妆品学部（东方美谷研究院）,23=香料香精化妆品省部共建协同创新中心")
    private String deptName;

    /** 批准经费 */
    @Excel(name = "批准经费")
    private BigDecimal projectGrant;

    /** 实际在校经费 */
    @Excel(name = "实际在校经费")
    private BigDecimal schoolRealBudget;

    /** 项目状态 */
    @Excel(name = "项目状态",readConverterExp = "0=立项,1=在研,2=结题 ,3=终止 ,4=延期 " )
    private String projectStatus;

    /** 年份 */
    @Excel(name = "年份")
    private String projectYear;

    /** 绩效 */
    @Excel(name = "绩效")
    private BigDecimal projectPerformance;

    /** 开始日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startData;

    /** 结束日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endData;

    /** 项目类型 */
    @Excel(name = "项目类型")
    private String projectType;

    /** 下达单位 */
    @Excel(name = "下达单位")
    private String xiadadanwei;

    /** 外拨金额 */
    @Excel(name = "外拨金额")
    private BigDecimal waibo;

    /** 合作方式 */
    @Excel(name = "合作方式",readConverterExp ="0=校外转入,1=合作申报,2=其他,3=无")
    private String hezuofangshi;

    /** 项目级别 */
    @Excel(name = "项目级别",readConverterExp = "0=国家级,1=国家级转入,2=国家级合作,3=省部级," +
            "4=省部级转入,5=一般项目")
    private String level;

    /** 备注 */
    @Excel(name = "备注")
    private String projectRemark;


    public void setProjectId(Long projectId) 
    {
        this.projectId = projectId;
    }
    public Long getProjectId()
    {
        return projectId;
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

    public void setProjectLeader(String projectLeader)
    {
        this.projectLeader = projectLeader;
    }
    public String getProjectLeader()
    {
        return projectLeader;
    }


    public void setDeptName(String deptName)
    {
        this.deptName = deptName;
    }
    public String getDeptName() 
    {
        return deptName;
    }

    public void setProjectGrant(BigDecimal projectGrant)
    {
        this.projectGrant = projectGrant;
    }
    public BigDecimal getProjectGrant()
    {
        return projectGrant;
    }

    public void setSchoolRealBudget(BigDecimal schoolRealBudget)
    {
        this.schoolRealBudget = schoolRealBudget;
    }

    public BigDecimal getSchoolRealBudget()
    {
        return schoolRealBudget;
    }

    public void setProjectStatus(String projectStatus)
    {
        this.projectStatus = projectStatus;
    }
    public String getProjectStatus() 
    {
        return projectStatus;
    }
    public void setProjectYear(String projectYear)
    { this.projectYear = projectYear; }

    public String getProjectYear() { return projectYear; }

    public void setProjectPerformance(BigDecimal projectPerformance)
    {
        this.projectPerformance = projectPerformance;
    }

    public BigDecimal getProjectPerformance()
    {
        return projectPerformance;
    }
    public void setStartData(Date startData)
    {
        this.startData = startData;
    }
    public Date getStartData() 
    {
        return startData;
    }

    public void setEndData(Date endData)
    {
        this.endData = endData;
    }

    public Date getEndData() 
    {
        return endData;
    }
    public void setProjectType(String projectType) 
    {
        this.projectType = projectType;
    }

    public String getProjectType() 
    {
        return projectType;
    }
    public void setXiadadanwei(String xiadadanwei) 
    {
        this.xiadadanwei = xiadadanwei;
    }

    public String getXiadadanwei() 
    {
        return xiadadanwei;
    }
    public void setWaibo(BigDecimal waibo) 
    {
        this.waibo = waibo;
    }

    public BigDecimal getWaibo() 
    {
        return waibo;
    }
    public void setHezuofangshi(String hezuofangshi) 
    {
        this.hezuofangshi = hezuofangshi;
    }

    public String getHezuofangshi() 
    {
        return hezuofangshi;
    }
    public void setLevel(String level) 
    {
        this.level = level;
    }

    public String getLevel() 
    {
        return level;
    }

    public void setProjectRemark(String projectRemark)
    {
        this.projectRemark = projectRemark;
    }

    public String getProjectRemark()
    {
        return projectRemark;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("projectId", getProjectId())
            .append("projectBianhao", getProjectBianhao())
            .append("projectName", getProjectName())
            .append("projectLeader", getProjectLeader())
            .append("deptName", getDeptName())
            .append("projectGrant", getProjectGrant())
            .append("schoolRealBudget", getSchoolRealBudget())
            .append("projectStatus", getProjectStatus())
            .append("projectYear", getProjectYear())
            .append("projectPerformance", getProjectPerformance())
            .append("startData", getStartData())
            .append("endData", getEndData())
            .append("projectType", getProjectType())
            .append("xiadadanwei", getXiadadanwei())
            .append("waibo", getWaibo())
            .append("hezuofangshi", getHezuofangshi())
            .append("level", getLevel())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("projectRemark", getProjectRemark())
            .toString();
    }
}
