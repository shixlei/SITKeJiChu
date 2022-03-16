package com.kejichu.project.mapper;

import java.util.List;
import com.kejichu.project.domain.KjcGrant;
import com.kejichu.project.domain.KjcProject;

/**
 * 拨款记录Mapper接口
 * 
 * @author sxl
 * @date 2021-10-09
 */
public interface KjcGrantMapper 
{
    /**
     * 查询拨款记录
     * 
     * @param grantId 拨款记录主键
     * @return 拨款记录
     */
    public KjcGrant selectKjcGrantByGrantId(Long grantId);
    /**
     * 查询项目编号
     * @param
     * @return 项目编号
     */

    public KjcGrant selectKjcGrantByprojectBianhao(String projectBianhao);
    /**
     * 查询项目编号
     * @param grantPici
     * @return 项目编号
     */
    public  KjcGrant selectKjcGrantBygrantPici(Long grantPici);



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
     * 修改拨款记录
     * 
     * @param kjcGrant 拨款记录
     * @return 结果
     */
    public int updateKjcGrant(KjcGrant kjcGrant);

    /**
     * 删除拨款记录
     * 
     * @param grantId 拨款记录主键
     * @return 结果
     */
    public int deleteKjcGrantByGrantId(Long grantId);

    /**
     * 批量删除拨款记录
     * 
     * @param grantIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteKjcGrantByGrantIds(String[] grantIds);
}
