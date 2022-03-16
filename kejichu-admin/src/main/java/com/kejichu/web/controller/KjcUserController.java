package com.kejichu.web.controller;

import java.util.ArrayList;
import java.util.List;

import com.kejichu.common.core.text.Convert;
import com.kejichu.common.utils.StringUtils;
import com.kejichu.project.domain.KjcJixiao;
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
import com.kejichu.system.domain.KjcUser;
import com.kejichu.system.service.IKjcUserService;
import com.kejichu.common.core.controller.BaseController;
import com.kejichu.common.core.domain.AjaxResult;
import com.kejichu.common.utils.poi.ExcelUtil;
import com.kejichu.common.core.page.TableDataInfo;

/**
 * 教师信息Controller
 * 
 * @author sxl
 * @date 2021-08-30
 */
@Controller
@RequestMapping("/system/teacher")
public class KjcUserController extends BaseController
{
    private String prefix = "system/teacher";

    @Autowired
    private IKjcUserService kjcUserService;

    @RequiresPermissions("system:teacher:view")
    @GetMapping()
    public String teacher()
    {
        return prefix + "/teacher";
    }

    /**
     * 查询教师信息列表
     */
    @RequiresPermissions("system:teacher:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(KjcUser kjcUser)
    {
        startPage();
        List<KjcUser> list = kjcUserService.selectKjcUserList(kjcUser);
        return getDataTable(list);
    }

    /**
     * 导出教师信息列表
     */
/*    @RequiresPermissions("system:teacher:export")
    @Log(title = "教师信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(KjcUser kjcUser)
    {
        List<KjcUser> list = kjcUserService.selectKjcUserList(kjcUser);
        ExcelUtil<KjcUser> util = new ExcelUtil<KjcUser>(KjcUser.class);
        return util.exportExcel(list, "教师信息数据");
    }*/


    @RequiresPermissions("system:teacher:export")
    @Log(title = "教师信息", businessType = BusinessType.EXPORT)
    @PostMapping("/exportByIds")
    @ResponseBody
    public AjaxResult exportByIds(KjcUser kjcUser, String ids)
    {
        String[] strings = {};
        if (StringUtils.isNotBlank(ids)){
            String[] string = Convert.toStrArray(ids);
            if (string.length > 0){
                strings = string;
            }
        }
        List<KjcUser> list = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            KjcUser kjcUser1 = kjcUserService.selectKjcUserByUserId(Long.valueOf(strings[i]));
            if (kjcUser1 != null){
                list.add(kjcUser1);
            }
        }
        ExcelUtil<KjcUser> util = new ExcelUtil<KjcUser>(KjcUser.class);
        return util.exportExcel(list, "教师信息数据");
    }
    /**
     * 新增教师信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存教师信息
     */
    @RequiresPermissions("system:teacher:add")
    @Log(title = "教师信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(KjcUser kjcUser)
    {
        return toAjax(kjcUserService.insertKjcUser(kjcUser));
    }

    /**
     * 修改教师信息
     */
    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") Long userId, ModelMap mmap)
    {
        KjcUser kjcUser = kjcUserService.selectKjcUserByUserId(userId);
        mmap.put("kjcUser", kjcUser);
        return prefix + "/edit";
    }

    /**
     * 修改保存教师信息
     */
    @RequiresPermissions("system:teacher:edit")
    @Log(title = "教师信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(KjcUser kjcUser)
    {
        return toAjax(kjcUserService.updateKjcUser(kjcUser));
    }

    /**
     * 删除教师信息
     */
    @RequiresPermissions("system:teacher:remove")
    @Log(title = "教师信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(kjcUserService.deleteKjcUserByUserIds(ids));
    }
}
