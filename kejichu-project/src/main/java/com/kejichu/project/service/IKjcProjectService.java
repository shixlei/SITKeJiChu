package com.kejichu.project.service;

import java.util.List;

import com.kejichu.project.domain.KjcImportEntity;
import com.kejichu.project.domain.KjcProject;

/**
 * 项目信息Service接口
 * 
 * @author sxl
 * @date 2021-08-28
 */
public interface IKjcProjectService 
{
    /**
     * 查询项目信息
     * 
     * @param projectId 项目信息主键
     * @return 项目信息
     */
    public KjcProject selectKjcProjectByProjectId(Long projectId);



    public KjcProject selectKjcProjectByprojectBianhao(String projectBianhao);

    /**
     * 查询项目信息列表
     * 
     * @param kjcProject 项目信息
     * @return 项目信息集合
     */
   // public List<KjcProject> selectKjcProjectList(KjcProject kjcProject);

    /**
     * 查询项目信息列表
     *
     * @param kjcProject 项目信息
     * @return 项目信息集合
     */
    public List<KjcProject> selectKjcProjectList(KjcProject kjcProject);

    /**
     * 新增项目信息
     * 
     * @param kjcProject 项目信息
     * @return 结果
     */
    public int insertKjcProject(KjcProject kjcProject);

    /**
     * 修改项目信息
     * 
     * @param kjcProject 项目信息
     * @return 结果
     */
    public int updateKjcProject(KjcProject kjcProject);
    /**
     * 导入项目信息
     *
     * @param  projectList 用户数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @return 结果
     */
    public String importProject(List<KjcProject> projectList, Boolean isUpdateSupport , String kjcuser);

   // String importProject(List<KjcImportEntity> projectList);

    /**
     * 批量删除项目信息
     * 
     * @param projectIds 需要删除的项目信息主键集合
     * @return 结果
     */
    public int deleteKjcProjectByProjectIds(String projectIds);

    /**
     * 删除项目信息信息
     * 
     * @param projectId 项目信息主键
     * @return 结果
     */
    public int deleteKjcProjectByProjectId(Long projectId);
}
