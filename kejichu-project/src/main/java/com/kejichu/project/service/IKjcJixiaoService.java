package com.kejichu.project.service;

import java.util.List;

import com.kejichu.project.domain.KjcJixiao;

/**
 * 绩效记录Service接口
 * 
 * @author sxl
 * @date 2021-10-09
 */
public interface IKjcJixiaoService 
{
    /**
     * 查询绩效记录
     * 
     * @param jixiaoId 绩效记录主键
     * @return 绩效记录
     */
    public KjcJixiao selectKjcJixiaoByJixiaoId(Long jixiaoId);

    /**
     * 查询绩效记录
     *
     * @param projectBianhao 绩效记录
     * @return 绩效记录
     */
    public KjcJixiao selectKjcJixiaoByprojectBianhao(String projectBianhao);

  //  public KjcJixiao

    /**
     * 查询绩效记录列表
     * 
     * @param kjcJixiao 绩效记录
     * @return 绩效记录集合
     */
    public List<KjcJixiao> selectKjcJixiaoList(KjcJixiao kjcJixiao);

    /**
     * 新增绩效记录
     * 
     * @param kjcJixiao 绩效记录
     * @return 结果
     */
    public int insertKjcJixiao(KjcJixiao kjcJixiao);

    /**
     * 导入绩效记录
     * @param projectJixiaoList
     * @return 导入结果
     */

    public String importJixiao(List<KjcJixiao> projectJixiaoList, Boolean isUpdateSupport , String kjcuser);


    /**
     * 修改绩效记录
     * 
     * @param kjcJixiao 绩效记录
     * @return 结果
     */
    public int updateKjcJixiao(KjcJixiao kjcJixiao);

    /**
     * 批量删除绩效记录
     * 
     * @param jixiaoIds 需要删除的绩效记录主键集合
     * @return 结果
     */
    public int deleteKjcJixiaoByJixiaoIds(String jixiaoIds);

    /**
     * 删除绩效记录信息
     * 
     * @param jixiaoId 绩效记录主键
     * @return 结果
     */
    public int deleteKjcJixiaoByJixiaoId(Long jixiaoId);
}
