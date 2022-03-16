package com.kejichu.project.service;

import java.util.List;
import com.kejichu.project.domain.KjcGrant;
import com.kejichu.project.domain.KjcProject;

/**
 * 拨款记录Service接口
 * 
 * @author sxl
 * @date 2021-10-09
 */
public interface IKjcGrantService 
{
    /**
     * 查询拨款记录
     * 
     * @param grantId 拨款记录主键
     * @return 拨款记录
     */
    public KjcGrant selectKjcGrantByGrantId(Long grantId);

    /**
     * 查询拨款记录列表
     * 
     * @param kjcGrant 拨款记录
     * @return 拨款记录集合
     */
    public List<KjcGrant> selectKjcGrantList(KjcGrant kjcGrant);



    /**
     * 新增拨款记录
     * 
     * @param kjcGrant 拨款记录
     * @return 结果
     */
    public int insertKjcGrant(KjcGrant kjcGrant);

    /**
     * 导入拨款记录
     * @param projectGrantList
     * @return 导入结果
     */
  //  public String importGrant(KjcGrant kjcGrant);
    public String importGrant(List<KjcGrant> projectGrantList, Boolean isUpdateSupport , String kjcuser);


    /**
     * 修改拨款记录
     * 
     * @param kjcGrant 拨款记录
     * @return 结果
     */
    public int updateKjcGrant(KjcGrant kjcGrant);

    /**
     * 批量删除拨款记录
     * 
     * @param grantIds 需要删除的拨款记录主键集合
     * @return 结果
     */
    public int deleteKjcGrantByGrantIds(String grantIds);

    /**
     * 删除拨款记录信息
     * 
     * @param grantId 拨款记录主键
     * @return 结果
     */
    public int deleteKjcGrantByGrantId(Long grantId);
}
