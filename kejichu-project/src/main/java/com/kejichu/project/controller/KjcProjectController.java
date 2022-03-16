package com.kejichu.project.controller;

import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.kejichu.common.core.domain.entity.SysUser;
import com.kejichu.common.core.text.Convert;
import com.kejichu.common.exception.ServiceException;
import com.kejichu.common.utils.StringUtils;
import com.kejichu.project.domain.KjcImportEntity;
import com.kejichu.project.domain.KjcJixiao;
import org.apache.ibatis.session.SqlSessionException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.kejichu.common.annotation.Log;
import com.kejichu.common.enums.BusinessType;
import com.kejichu.project.domain.KjcProject;
import com.kejichu.project.service.IKjcProjectService;
import com.kejichu.common.core.controller.BaseController;
import com.kejichu.common.core.domain.AjaxResult;
import com.kejichu.common.utils.poi.ExcelUtil;
import com.kejichu.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 项目信息Controller
 * 
 * @author sxl
 * @date 2021-08-28
 */
@Controller
@RequestMapping("/project/list")
public class KjcProjectController extends BaseController {
    private String prefix = "project/list";

    @Autowired
    private IKjcProjectService kjcProjectService;

    @RequiresPermissions("project:list:view")
    @GetMapping()
    public String list() {
        return prefix + "/list";
    }

    /**
     * 查询项目信息列表
     */
    @RequiresPermissions("project:list:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(KjcProject kjcProject) {
        startPage();
        List<KjcProject> list = kjcProjectService.selectKjcProjectList(kjcProject);
        return getDataTable(list);
    }

    /**
     * 导出项目信息列表
     */
    @RequiresPermissions("project:list:export")
    @Log(title = "项目信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(KjcProject kjcProject) {
        List<KjcProject> list = kjcProjectService.selectKjcProjectList(kjcProject);
        ExcelUtil<KjcProject> util = new ExcelUtil<KjcProject>(KjcProject.class);
        return util.exportExcel(list, "项目信息数据");
    }

    //todo 导出
    //todo 导出
    //todo 导出
    /**
     * 导出项目信息列表
     */
/*    @RequiresPermissions("project:list:export")
    @Log(title = "项目信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(KjcProject kjcProject)
    {
        List<KjcImportEntity> list = kjcProjectService.selectKjcProjectList(kjcProject);
        ExcelUtil<KjcImportEntity> util = new ExcelUtil<KjcImportEntity>(KjcImportEntity.class);
        return util.exportExcel(list, "项目信息数据");
    }*/

    /**
     * 导出项目信息列表
     */
    @RequiresPermissions("project:list:export")
    @Log(title = "项目信息", businessType = BusinessType.EXPORT)
    @PostMapping("/exportByIds")
    @ResponseBody
    public AjaxResult exportByIds(KjcProject kjcProject, String ids) {
        String[] strings = {};
        if (StringUtils.isNotBlank(ids)) {
            String[] string = Convert.toStrArray(ids);
            if (string.length > 0) {
                strings = string;
            }
        }
        List<KjcProject> list = new ArrayList<>();
/*        for (int i = 0; i < strings.length; i++) {
            KjcProject kjcProject1 = new KjcProject();
            kjcProject1.setProjectId(Long.valueOf(strings[i]));
            List<KjcProject> kjcImportEntities = kjcProjectService.selectKjcProjectByProjectId(kjcProject1);
            list.addAll(kjcImportEntities);
        }*/
        for (int i = 0; i < strings.length; i++) {
            KjcProject kjcProject1 = kjcProjectService.selectKjcProjectByProjectId(Long.valueOf(strings[i]));
            if (kjcProject1 != null) {
                list.add(kjcProject1);
            }
        }
        ExcelUtil<KjcProject> util = new ExcelUtil<KjcProject>(KjcProject.class);
        return util.exportExcel(list, "项目信息数据");
    }

    /**
     *导入项目信息列表
     */
/*    @RequiresPermissions("project:list:import")
    @Log(title = "项目信息", businessType = BusinessType.IMPORT)
    @PostMapping("/importPro")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<KjcProject> util = new ExcelUtil<KjcProject>(KjcProject.class);
        List<KjcProject> projectList = util.importExcel(file.getInputStream());
        String message = kjcProjectService.importProject(projectList, updateSupport,getLoginName());
        return AjaxResult.success(message);
    }*/

    //todo
    @RequiresPermissions("project:list:import")
    @Log(title = "项目信息", businessType = BusinessType.IMPORT)
    @PostMapping("/importPro")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<KjcProject> util = new ExcelUtil<KjcProject>(KjcProject.class);
        List<KjcProject> projectList = util.importExcel(file.getInputStream());
        String s = kjcProjectService.importProject(projectList,updateSupport,getLoginName());
        if ("插入失败".equals(s)){
            return AjaxResult.error(s);
        }
        return AjaxResult.success(s);
    }

    /**
     *导入项目信息模版
     */
    @RequiresPermissions("system:list:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<KjcProject> util = new ExcelUtil<KjcProject>(KjcProject.class);
        return util.importTemplateExcel("项目信息表模版");
    }

    /**
     *导入项目信息模版
     */
/*    @RequiresPermissions("system:list:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        AjaxResult ajaxResult = new AjaxResult();
        ajaxResult.put("code", 0);
        ajaxResult.put("msg", "项目表.xls");
        return ajaxResult;
    }*/



    /**
     * 新增项目信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存项目信息
     */
    @RequiresPermissions("project:list:add")
    @Log(title = "项目信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(KjcProject kjcProject)
    {
        return toAjax(kjcProjectService.insertKjcProject(kjcProject));
    }

    /**
     * 修改项目信息
     */
    @GetMapping("/edit/{projectId}")
    public String edit(@PathVariable("projectId") Long projectId, ModelMap mmap)
    {
        KjcProject kjcProject = kjcProjectService.selectKjcProjectByProjectId(projectId);
        mmap.put("kjcProject", kjcProject);
        return prefix + "/edit";
    }

    /**
     * 修改保存项目信息
     */
    @RequiresPermissions("project:list:edit")
    @Log(title = "项目信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(KjcProject kjcProject)
    {
        return toAjax(kjcProjectService.updateKjcProject(kjcProject));
    }

    /**
     * 删除项目信息
     */
    @RequiresPermissions("project:list:remove")
    @Log(title = "项目信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
       try {
           return toAjax(kjcProjectService.deleteKjcProjectByProjectIds(ids));
       }catch (Exception e){

       }
       throw  new ServiceException("请先删除相应的拨款和绩效记录或项目文件！");
    }
}
