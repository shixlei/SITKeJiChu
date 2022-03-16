package com.kejichu.project.service;

import java.util.List;
import com.kejichu.project.domain.KjcProjectFile;

/**
 * 项目文件Service接口
 * 
 * @author tcl
 * @date 2021-12-16
 */
public interface IKjcProjectFileService 
{
    /**
     * 查询项目文件
     * 
     * @param fileId 项目文件主键
     * @return 项目文件
     */
    public KjcProjectFile selectKjcProjectFileByFileId(Long fileId);

    /**
     * 查询项目文件列表
     * 
     * @param kjcProjectFile 项目文件
     * @return 项目文件集合
     */
    public List<KjcProjectFile> selectKjcProjectFileList(KjcProjectFile kjcProjectFile);

    /**
     * 新增项目文件
     * 
     * @param kjcProjectFile 项目文件
     * @return 结果
     */
    public int insertKjcProjectFile(KjcProjectFile kjcProjectFile);

    /**
     * 修改项目文件
     * 
     * @param kjcProjectFile 项目文件
     * @return 结果
     */
    public int updateKjcProjectFile(KjcProjectFile kjcProjectFile);

    /**
     * 批量删除项目文件
     * 
     * @param fileIds 需要删除的项目文件主键集合
     * @return 结果
     */
    public int deleteKjcProjectFileByFileIds(String fileIds);

    /**
     * 删除项目文件信息
     * 
     * @param fileId 项目文件主键
     * @return 结果
     */
    public int deleteKjcProjectFileByFileId(Long fileId);
}
