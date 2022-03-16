package com.kejichu.project.mapper;

import java.util.List;
import com.kejichu.project.domain.KjcJixiao;

/**
 * 绩效记录Mapper接口
 * 
 * @author sxl
 * @date 2021-10-09
 */
public interface KjcJixiaoMapper 
{
    /**
     * 查询绩效记录
     * 
     * @param jixiaoId 绩效记录主键
     * @return 绩效记录
     */

    public KjcJixiao selectKjcJixiaoByJixiaoId(Long jixiaoId);
    /**
     * 查询项目编号
     * @param projectBianhao
     * @return 项目编号
     */

    public KjcJixiao selectKjcJixiaoByprojectBianhao(String projectBianhao);


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
     * 修改绩效记录
     * 
     * @param kjcJixiao 绩效记录
     * @return 结果
     */
    public int updateKjcJixiao(KjcJixiao kjcJixiao);

    /**
     * 删除绩效记录
     * 
     * @param jixiaoId 绩效记录主键
     * @return 结果
     */
    public int deleteKjcJixiaoByJixiaoId(Long jixiaoId);

    /**
     * 批量删除绩效记录
     * 
     * @param jixiaoIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteKjcJixiaoByJixiaoIds(String[] jixiaoIds);
}
