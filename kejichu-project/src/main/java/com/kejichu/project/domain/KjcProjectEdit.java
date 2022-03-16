package com.kejichu.project.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kejichu.common.annotation.Excel;
import com.kejichu.common.core.domain.BaseEntity;

/**
 * 项目修改记录对象 kjc_project_edit
 * 
 * @author sxl
 * @date 2021-08-28
 */
public class KjcProjectEdit extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号记录 */
    private Long projectEditId;

    /** 被修改项目编号 */
    @Excel(name = "被修改项目编号")
    private String projectBianhao;

    /** 修改人 */
    @Excel(name = "修改人")
    private String editName;

    /** 修改日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date editTime;

    public void setProjectEditId(Long projectEditId) 
    {
        this.projectEditId = projectEditId;
    }

    public Long getProjectEditId() 
    {
        return projectEditId;
    }
    public void setProjectBianhao(String projectBianhao) 
    {
        this.projectBianhao = projectBianhao;
    }

    public String getProjectBianhao() 
    {
        return projectBianhao;
    }
    public void setEditName(String editName) 
    {
        this.editName = editName;
    }

    public String getEditName() 
    {
        return editName;
    }
    public void setEditTime(Date editTime) 
    {
        this.editTime = editTime;
    }

    public Date getEditTime() 
    {
        return editTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("projectEditId", getProjectEditId())
            .append("projectBianhao", getProjectBianhao())
            .append("editName", getEditName())
            .append("editTime", getEditTime())
            .toString();
    }
}
