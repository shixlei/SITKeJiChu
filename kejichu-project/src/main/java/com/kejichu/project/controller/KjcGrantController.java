package com.kejichu.project.controller;
import java.util.ArrayList;
import java.util.List;

import com.kejichu.common.core.text.Convert;
import com.kejichu.common.exception.ServiceException;
import com.kejichu.common.utils.StringUtils;
import com.kejichu.project.domain.KjcJixiao;
import com.kejichu.project.service.impl.KjcProjectServiceImpl;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.kejichu.common.annotation.Log;
import com.kejichu.common.enums.BusinessType;
import com.kejichu.project.domain.KjcGrant;
import com.kejichu.project.domain.KjcProject;
import com.kejichu.project.service.IKjcGrantService;
import com.kejichu.common.core.controller.BaseController;
import com.kejichu.common.core.domain.AjaxResult;
import com.kejichu.common.utils.poi.ExcelUtil;
import com.kejichu.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 拨款记录Controller
 * @author sxl
 * @date 2021-10-09
 */

@Controller
@RequestMapping("/project/grant")
public class KjcGrantController extends BaseController
{
    private String prefix = "project/grant";

    @Autowired
    private IKjcGrantService kjcGrantService;

    @RequiresPermissions("project:grant:view")
    @GetMapping()
    public String grant()
    {
        return prefix + "/grant";
    }

    /**
     * 查询拨款记录列表
     */

    @RequiresPermissions("project:grant:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(KjcGrant kjcGrant)
    {
        startPage();
        List<KjcGrant> list = kjcGrantService.selectKjcGrantList(kjcGrant);
        return getDataTable(list);
    }

    /**
     * 导出拨款记录列表
     */
    @RequiresPermissions("project:grant:export")
    @Log(title = "拨款记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(KjcGrant kjcGrant)
    {
        List<KjcGrant> list = kjcGrantService.selectKjcGrantList(kjcGrant);
        ExcelUtil<KjcGrant> util = new ExcelUtil<KjcGrant>(KjcGrant.class);
        return util.exportExcel(list, "拨款记录数据");
    }

    @RequiresPermissions("project:grant:export")
    @Log(title = "拨款记录", businessType = BusinessType.EXPORT)
    @PostMapping("/exportByIds")
    @ResponseBody
    public AjaxResult exportByIds(KjcGrant kjcGrant, String ids)
    {
        String[] strings = {};
        if (StringUtils.isNotBlank(ids)){
            String[] string = Convert.toStrArray(ids);
            if (string.length > 0){
                strings = string;
            }
        }
        List<KjcGrant> list = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            KjcGrant kjcGrant1 = kjcGrantService.selectKjcGrantByGrantId(Long.valueOf(strings[i]));
            if (kjcGrant1 != null){
                list.add(kjcGrant1);
            }
        }
        ExcelUtil<KjcGrant> util = new ExcelUtil<KjcGrant>(KjcGrant.class);
        return util.exportExcel(list, "拨款记录数据");
    }

    /**
     * 新增拨款记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存拨款记录
     */
    @RequiresPermissions("project:grant:add")
    @Log(title = "拨款记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(KjcGrant kjcGrant) {
        try{
        KjcProject kjcProject = new KjcProject();

        if (StringUtils.isNotEmpty(kjcGrant.getProjectBianhao())&&kjcGrant.getProjectBianhao().equals(kjcProject.getProjectBianhao())) {
           return error("请输入正确的项目编号");
        }

        else { return toAjax(kjcGrantService.insertKjcGrant(kjcGrant)); }
        }

        catch (Exception e){}
        return AjaxResult.error("请输正确的项目编号");
    }

    /**
     *导入项目信息列表
     */
    @RequiresPermissions("project:grant:import")
    @Log(title = "拨款信息", businessType = BusinessType.IMPORT)
    @PostMapping("/importGrant")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        KjcProject kjcProject = new KjcProject();
        KjcGrant kjcGrant = new KjcGrant();

        if (StringUtils.isNotEmpty(kjcGrant.getProjectBianhao())&&kjcGrant.getProjectBianhao().equals(kjcProject.getProjectBianhao())) {
            return error("导入项目编号不存在或项目编号错误");
        }
        else{
            ExcelUtil<KjcGrant> util = new ExcelUtil<KjcGrant>(KjcGrant.class);
            List<KjcGrant> projectGrantList = util.importExcel(file.getInputStream());
            String message = kjcGrantService.importGrant(projectGrantList, updateSupport, getLoginName());
            return AjaxResult.success(message);
        }
    }
    /**
     *导入项目信息模版ß
     */
    @RequiresPermissions("system:list:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<KjcGrant> util = new ExcelUtil<KjcGrant>(KjcGrant.class);
        return util.importTemplateExcel("项目拨款信息表模版");
    }



    /**
     * 修改拨款记录
     */
    @GetMapping("/edit/{grantId}")
    public String edit(@PathVariable("grantId") Long grantId, ModelMap mmap)
    {
        KjcGrant kjcGrant = kjcGrantService.selectKjcGrantByGrantId(grantId);
        mmap.put("kjcGrant", kjcGrant);
        return prefix + "/edit";
    }

    /**
     * 修改保存拨款记录
     */
    @RequiresPermissions("project:grant:edit")
    @Log(title = "拨款记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(KjcGrant kjcGrant)
    {
        return toAjax(kjcGrantService.updateKjcGrant(kjcGrant));
    }

    /**
     * 删除拨款记录
     */
    @RequiresPermissions("project:grant:remove")
    @Log(title = "拨款记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(kjcGrantService.deleteKjcGrantByGrantIds(ids));
    }
}
