package com.kejichu.project.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kejichu.project.mapper.KjcXiaoneiProjectMapper;
import com.kejichu.project.domain.KjcXiaoneiProject;
import com.kejichu.project.service.IKjcXiaoneiProjectService;
import com.kejichu.common.core.text.Convert;

/**
 * 校内项目Service业务层处理
 * 
 * @author tcl
 * @date 2022-05-26
 */
@Service
public class KjcXiaoneiProjectServiceImpl implements IKjcXiaoneiProjectService 
{
    @Autowired
    private KjcXiaoneiProjectMapper kjcXiaoneiProjectMapper;

    /**
     * 查询校内项目
     * 
     * @param xnProjectId 校内项目主键
     * @return 校内项目
     */
    @Override
    public KjcXiaoneiProject selectKjcXiaoneiProjectByXnProjectId(Long xnProjectId)
    {
        return kjcXiaoneiProjectMapper.selectKjcXiaoneiProjectByXnProjectId(xnProjectId);
    }

    /**
     * 查询校内项目列表
     * 
     * @param kjcXiaoneiProject 校内项目
     * @return 校内项目
     */
    @Override
    public List<KjcXiaoneiProject> selectKjcXiaoneiProjectList(KjcXiaoneiProject kjcXiaoneiProject)
    {
        return kjcXiaoneiProjectMapper.selectKjcXiaoneiProjectList(kjcXiaoneiProject);
    }

    /**
     * 新增校内项目
     * 
     * @param kjcXiaoneiProject 校内项目
     * @return 结果
     */
    @Override
    public int insertKjcXiaoneiProject(KjcXiaoneiProject kjcXiaoneiProject)
    {
        return kjcXiaoneiProjectMapper.insertKjcXiaoneiProject(kjcXiaoneiProject);
    }

    /**
     * 修改校内项目
     * 
     * @param kjcXiaoneiProject 校内项目
     * @return 结果
     */
    @Override
    public int updateKjcXiaoneiProject(KjcXiaoneiProject kjcXiaoneiProject)
    {
        return kjcXiaoneiProjectMapper.updateKjcXiaoneiProject(kjcXiaoneiProject);
    }

    /**
     * 批量删除校内项目
     * 
     * @param xnProjectIds 需要删除的校内项目主键
     * @return 结果
     */
    @Override
    public int deleteKjcXiaoneiProjectByXnProjectIds(String xnProjectIds)
    {
        return kjcXiaoneiProjectMapper.deleteKjcXiaoneiProjectByXnProjectIds(Convert.toStrArray(xnProjectIds));
    }

    /**
     * 删除校内项目信息
     * 
     * @param xnProjectId 校内项目主键
     * @return 结果
     */
    @Override
    public int deleteKjcXiaoneiProjectByXnProjectId(Long xnProjectId)
    {
        return kjcXiaoneiProjectMapper.deleteKjcXiaoneiProjectByXnProjectId(xnProjectId);
    }
}
