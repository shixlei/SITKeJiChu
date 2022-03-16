package com.kejichu.project.service.impl;

import java.util.List;


import com.kejichu.project.mapper.KjcProjectFileMapper;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.kejichu.common.core.domain.entity.SysUser;
import com.kejichu.common.exception.ServiceException;
import com.kejichu.common.utils.DateUtils;
import com.kejichu.common.utils.StringUtils;
import com.kejichu.common.utils.security.Md5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kejichu.project.mapper.KjcProjectMapper;
import com.kejichu.project.domain.KjcProject;
import com.kejichu.project.service.IKjcProjectService;
import com.kejichu.common.core.text.Convert;

/**
 * 项目信息Service业务层处理
 * 
 * @author sxl
 * @date 2021-08-28
 */
@Service
public class KjcProjectServiceImpl implements IKjcProjectService {
    private static final Logger log = LoggerFactory.getLogger(KjcProjectServiceImpl.class);
    @Autowired
    private KjcProjectMapper kjcProjectMapper;

    @Autowired
    private KjcProjectFileMapper kjcProjectFileMapper;


/*    @Autowired
    private KjcJixiaoMapper kjcJixiaoMapper;
    @Autowired
    private KjcGrantMapper kjcGrantMapper;*/


    /**
     * 查询项目信息
     *
     * @param projectId 项目信息主键
     * @return 项目信息
     */
    @Override
    public KjcProject selectKjcProjectByProjectId(Long projectId) {
        return kjcProjectMapper.selectKjcProjectByProjectId(projectId);
    }

    /**
     * 查询项目编号
     *
     * @param
     * @return 项目编号
     */
    @Override
    public KjcProject selectKjcProjectByprojectBianhao(String projectBianhao) {
        return kjcProjectMapper.selectKjcProjectByprojectBianhao(projectBianhao);
    }


    @Override
    public List<KjcProject> selectKjcProjectList(KjcProject kjcProject) {
        return kjcProjectMapper.selectKjcProjectList2(kjcProject);
    }


    /**
     * 查询项目信息列表
     *
     * @param kjcProject 项目信息
     * @return 项目信息
     */
/*    @Override
    public List<KjcImportEntity> selectKjcProjectList(KjcProject kjcProject) {
        List<KjcImportEntity> kjcImportEntities = kjcProjectMapper.selectKjcProjectList(kjcProject);
        if (CollectionUtils.isEmpty(kjcImportEntities)){
            return kjcImportEntities;
        }
        for (KjcImportEntity kjc : kjcImportEntities) {
            setStatus(kjc);
        }
        return kjcImportEntities;
    }

    public void setStatus(KjcImportEntity kjc){
        String projectStatus = kjc.getProjectStatus();
        if (StringUtils.isBlank(projectStatus)){
            kjc.setProjectStatus("");
        }
        if ("1".equals(projectStatus)){
            kjc.setProjectStatus("在研");
        } else if ("2".equals(projectStatus)){
            kjc.setProjectStatus("结题");
        } else if ("3".equals(projectStatus)){
            kjc.setProjectStatus("终止");
        } else if ("4".equals(projectStatus)){
            kjc.setProjectStatus("延期");
        } else {
            kjc.setProjectStatus("");
        }
    }*/


    /**
     * 新增项目信息
     *
     * @param kjcProject 项目信息
     * @return 结果
     */
    @Override
    public int insertKjcProject(KjcProject kjcProject) {
        KjcProject m = kjcProjectMapper.selectKjcProjectByprojectBianhao(kjcProject.getProjectBianhao());
        if (StringUtils.isNull(m)) {
            kjcProject.setCreateTime(DateUtils.getNowDate());
            return kjcProjectMapper.insertKjcProject(kjcProject);
        } else {
            throw new ServiceException("添加的项目已存在");
        }
    }

    /**
     * 导入用户数据
     *
     * @param projectList     项目列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param kjcuser         项目id
     * @return 结果
     */
    @Override
    public String importProject(List<KjcProject> projectList, Boolean isUpdateSupport, String kjcuser) {
        if (StringUtils.isNull(projectList) || projectList.size() == 0) {
            throw new ServiceException("导入项目数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (KjcProject project : projectList) {
            try {
                // 验证是否存在这个项目
                KjcProject m = kjcProjectMapper.selectKjcProjectByprojectBianhao(project.getProjectBianhao());

                if (StringUtils.isNull(m)) {
                    this.insertKjcProject(project);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、项目" + project.getProjectBianhao() + " 导入成功");
                } else if (isUpdateSupport) {
                    this.updateKjcProject(project);
                    successNum++;
                    successMsg.append("<br/>" + successNum + "、项目" + project.getProjectBianhao() + " 更新成功");
                } else if (StringUtils.isNotNull(m)) {
                    failureNum++;
                    //successMsg.append("<br/>项目 " + project.getProjectBianhao()+ " 已存在");
                    failureMsg.append("<br/>项目 " + project.getProjectBianhao() + " 已存在");

                }

            } catch (Exception e) {
                failureNum++;
                String msg = "<br/>" + failureNum + "、项目" + project.getProjectBianhao() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e); //日志启用
            }
        }

        if (failureNum > 0) {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 个项目已存在，");
            throw new ServiceException(failureMsg.toString());
        } else {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }

 /*   @Override
    public String importProject(List<KjcImportEntity> projectList) {
        if (CollectionUtils.isEmpty(projectList)){
            return "插入失败";
        }
        for (KjcImportEntity kjc : projectList) {
            KjcProject kjcProject = new KjcProject();
            kjcProject.setProjectBianhao(kjc.getProjectBianhao());
            kjcProject.setProjectLeader(kjc.getProjectLeader());
            kjcProject.setProjectStatus(getProjectStatus(kjc.getProjectStatus()));
            kjcProjectMapper.insertKjcProject(kjcProject);

            KjcJixiao kjcJixiao = new KjcJixiao();
            kjcJixiao.setProjectBianhao(kjc.getProjectBianhao());
            kjcJixiao.setJixiaoMoney(kjc.getJixiaoMoney());
            kjcJixiaoMapper.insertKjcJixiao(kjcJixiao);

            KjcGrant kjcGrant = new KjcGrant();
            kjcGrant.setProjectBianhao(kjc.getProjectBianhao());
            kjcGrant.setGrantPici(kjc.getGrantPici());
            kjcGrant.setGrantTime(kjc.getGrantTime());
            kjcGrantMapper.insertKjcGrant(kjcGrant);

        }

        return "插入成功";
    }*/



/*
    public String getProjectStatus(String status){
        if (StringUtils.isBlank(status)){
            return "0";
        }
        if ("在研".equals(status)){
            return "1";
        } else if ("结题".equals(status)){
            return "2";
        } else if ("终止".equals(status)){
            return "3";
        } else if ("延期".equals(status)){
            return "4";
        }

        return "0";
    }
*/



    /**
     * 修改项目信息
     *
     * @param kjcProject 项目信息
     * @return 结果
     */
    @Override
    public int updateKjcProject(KjcProject kjcProject) {
        return kjcProjectMapper.updateKjcProject(kjcProject);
    }

    /**
     * 批量删除项目信息
     *
     * @param projectIds 需要删除的项目信息主键
     * @return 结果
     */
    @Override
    public int deleteKjcProjectByProjectIds(String projectIds) {
        String[] strings = Convert.toStrArray(projectIds);
        for (String string : strings) {
            KjcProject kjcProject = kjcProjectMapper.selectKjcProjectByProjectId(Long.parseLong(string));
            if (kjcProject != null){
                String projectBianhao = kjcProject.getProjectBianhao();
                int count = kjcProjectFileMapper.selectExistFileByProjectNo(projectBianhao);
                if (count > 0){
                    throw new ServiceException("请先删除对应的项目文件!");
                }
            }
        }
        return kjcProjectMapper.deleteKjcProjectByProjectIds(Convert.toStrArray(projectIds));

    }


    /**
     * 删除项目信息信息
     * 
     * @param projectId 项目信息主键
     * @return 结果
     */
    @Override
    public int deleteKjcProjectByProjectId(Long projectId) {
            return kjcProjectMapper.deleteKjcProjectByProjectId(projectId);
    }
}

