package com.kejichu.project.controller;

import java.util.ArrayList;
import java.util.List;

import com.kejichu.common.core.text.Convert;
import com.kejichu.common.utils.StringUtils;
import com.kejichu.project.domain.KjcGrant;
import com.kejichu.project.domain.KjcProject;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
import com.kejichu.project.domain.KjcXiaoneiProject;
import com.kejichu.project.service.IKjcXiaoneiProjectService;
import com.kejichu.common.core.controller.BaseController;
import com.kejichu.common.core.domain.AjaxResult;
import com.kejichu.common.utils.poi.ExcelUtil;
import com.kejichu.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 校内项目Controller
 * 
 * @author tcl
 * @date 2022-05-26
 */
@Controller
@RequestMapping("/project/xnproject")
public class KjcXiaoneiProjectController extends BaseController
{
    private String prefix = "project/xnproject";

    @Autowired
    private IKjcXiaoneiProjectService kjcXiaoneiProjectService;

    @RequiresPermissions("project:xnproject:view")
    @GetMapping()
    public String xnproject()
    {
        return prefix + "/xnproject";
    }

    /**
     * 查询校内项目列表
     */
    @RequiresPermissions("project:xnproject:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(KjcXiaoneiProject kjcXiaoneiProject)
    {
        startPage();
        List<KjcXiaoneiProject> list = kjcXiaoneiProjectService.selectKjcXiaoneiProjectList(kjcXiaoneiProject);
        return getDataTable(list);
    }

    /**
     * 导出校内项目列表
     */
    @RequiresPermissions("project:xnproject:export")
    @Log(title = "校内项目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(KjcXiaoneiProject kjcXiaoneiProject)
    {
        List<KjcXiaoneiProject> list = kjcXiaoneiProjectService.selectKjcXiaoneiProjectList(kjcXiaoneiProject);
        ExcelUtil<KjcXiaoneiProject> util = new ExcelUtil<KjcXiaoneiProject>(KjcXiaoneiProject.class);
        return util.exportExcel(list, "校内项目数据");
    }
    @RequiresPermissions("project:xnproject:export")
    @Log(title = "校内项目信息记录", businessType = BusinessType.EXPORT)
    @PostMapping("/exportByIds")
    @ResponseBody
    public AjaxResult exportByIds(KjcXiaoneiProject kjcXiaoneiProject, String ids)
    {
        String[] strings = {};
        if (StringUtils.isNotBlank(ids)){
            String[] string = Convert.toStrArray(ids);
            if (string.length > 0){
                strings = string;
            }
        }
        List<KjcXiaoneiProject> list = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            KjcXiaoneiProject kjcXiaoneiProject1 =kjcXiaoneiProjectService.selectKjcXiaoneiProjectByXnProjectId(Long.valueOf(strings[i]));
            if (kjcXiaoneiProject1 != null){
                list.add(kjcXiaoneiProject1);
            }
        }
        ExcelUtil<KjcXiaoneiProject> util = new ExcelUtil<KjcXiaoneiProject>(KjcXiaoneiProject.class);
        return util.exportExcel(list, "校内项目记录数据");
    }


    /**
     * 新增校内项目
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存校内项目
     */
    @RequiresPermissions("project:xnproject:add")
    @Log(title = "校内项目", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(KjcXiaoneiProject kjcXiaoneiProject)
    {
        return toAjax(kjcXiaoneiProjectService.insertKjcXiaoneiProject(kjcXiaoneiProject));
    }
    /**
     *导入项目信息列表
     */
    @RequiresPermissions("project:xnproject:import")
    @Log(title = "校内项目信息", businessType = BusinessType.IMPORT)
    @PostMapping("/importXnProject")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
            ExcelUtil<KjcXiaoneiProject> util = new ExcelUtil<KjcXiaoneiProject>(KjcXiaoneiProject.class);
            List<KjcXiaoneiProject> xnProjectList = util.importExcel(file.getInputStream());
            String message = kjcXiaoneiProjectService.importXnProject(xnProjectList,updateSupport,getLoginName());
            return AjaxResult.success(message);
    }
    /**
     *导入项目信息模版ß
     */
    @RequiresPermissions("system:list:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<KjcXiaoneiProject> util = new ExcelUtil<KjcXiaoneiProject>(KjcXiaoneiProject.class);
        return util.importTemplateExcel("校内项目信息表模版");
    }


    /**
     * 修改校内项目
     */
    @GetMapping("/edit/{xnProjectId}")
    public String edit(@PathVariable("xnProjectId") Long xnProjectId, ModelMap mmap)
    {
        KjcXiaoneiProject kjcXiaoneiProject = kjcXiaoneiProjectService.selectKjcXiaoneiProjectByXnProjectId(xnProjectId);
        mmap.put("kjcXiaoneiProject", kjcXiaoneiProject);
        return prefix + "/edit";
    }

    /**
     * 修改保存校内项目
     */
    @RequiresPermissions("project:xnproject:edit")
    @Log(title = "校内项目", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(KjcXiaoneiProject kjcXiaoneiProject)
    {
        return toAjax(kjcXiaoneiProjectService.updateKjcXiaoneiProject(kjcXiaoneiProject));
    }

    /**
     * 删除校内项目
     */
    @RequiresPermissions("project:xnproject:remove")
    @Log(title = "校内项目", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(kjcXiaoneiProjectService.deleteKjcXiaoneiProjectByXnProjectIds(ids));
    }
}
