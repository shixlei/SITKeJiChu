package com.kejichu.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kejichu.system.mapper.KjcUserMapper;
import com.kejichu.system.domain.KjcUser;
import com.kejichu.system.service.IKjcUserService;
import com.kejichu.common.core.text.Convert;

/**
 * 教师信息Service业务层处理
 * 
 * @author sxl
 * @date 2021-08-30
 */
@Service
public class KjcUserServiceImpl implements IKjcUserService 
{
    @Autowired
    private KjcUserMapper kjcUserMapper;

    /**
     * 查询教师信息
     * 
     * @param userId 教师信息主键
     * @return 教师信息
     */
    @Override
    public KjcUser selectKjcUserByUserId(Long userId)
    {
        return kjcUserMapper.selectKjcUserByUserId(userId);
    }

    /**
     * 查询教师信息列表
     * 
     * @param kjcUser 教师信息
     * @return 教师信息
     */
    @Override
    public List<KjcUser> selectKjcUserList(KjcUser kjcUser)
    {
        return kjcUserMapper.selectKjcUserList(kjcUser);
    }

    /**
     * 新增教师信息
     * 
     * @param kjcUser 教师信息
     * @return 结果
     */
    @Override
    public int insertKjcUser(KjcUser kjcUser)
    {
        return kjcUserMapper.insertKjcUser(kjcUser);
    }

    /**
     * 修改教师信息
     * 
     * @param kjcUser 教师信息
     * @return 结果
     */
    @Override
    public int updateKjcUser(KjcUser kjcUser)
    {
        return kjcUserMapper.updateKjcUser(kjcUser);
    }

    /**
     * 批量删除教师信息
     * 
     * @param userIds 需要删除的教师信息主键
     * @return 结果
     */
    @Override
    public int deleteKjcUserByUserIds(String userIds)
    {
        return kjcUserMapper.deleteKjcUserByUserIds(Convert.toStrArray(userIds));
    }

    /**
     * 删除教师信息信息
     * 
     * @param userId 教师信息主键
     * @return 结果
     */
    @Override
    public int deleteKjcUserByUserId(Long userId)
    {
        return kjcUserMapper.deleteKjcUserByUserId(userId);
    }
}
