package com.kejichu.project.mapper;

import java.util.List;
import com.kejichu.project.domain.KjcProjectEdit;

/**
 * 项目修改记录Mapper接口
 * 
 * @author sxl
 * @date 2021-08-28
 */
public interface KjcProjectEditMapper 
{
    /**
     * 查询项目修改记录
     * 
     * @param projectEditId 项目修改记录主键
     * @return 项目修改记录
     */
    public KjcProjectEdit selectKjcProjectEditByProjectEditId(Long projectEditId);

    /**
     * 查询项目修改记录列表
     * 
     * @param kjcProjectEdit 项目修改记录
     * @return 项目修改记录集合
     */
    public List<KjcProjectEdit> selectKjcProjectEditList(KjcProjectEdit kjcProjectEdit);

    /**
     * 新增项目修改记录
     * 
     * @param kjcProjectEdit 项目修改记录
     * @return 结果
     */
    public int insertKjcProjectEdit(KjcProjectEdit kjcProjectEdit);

    /**
     * 修改项目修改记录
     * 
     * @param kjcProjectEdit 项目修改记录
     * @return 结果
     */
    public int updateKjcProjectEdit(KjcProjectEdit kjcProjectEdit);

    /**
     * 删除项目修改记录
     * 
     * @param projectEditId 项目修改记录主键
     * @return 结果
     */
    public int deleteKjcProjectEditByProjectEditId(Long projectEditId);

    /**
     * 批量删除项目修改记录
     * 
     * @param projectEditIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteKjcProjectEditByProjectEditIds(String[] projectEditIds);
}
