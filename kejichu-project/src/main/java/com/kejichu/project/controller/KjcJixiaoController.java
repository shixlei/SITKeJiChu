package com.kejichu.project.controller;

import java.util.ArrayList;
import java.util.List;

import com.kejichu.common.core.text.Convert;
import com.kejichu.common.exception.ServiceException;
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
import com.kejichu.project.domain.KjcJixiao;
import com.kejichu.project.service.IKjcJixiaoService;
import com.kejichu.common.core.controller.BaseController;
import com.kejichu.common.core.domain.AjaxResult;
import com.kejichu.common.utils.poi.ExcelUtil;
import com.kejichu.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 绩效记录Controller
 * 
 * @author sxl
 * @date 2021-10-09
 */
@Controller
@RequestMapping("/project/jixiao")
public class KjcJixiaoController extends BaseController
{
    private String prefix = "project/jixiao";

    @Autowired
    private IKjcJixiaoService kjcJixiaoService;

    @RequiresPermissions("project:jixiao:view")
    @GetMapping()
    public String jixiao()
    {
        return prefix + "/jixiao";
    }

    /**
     * 查询绩效记录列表
     */
    @RequiresPermissions("project:jixiao:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(KjcJixiao kjcJixiao)
    {
        startPage();
        List<KjcJixiao> list = kjcJixiaoService.selectKjcJixiaoList(kjcJixiao);
        return getDataTable(list);
    }

    /**
     * 导出绩效记录列表
     */
    @RequiresPermissions("project:jixiao:export")
    @Log(title = "绩效记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(KjcJixiao kjcJixiao)
    {
        List<KjcJixiao> list = kjcJixiaoService.selectKjcJixiaoList(kjcJixiao);
        ExcelUtil<KjcJixiao> util = new ExcelUtil<KjcJixiao>(KjcJixiao.class);
        return util.exportExcel(list, "绩效记录数据");
    }

    /**
     * 导出绩效记录列表
     */
    @RequiresPermissions("project:jixiao:export")
    @Log(title = "绩效记录", businessType = BusinessType.EXPORT)
    @PostMapping("/exportByIds")
    @ResponseBody
    public AjaxResult exportByIds(KjcJixiao kjcJixiao,String ids)
    {
        String[] strings = {};
        if (StringUtils.isNotBlank(ids)){
            String[] string = Convert.toStrArray(ids);
            if (string.length > 0){
                strings = string;
            }
        }
        List<KjcJixiao> list = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            KjcJixiao jixiao = kjcJixiaoService.selectKjcJixiaoByJixiaoId(Long.valueOf(strings[i]));
            if (jixiao != null){
                 list.add(jixiao);
            }
        }
        ExcelUtil<KjcJixiao> util = new ExcelUtil<KjcJixiao>(KjcJixiao.class);
        return util.exportExcel(list, "绩效记录数据");
    }


    /**
     * 新增绩效记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存绩效记录
     */
    @RequiresPermissions("project:jixiao:add")
    @Log(title = "绩效记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(KjcJixiao kjcJixiao)
    {
        return toAjax(kjcJixiaoService.insertKjcJixiao(kjcJixiao));
    }

    /**
     *导入项目信息列表
     */
    @RequiresPermissions("project:jixiao:import")
    @Log(title = "绩效信息", businessType = BusinessType.IMPORT)
    @PostMapping("/importJixiao")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
//        try {
            ExcelUtil<KjcJixiao> util = new ExcelUtil<KjcJixiao>(KjcJixiao.class);
            List<KjcJixiao> projectKjcJixiaoList = util.importExcel(file.getInputStream());
            String message = kjcJixiaoService.importJixiao(projectKjcJixiaoList, updateSupport, getLoginName());
            return AjaxResult.success(message);
//        }catch (Exception e){
//
//        }
//
//        throw new ServiceException("未添加项目");

    }
    /**
     *导入项目信息模版
     */
    @RequiresPermissions("system:list:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<KjcJixiao> util = new ExcelUtil<KjcJixiao>(KjcJixiao.class);
        return util.importTemplateExcel("项目绩效信息表模版");
    }



    /**
     * 修改绩效记录
     */
    @GetMapping("/edit/{jixiaoId}")
    public String edit(@PathVariable("jixiaoId") Long jixiaoId, ModelMap mmap)
    {
        KjcJixiao kjcJixiao = kjcJixiaoService.selectKjcJixiaoByJixiaoId(jixiaoId);
        mmap.put("kjcJixiao", kjcJixiao);
        return prefix + "/edit";
    }

    /**
     * 修改保存绩效记录
     */
    @RequiresPermissions("project:jixiao:edit")
    @Log(title = "绩效记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(KjcJixiao kjcJixiao)
    {
        return toAjax(kjcJixiaoService.updateKjcJixiao(kjcJixiao));
    }

    /**
     * 删除绩效记录
     */
    @RequiresPermissions("project:jixiao:remove")
    @Log(title = "绩效记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(kjcJixiaoService.deleteKjcJixiaoByJixiaoIds(ids));
    }
}
