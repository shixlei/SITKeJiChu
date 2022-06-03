package com.kejichu.project.service.impl;

import java.util.List;

import com.kejichu.common.exception.ServiceException;
import com.kejichu.common.utils.StringUtils;
import com.kejichu.project.domain.KjcGrant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger log = LoggerFactory.getLogger(KjcXiaoneiProjectServiceImpl.class);
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
     * 晓聂项目导入记录
     * @param xnProjectList
     * @return 导入结果
     */
    @Override
    public String importXnProject(List<KjcXiaoneiProject> xnProjectList, Boolean isUpdateSupport , String kjcuser){
        if (StringUtils.isNull(xnProjectList) ||xnProjectList.size() == 0)
        {
            throw new ServiceException("导入项目数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (KjcXiaoneiProject xnproject : xnProjectList)
        {
            try
            {
                // 验证是否存在这个项目

                KjcXiaoneiProject x = kjcXiaoneiProjectMapper.selectKjcXiaoneiProjectByXnProjectId(xnproject.getXnProjectId());

                if (StringUtils.isNull(x))
                {
                    this.insertKjcXiaoneiProject(xnproject);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、项目" + xnproject.getXnProjectBianhao()+ " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    this.updateKjcXiaoneiProject(xnproject);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、项目" + xnproject.getXnProjectBianhao()+ " 更新成功");
                }
                else if(StringUtils.isNotNull(x))
                {
                    failureNum++;
                    // successMsg.append("<br/>项目 " + project.getProjectBianhao()+ " 已存在");
                    failureMsg.append("<br/>项目 " + xnproject.getXnProjectBianhao()+ " 同一项目的批次已存在");
                }

            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、项目" + xnproject.getXnProjectBianhao() + " 导入失败";
                //failureMsg.append(msg + e.getMessage());
                failureMsg.append(msg);
                log.error(msg, e); //日志启用
            }
        }

        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 个项目已存在，");
            throw new ServiceException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    };
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
