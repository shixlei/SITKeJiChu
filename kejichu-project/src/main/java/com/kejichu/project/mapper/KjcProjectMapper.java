package com.kejichu.project.mapper;

import java.util.List;

import com.kejichu.project.domain.KjcImportEntity;
import com.kejichu.project.domain.KjcProject;

/**
 * 项目信息Mapper接口
 * 
 * @author sxl
 * @date 2021-08-28
 */
public interface KjcProjectMapper 
{
    /**
     * 查询项目信息
     * 
     * @param projectId 项目信息主键
     * @return 项目信息
     */
    public KjcProject selectKjcProjectByProjectId(Long projectId);


    /**
     * 查询项目编号
     * @param
     * @return 项目编号
     */

    public  KjcProject selectKjcProjectByprojectBianhao(String projectBianhao);


    /**
     * 查询项目信息列表
     * 
     * @param kjcProject 项目信息
     * @return 项目信息集合
     */
    public List<KjcProject> selectKjcProjectList2(KjcProject kjcProject);

    public List<KjcImportEntity> selectKjcProjectList(KjcProject kjcProject);

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
     * 删除项目信息
     * 
     * @param projectId 项目信息主键
     * @return 结果
     */
    public int deleteKjcProjectByProjectId(Long projectId);

    /**
     * 批量删除项目信息
     * 
     * @param projectIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteKjcProjectByProjectIds(String[] projectIds);
}
