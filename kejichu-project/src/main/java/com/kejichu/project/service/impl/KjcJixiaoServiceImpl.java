package com.kejichu.project.service.impl;

import java.util.List;

import com.kejichu.common.core.domain.AjaxResult;
import com.kejichu.common.exception.ServiceException;
import com.kejichu.common.utils.StringUtils;
import com.kejichu.project.domain.KjcProject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kejichu.project.mapper.KjcJixiaoMapper;
import com.kejichu.project.domain.KjcJixiao;
import com.kejichu.project.service.IKjcJixiaoService;
import com.kejichu.common.core.text.Convert;
import com.kejichu.project.mapper.KjcProjectMapper;
/**
 * 绩效记录Service业务层处理
 * 
 * @author sxl
 * @date 2021-10-09
 */
@Service
public class KjcJixiaoServiceImpl implements IKjcJixiaoService 
{
    private static final Logger log = LoggerFactory.getLogger(KjcJixiaoServiceImpl.class);
    @Autowired
    private KjcJixiaoMapper kjcJixiaoMapper;

    @Autowired
    private KjcProjectMapper kjcProjectMapper;



    /**
     * 查询绩效记录
     * 
     * @param jixiaoId 绩效记录主键
     * @return 绩效记录
     */
    @Override
    public KjcJixiao selectKjcJixiaoByJixiaoId(Long jixiaoId)
    {
        return kjcJixiaoMapper.selectKjcJixiaoByJixiaoId(jixiaoId);
    }
    /**
     * 查询项目编号
     *
     * @param
     * @return 项目编号
     */

    @Override
    public KjcJixiao selectKjcJixiaoByprojectBianhao(String projectBianhao) {
        return kjcJixiaoMapper.selectKjcJixiaoByprojectBianhao(projectBianhao);
    }


    /**
     * 查询绩效记录列表
     * 
     * @param kjcJixiao 绩效记录
     * @return 绩效记录
     */
    @Override
    public List<KjcJixiao> selectKjcJixiaoList(KjcJixiao kjcJixiao)
    {
        return kjcJixiaoMapper.selectKjcJixiaoList(kjcJixiao);
    }

    /**
     * 新增绩效记录
     * 
     * @param kjcJixiao 绩效记录
     * @return 结果
     */
    @Override
    public int insertKjcJixiao(KjcJixiao kjcJixiao)
    {
        StringBuilder failureMsg = new StringBuilder();
        try {
            KjcJixiao x = kjcJixiaoMapper.selectKjcJixiaoByprojectBianhao(kjcJixiao.getProjectBianhao());
            if(StringUtils.isNull(x)){
                return kjcJixiaoMapper.insertKjcJixiao(kjcJixiao);}
        }catch (Exception e){}
            throw new ServiceException("项目绩效已存在或未添加项目信息");
    }

    /**
     * 导入拨款记录
     * @param projectJixiaoList
     * @return 导入结果
     */
    @Override
    public String importJixiao(List<KjcJixiao> projectJixiaoList, Boolean isUpdateSupport , String kjcuser){
        if (StringUtils.isNull(projectJixiaoList) ||projectJixiaoList.size() == 0)
        {
            throw new ServiceException("导入项目数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (KjcJixiao jixiao : projectJixiaoList)
        {
            try
            {
                // 验证是否存在这个项目
                /*异常的几种可能：
                *导入的项目编号已经存在（已解决）
                * 导入项目绩效的时候没有导入相应的项目（已解决）
                * 两种异常同时捕获但不能按情况分开（已解决）
                * */
                KjcJixiao x =kjcJixiaoMapper.selectKjcJixiaoByprojectBianhao(jixiao.getProjectBianhao());

                if (StringUtils.isNull(x))
                {
                    this.insertKjcJixiao(jixiao);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、项目" + jixiao.getProjectBianhao()+ " 导入成功");
                }
                else if (isUpdateSupport)
                {
                    this.updateKjcJixiao(jixiao);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、项目" + jixiao.getProjectBianhao()+ " 更新成功");
                }

                else if(StringUtils.isNotNull(x))
                {
                    failureNum++;
                    failureMsg.append("<br/>" + failureNum + "、项目" +  jixiao.getProjectBianhao()+ " 绩效信息已存在");
                }

            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、项目" + jixiao.getProjectBianhao() + " 导入失败,项目编号错误或者不存在";
                //failureMsg.append(msg + e.getMessage());
                failureMsg.append(msg);
                log.error(msg, e); //日志启用
            }
        }

        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum+"条" );
            throw new ServiceException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    };

    /**
     * 修改绩效记录
     * 
     * @param kjcJixiao 绩效记录
     * @return 结果
     */
    @Override
    public int updateKjcJixiao(KjcJixiao kjcJixiao)
    {
        return kjcJixiaoMapper.updateKjcJixiao(kjcJixiao);
    }

    /**
     * 批量删除绩效记录
     * 
     * @param jixiaoIds 需要删除的绩效记录主键
     * @return 结果
     */
    @Override
    public int deleteKjcJixiaoByJixiaoIds(String jixiaoIds)
    {
        return kjcJixiaoMapper.deleteKjcJixiaoByJixiaoIds(Convert.toStrArray(jixiaoIds));
    }

    /**
     * 删除绩效记录信息
     * 
     * @param jixiaoId 绩效记录主键
     * @return 结果
     */
    @Override
    public int deleteKjcJixiaoByJixiaoId(Long jixiaoId)
    {
        return kjcJixiaoMapper.deleteKjcJixiaoByJixiaoId(jixiaoId);
    }
}
