package com.kejichu.project.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kejichu.project.mapper.KjcProjectEditMapper;
import com.kejichu.project.domain.KjcProjectEdit;
import com.kejichu.project.service.IKjcProjectEditService;
import com.kejichu.common.core.text.Convert;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 项目修改记录Service业务层处理
 * 
 * @author sxl
 * @date 2021-08-28
 */
@RestControllerAdvice
@ControllerAdvice
@Service
public class KjcProjectEditServiceImpl implements IKjcProjectEditService 
{
    @Autowired
    private KjcProjectEditMapper kjcProjectEditMapper;

    /**
     * 查询项目修改记录
     * 
     * @param projectEditId 项目修改记录主键
     * @return 项目修改记录
     */
    @Override
    public KjcProjectEdit selectKjcProjectEditByProjectEditId(Long projectEditId)
    {
        return kjcProjectEditMapper.selectKjcProjectEditByProjectEditId(projectEditId);
    }

    /**
     * 查询项目修改记录列表
     * 
     * @param kjcProjectEdit 项目修改记录
     * @return 项目修改记录
     */
    @Override
    public List<KjcProjectEdit> selectKjcProjectEditList(KjcProjectEdit kjcProjectEdit)
    {
        return kjcProjectEditMapper.selectKjcProjectEditList(kjcProjectEdit);
    }

    /**
     * 新增项目修改记录
     * 
     * @param kjcProjectEdit 项目修改记录
     * @return 结果
     */
    @Override
    public int insertKjcProjectEdit(KjcProjectEdit kjcProjectEdit)
    {
        return kjcProjectEditMapper.insertKjcProjectEdit(kjcProjectEdit);
    }

    /**
     * 修改项目修改记录
     * 
     * @param kjcProjectEdit 项目修改记录
     * @return 结果
     */
    @Override
    public int updateKjcProjectEdit(KjcProjectEdit kjcProjectEdit)
    {
        return kjcProjectEditMapper.updateKjcProjectEdit(kjcProjectEdit);
    }

    /**
     * 批量删除项目修改记录
     * 
     * @param projectEditIds 需要删除的项目修改记录主键
     * @return 结果
     */
    @Override
    public int deleteKjcProjectEditByProjectEditIds(String projectEditIds)
    {
        return kjcProjectEditMapper.deleteKjcProjectEditByProjectEditIds(Convert.toStrArray(projectEditIds));
    }

    /**
     * 删除项目修改记录信息
     * 
     * @param projectEditId 项目修改记录主键
     * @return 结果
     */
    @Override
    public int deleteKjcProjectEditByProjectEditId(Long projectEditId)
    {
        return kjcProjectEditMapper.deleteKjcProjectEditByProjectEditId(projectEditId);
    }
}
