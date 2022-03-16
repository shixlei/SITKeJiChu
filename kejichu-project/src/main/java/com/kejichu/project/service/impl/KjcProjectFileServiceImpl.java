package com.kejichu.project.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kejichu.project.mapper.KjcProjectFileMapper;
import com.kejichu.project.domain.KjcProjectFile;
import com.kejichu.project.service.IKjcProjectFileService;
import com.kejichu.common.core.text.Convert;

/**
 * 项目文件Service业务层处理
 * 
 * @author tcl
 * @date 2021-12-16
 */
@Service
public class KjcProjectFileServiceImpl implements IKjcProjectFileService 
{
    @Autowired
    private KjcProjectFileMapper kjcProjectFileMapper;

    /**
     * 查询项目文件
     * 
     * @param fileId 项目文件主键
     * @return 项目文件
     */
    @Override
    public KjcProjectFile selectKjcProjectFileByFileId(Long fileId)
    {
        return kjcProjectFileMapper.selectKjcProjectFileByFileId(fileId);
    }

    /**
     * 查询项目文件列表
     * 
     * @param kjcProjectFile 项目文件
     * @return 项目文件
     */
    @Override
    public List<KjcProjectFile> selectKjcProjectFileList(KjcProjectFile kjcProjectFile)
    {
        return kjcProjectFileMapper.selectKjcProjectFileList(kjcProjectFile);
    }

    /**
     * 新增项目文件
     * 
     * @param kjcProjectFile 项目文件
     * @return 结果
     */
    @Override
    public int insertKjcProjectFile(KjcProjectFile kjcProjectFile)
    {
        return kjcProjectFileMapper.insertKjcProjectFile(kjcProjectFile);
    }

    /**
     * 修改项目文件
     * 
     * @param kjcProjectFile 项目文件
     * @return 结果
     */
    @Override
    public int updateKjcProjectFile(KjcProjectFile kjcProjectFile)
    {
        return kjcProjectFileMapper.updateKjcProjectFile(kjcProjectFile);
    }

    /**
     * 批量删除项目文件
     * 
     * @param fileIds 需要删除的项目文件主键
     * @return 结果
     */
    @Override
    public int deleteKjcProjectFileByFileIds(String fileIds)
    {
        return kjcProjectFileMapper.deleteKjcProjectFileByFileIds(Convert.toStrArray(fileIds));
    }

    /**
     * 删除项目文件信息
     * 
     * @param fileId 项目文件主键
     * @return 结果
     */
    @Override
    public int deleteKjcProjectFileByFileId(Long fileId)
    {
        return kjcProjectFileMapper.deleteKjcProjectFileByFileId(fileId);
    }
}
