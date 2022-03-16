package com.kejichu.project.controller;

import java.util.List;
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
import com.kejichu.project.domain.KjcProjectEdit;
import com.kejichu.project.service.IKjcProjectEditService;
import com.kejichu.common.core.controller.BaseController;
import com.kejichu.common.core.domain.AjaxResult;
import com.kejichu.common.utils.poi.ExcelUtil;
import com.kejichu.common.core.page.TableDataInfo;

/**
 * 项目修改记录Controller
 * 
 * @author sxl
 * @date 2021-08-28
 */
@Controller
@RequestMapping("/project/projectedit")
public class KjcProjectEditController extends BaseController
{
    private String prefix = "project/projectedit";

    @Autowired
    private IKjcProjectEditService kjcProjectEditService;

    @RequiresPermissions("project:projectedit:view")
    @GetMapping()
    public String projectedit()
    {
        return prefix + "/projectedit";
    }

    /**
     * 查询项目修改记录列表
     */
    @RequiresPermissions("project:projectedit:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(KjcProjectEdit kjcProjectEdit)
    {
        startPage();
        List<KjcProjectEdit> list = kjcProjectEditService.selectKjcProjectEditList(kjcProjectEdit);
        return getDataTable(list);
    }

    /**
     * 导出项目修改记录列表
     */
    @RequiresPermissions("project:projectedit:export")
    @Log(title = "项目修改记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(KjcProjectEdit kjcProjectEdit)
    {
        List<KjcProjectEdit> list = kjcProjectEditService.selectKjcProjectEditList(kjcProjectEdit);
        ExcelUtil<KjcProjectEdit> util = new ExcelUtil<KjcProjectEdit>(KjcProjectEdit.class);
        return util.exportExcel(list, "项目修改记录数据");
    }

    /**
     * 新增项目修改记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存项目修改记录
     */
    @RequiresPermissions("project:projectedit:add")
    @Log(title = "项目修改记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(KjcProjectEdit kjcProjectEdit)
    {
        return toAjax(kjcProjectEditService.insertKjcProjectEdit(kjcProjectEdit));
    }

    /**
     * 修改项目修改记录
     */
    @GetMapping("/edit/{projectEditId}")
    public String edit(@PathVariable("projectEditId") Long projectEditId, ModelMap mmap)
    {
        KjcProjectEdit kjcProjectEdit = kjcProjectEditService.selectKjcProjectEditByProjectEditId(projectEditId);
        mmap.put("kjcProjectEdit", kjcProjectEdit);
        return prefix + "/edit";
    }

    /**
     * 修改保存项目修改记录
     */
    @RequiresPermissions("project:projectedit:edit")
    @Log(title = "项目修改记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(KjcProjectEdit kjcProjectEdit)
    {
        return toAjax(kjcProjectEditService.updateKjcProjectEdit(kjcProjectEdit));
    }

    /**
     * 删除项目修改记录
     */
    @RequiresPermissions("project:projectedit:remove")
    @Log(title = "项目修改记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(kjcProjectEditService.deleteKjcProjectEditByProjectEditIds(ids));
    }
}
