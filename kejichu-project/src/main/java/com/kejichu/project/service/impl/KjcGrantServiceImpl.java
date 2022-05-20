package com.kejichu.project.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.kejichu.common.exception.ServiceException;
import com.kejichu.common.utils.StringUtils;
import com.kejichu.project.domain.KjcProject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kejichu.project.mapper.KjcGrantMapper;
import com.kejichu.project.domain.KjcGrant;
import com.kejichu.project.service.IKjcGrantService;
import com.kejichu.common.core.text.Convert;


/**
 * 拨款记录Service业务层处理
 * @author sxl
 * @date 2021-10-09
 */
@Service


public class KjcGrantServiceImpl implements IKjcGrantService 
{
    private static final Logger log = LoggerFactory.getLogger(KjcGrantServiceImpl.class);
    @Autowired
    private KjcGrantMapper kjcGrantMapper;

    /**
     * 查询拨款记录
     * 
     * @param grantId 拨款记录主键
     * @return 拨款记录
     */
    @Override
    public KjcGrant selectKjcGrantByGrantId(Long grantId)
    {
        return kjcGrantMapper.selectKjcGrantByGrantId(grantId);
    }
    /**
     * 查询拨款记录
     *
     * @param projectBianhao 拨款记录项目编号
     * @return 拨款记录
     */
    @Override
    public  KjcGrant selectKjcGrantByprojectBianhao(String projectBianhao){

        return kjcGrantMapper.selectKjcGrantByprojectBianhao(projectBianhao);

    }


    /**
     * 查询拨款记录列表
     * 
     * @param kjcGrant 拨款记录
     * @return 拨款记录
     */
    @Override
    public List<KjcGrant> selectKjcGrantList(KjcGrant kjcGrant)
    {
        return kjcGrantMapper.selectKjcGrantList(kjcGrant);
    }

    /**
     * 新增拨款记录
     * @param kjcGrant 拨款记录
     * @return 结果
     */
    @Override
    public int insertKjcGrant(KjcGrant kjcGrant) {
        List<KjcGrant> kjcGrants = kjcGrantMapper.selectKjcGrantList(kjcGrant);
        List<KjcGrant> list = new ArrayList<>();
        for (KjcGrant kjcGrant1:kjcGrants){
            if (kjcGrant1.getProjectBianhao()==kjcGrant.getProjectBianhao()){
                list.add(kjcGrant1);
            }
        }

        for(int i=0;i<list.size();i++){
            if (kjcGrant.getGrantPici()==list.get(i).getGrantPici()){
                throw new ServiceException("相同项目的拨款批次不能相同");
            }
        }

         return kjcGrantMapper.insertKjcGrant(kjcGrant);
    }
    /**
     * 修改拨款记录
     * @param kjcGrant 拨款记录
     * @return 结果
     */
    @Override
    public int updateKjcGrant(KjcGrant kjcGrant)
    {
        return kjcGrantMapper.updateKjcGrant(kjcGrant);
    }

    /**
     * 导入拨款记录
     * @param projectGrantList
     * @return 导入结果
     */
    @Override
    public String importGrant(List<KjcGrant> projectGrantList, Boolean isUpdateSupport , String kjcuser){
        if (StringUtils.isNull(projectGrantList) ||projectGrantList.size() == 0)
        {
            throw new ServiceException("导入项目数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (KjcGrant grant : projectGrantList)
        {
            try
            {
                // 验证是否存在这个项目
               // KjcGrant m = kjcGrantMapper.selectKjcGrantByprojectBianhao(grant.getProjectBianhao());
                KjcGrant t =kjcGrantMapper.selectKjcGrantByGrantId(grant.getGrantId());
                //KjcGrant p = kjcGrantMapper.selectKjcGrantBygrantPici(grant.getGrantPici());


                    if (StringUtils.isNull(t))
                    {
                        this.insertKjcGrant(grant);
                        successNum++;
                        successMsg.append("<br/>" + successNum + "、项目" + grant.getProjectBianhao()+ " 导入成功");
                    }
                    else if (isUpdateSupport)
                    {
                        this.updateKjcGrant(grant);
                        successNum++;
                        successMsg.append("<br/>" + successNum + "、项目" + grant.getProjectBianhao()+ " 更新成功");
                    }
                    else if(StringUtils.isNotNull(t))
                    {
                         failureNum++;
                        // successMsg.append("<br/>项目 " + project.getProjectBianhao()+ " 已存在");
                        failureMsg.append("<br/>项目 " +  grant.getProjectBianhao()+ " 同一项目的批次已存在");
                    }

            }
                catch (Exception e)
                {
                    failureNum++;
                    String msg = "<br/>" + failureNum + "、项目" + grant.getProjectBianhao() + " 导入失败";
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
     * 批量删除拨款记录
     * 
     * @param grantIds 需要删除的拨款记录主键
     * @return 结果
     */
    @Override
    public int deleteKjcGrantByGrantIds(String grantIds)
    {
        return kjcGrantMapper.deleteKjcGrantByGrantIds(Convert.toStrArray(grantIds));
    }

    /**
     * 删除拨款记录信息
     * 
     * @param grantId 拨款记录主键
     * @return 结果
     */
    @Override
    public int deleteKjcGrantByGrantId(Long grantId)
    {
        return kjcGrantMapper.deleteKjcGrantByGrantId(grantId);
    }
}
