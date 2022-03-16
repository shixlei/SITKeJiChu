package com.kejichu.project.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.kejichu.common.annotation.Excel;
import com.kejichu.common.core.domain.BaseEntity;

/**
 * 项目文件对象 kjc_project_file
 * 
 * @author tcl
 * @date 2021-12-16
 */
public class KjcProjectFile extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 文件id */
    private Long fileId;

    /** 项目编号 */
    @Excel(name = "项目编号")
    private String projectBianhao;

    /** 文件类型 */
    @Excel(name = "文件类型")
    private String fileType;

    /** 文件路径 */
    @Excel(name = "文件路径")
    private String filePath;

    /** 项目文件名 */
    @Excel(name = "项目文件名")
    private String fileName;

    /** 上传用户 */
    @Excel(name = "上传用户")
    private String uploaduser;

    /** 上传时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上传时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date uploadtime;

    public void setFileId(Long fileId) 
    {
        this.fileId = fileId;
    }

    public Long getFileId() 
    {
        return fileId;
    }
    public void setProjectBianhao(String projectBianhao) 
    {
        this.projectBianhao = projectBianhao;
    }

    public String getProjectBianhao() 
    {
        return projectBianhao;
    }
    public void setFileType(String fileType) 
    {
        this.fileType = fileType;
    }

    public String getFileType() 
    {
        return fileType;
    }
    public void setFilePath(String filePath) 
    {
        this.filePath = filePath;
    }

    public String getFilePath() 
    {
        return filePath;
    }
    public void setFileName(String fileName) 
    {
        this.fileName = fileName;
    }

    public String getFileName() 
    {
        return fileName;
    }
    public void setUploaduser(String uploaduser) 
    {
        this.uploaduser = uploaduser;
    }

    public String getUploaduser() 
    {
        return uploaduser;
    }
    public void setUploadtime(Date uploadtime) 
    {
        this.uploadtime = uploadtime;
    }

    public Date getUploadtime() 
    {
        return uploadtime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("fileId", getFileId())
            .append("projectBianhao", getProjectBianhao())
            .append("fileType", getFileType())
            .append("filePath", getFilePath())
            .append("fileName", getFileName())
            .append("uploaduser", getUploaduser())
            .append("uploadtime", getUploadtime())
            .toString();
    }
}
