package com.kejichu.system.service;

import java.util.List;
import com.kejichu.system.domain.KjcUser;

/**
 * 教师信息Service接口
 * 
 * @author sxl
 * @date 2021-08-30
 */
public interface IKjcUserService 
{
    /**
     * 查询教师信息
     * 
     * @param userId 教师信息主键
     * @return 教师信息
     */
    public KjcUser selectKjcUserByUserId(Long userId);

    /**
     * 查询教师信息列表
     * 
     * @param kjcUser 教师信息
     * @return 教师信息集合
     */
    public List<KjcUser> selectKjcUserList(KjcUser kjcUser);

    /**
     * 新增教师信息
     * 
     * @param kjcUser 教师信息
     * @return 结果
     */
    public int insertKjcUser(KjcUser kjcUser);

    /**
     * 修改教师信息
     * 
     * @param kjcUser 教师信息
     * @return 结果
     */
    public int updateKjcUser(KjcUser kjcUser);

    /**
     * 批量删除教师信息
     * 
     * @param userIds 需要删除的教师信息主键集合
     * @return 结果
     */
    public int deleteKjcUserByUserIds(String userIds);

    /**
     * 删除教师信息信息
     * 
     * @param userId 教师信息主键
     * @return 结果
     */
    public int deleteKjcUserByUserId(Long userId);
}
