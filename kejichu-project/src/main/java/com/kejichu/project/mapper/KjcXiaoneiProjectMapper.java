package com.kejichu.project.mapper;

import java.util.List;
import com.kejichu.project.domain.KjcXiaoneiProject;

/**
 * 校内项目Mapper接口
 * 
 * @author tcl
 * @date 2022-05-26
 */
public interface KjcXiaoneiProjectMapper 
{
    /**
     * 查询校内项目
     * 
     * @param xnProjectId 校内项目主键
     * @return 校内项目
     */
    public KjcXiaoneiProject selectKjcXiaoneiProjectByXnProjectId(Long xnProjectId);

    /**
     * 查询校内项目列表
     * 
     * @param kjcXiaoneiProject 校内项目
     * @return 校内项目集合
     */
    public List<KjcXiaoneiProject> selectKjcXiaoneiProjectList(KjcXiaoneiProject kjcXiaoneiProject);

    /**
     * 新增校内项目
     * 
     * @param kjcXiaoneiProject 校内项目
     * @return 结果
     */
    public int insertKjcXiaoneiProject(KjcXiaoneiProject kjcXiaoneiProject);

    /**
     * 修改校内项目
     * 
     * @param kjcXiaoneiProject 校内项目
     * @return 结果
     */
    public int updateKjcXiaoneiProject(KjcXiaoneiProject kjcXiaoneiProject);

    /**
     * 删除校内项目
     * 
     * @param xnProjectId 校内项目主键
     * @return 结果
     */
    public int deleteKjcXiaoneiProjectByXnProjectId(Long xnProjectId);

    /**
     * 批量删除校内项目
     * 
     * @param xnProjectIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteKjcXiaoneiProjectByXnProjectIds(String[] xnProjectIds);
}
