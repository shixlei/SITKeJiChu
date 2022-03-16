package com.kejichu.project.controller;

import java.io.*;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.kejichu.common.config.RuoYiConfig;
import com.kejichu.common.constant.Constants;
import com.kejichu.common.core.text.Convert;
import com.kejichu.common.utils.ShiroUtils;
import com.kejichu.common.utils.file.FileUploadUtils;
import com.kejichu.common.utils.file.FileUtils;
import com.kejichu.common.utils.uuid.IdUtils;
import com.kejichu.project.domain.KjcProject;
import com.kejichu.project.mapper.KjcProjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.kejichu.common.annotation.Log;
import com.kejichu.common.enums.BusinessType;
import com.kejichu.project.domain.KjcProjectFile;
import com.kejichu.project.service.IKjcProjectFileService;
import com.kejichu.common.core.controller.BaseController;
import com.kejichu.common.core.domain.AjaxResult;
import com.kejichu.common.utils.poi.ExcelUtil;
import com.kejichu.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 项目文件Controller
 * 
 * @author tcl
 * @date 2021-12-16
 */
@Controller
@RequestMapping("/project/file")
public class KjcProjectFileController extends BaseController
{
    private String prefix = "project/file";

    @Autowired
    private IKjcProjectFileService kjcProjectFileService;
    @Autowired
    private KjcProjectMapper projectMapper;

    @RequiresPermissions("project:file:view")
    @GetMapping()
    public String file(String projectBianhao)
    {
        return prefix + "/file";
    }

    /**
     * 查询项目文件列表
     */
    @RequiresPermissions("project:file:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(KjcProjectFile kjcProjectFile)
    {
        startPage();
        List<KjcProjectFile> list = kjcProjectFileService.selectKjcProjectFileList(kjcProjectFile);
        return getDataTable(list);
    }

    /**
     * 导出项目文件列表
     */
    @RequiresPermissions("project:file:export")
    @Log(title = "项目文件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(KjcProjectFile kjcProjectFile)
    {
        List<KjcProjectFile> list = kjcProjectFileService.selectKjcProjectFileList(kjcProjectFile);
        ExcelUtil<KjcProjectFile> util = new ExcelUtil<KjcProjectFile>(KjcProjectFile.class);
        return util.exportExcel(list, "项目文件数据");
    }

    /**
     * 新增项目文件
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存项目文件
     */
    @RequiresPermissions("project:file:add")
    @Log(title = "项目文件", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
/*    public AjaxResult addSave( KjcProjectFile kjcProjectFile) {
            return toAjax(kjcProjectFileService.insertKjcProjectFile(kjcProjectFile));
    }*/
   public AjaxResult addSave(@RequestParam("file") MultipartFile file , KjcProjectFile kjcProjectFile) throws IOException {
        kjcProjectFile.setUploadtime(new Date());
        kjcProjectFile.setUploaduser(ShiroUtils.getLoginName());
        String filePath = RuoYiConfig.getUploadPath();
        String filePathDetail = Constants.RESOURCE_PREFIX + "/" + kjcProjectFile.getProjectBianhao() + "/" + IdUtils.randomUUID() + file.getOriginalFilename();
        File f = new File(filePath + filePathDetail);
        f.getParentFile().mkdirs();
        file.transferTo(f);
        kjcProjectFile.setFilePath(filePathDetail);
        return toAjax(kjcProjectFileService.insertKjcProjectFile(kjcProjectFile));
    }

    //上传 信息 打印调试


    /**
     * 修改项目文件
     */
    @GetMapping("/edit/{fileId}")
    public String edit(@PathVariable("fileId") Long fileId, ModelMap mmap)
    {
        KjcProjectFile kjcProjectFile = kjcProjectFileService.selectKjcProjectFileByFileId(fileId);
        mmap.put("kjcProjectFile", kjcProjectFile);
        return prefix + "/edit";
    }

    /**
     * 修改保存项目文件
     */
    @RequiresPermissions("project:file:edit")
    @Log(title = "项目文件", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MultipartFile file, KjcProjectFile kjcProjectFile) throws IOException {
        if (file != null){
            //修改前先删除文件
            String filePath = RuoYiConfig.getUploadPath();
            File delFile = new File(filePath + kjcProjectFile.getFilePath());
            try {
                delFile.delete();
            } catch (Exception e){

            }

            kjcProjectFile.setUploadtime(new Date());
            kjcProjectFile.setUploaduser(ShiroUtils.getLoginName());

            String filePathDetail = Constants.RESOURCE_PREFIX + "/" + kjcProjectFile.getProjectBianhao() + "/" + IdUtils.randomUUID() + file.getOriginalFilename();
            File f = new File(filePath + filePathDetail);
            f.getParentFile().mkdirs();
            file.transferTo(f);
            kjcProjectFile.setFilePath(filePathDetail);
        }

        return toAjax(kjcProjectFileService.updateKjcProjectFile(kjcProjectFile));
    }

    /**
     * 删除项目文件
     */
    @RequiresPermissions("project:file:remove")
    @Log(title = "项目文件", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        //先删除文件
        String filePath = RuoYiConfig.getUploadPath();
        String[] strings = Convert.toStrArray(ids);
        for (String string : strings) {
            KjcProjectFile kjcProjectFile = kjcProjectFileService.selectKjcProjectFileByFileId(Long.parseLong(string));
            if (kjcProjectFile != null){
                File delFile = new File(filePath + kjcProjectFile.getFilePath());
                try {
                    delFile.delete();
                } catch (Exception e){

                }
            }
        }
        return toAjax(kjcProjectFileService.deleteKjcProjectFileByFileIds(ids));
    }

    @Log(title = "项目编号是否存在", businessType = BusinessType.OTHER)
    @GetMapping( "/judgeExist")
    @ResponseBody
    public AjaxResult judgeExist(String no)
    {
        if (StringUtils.isBlank(no)){
            return toAjax(false);
        }
        KjcProject kjcProject = projectMapper.selectKjcProjectByprojectBianhao(no);
        return toAjax(kjcProject != null);
    }


    /**
     * 导出项目文件列表
     */
    @RequiresPermissions("project:file:export")
    @Log(title = "项目文件", businessType = BusinessType.EXPORT)
    @GetMapping("/exportExcel")
    //@ResponseBody
    public void export(String ids, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String[] strings = Convert.toStrArray(ids);
        String filePath = RuoYiConfig.getUploadPath();
        File[] srcFiles = new File[strings.length];

        List<KjcProjectFile> kjcProjectFiles = new ArrayList<>();

        for (int i = 0; i < strings.length; i++) {
            KjcProjectFile kjcProjectFile = kjcProjectFileService.selectKjcProjectFileByFileId(Long.parseLong(strings[i]));
            kjcProjectFiles.add(kjcProjectFile);
            srcFiles[i] = new File(filePath + kjcProjectFile.getFilePath());
        }

        String fileName = System.currentTimeMillis() + ".zip";
        String zipFilePath = RuoYiConfig.getDownloadPath() + "/" + fileName;
        File zipFile = new File(zipFilePath);
        zipFiles(srcFiles, zipFile, kjcProjectFiles);


        //设置文件MIME类型
        response.setContentType("application/octet-stream");
        //设置Content-Disposition
        response.setHeader("Content-Disposition", "attachment;filename="+fileName);
        //读取目标文件，通过response将目标文件写到客户端
        //System.out.println(fullFileName);
        //读取文件
        InputStream in = new FileInputStream(zipFile);
        OutputStream out = response.getOutputStream();

        //写文件
        int b;
        while((b=in.read())!= -1)
        {
            out.write(b);
        }

        in.close();
        out.close();
        FileUtils.deleteFile(zipFilePath);

        //return AjaxResult.success(fileName);
    }


    public static void zipFiles(File[] srcFiles, File zipFile, List<KjcProjectFile> KjcProjectFiles) {
        // 判断压缩后的文件存在不，不存在则创建
        if (!zipFile.exists()) {
            try {
                zipFile.getParentFile().mkdirs();
                zipFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // 创建 FileOutputStream 对象
        FileOutputStream fileOutputStream = null;
        // 创建 ZipOutputStream
        ZipOutputStream zipOutputStream = null;
        // 创建 FileInputStream 对象
        FileInputStream fileInputStream = null;

        try {
            // 实例化 FileOutputStream 对象
            fileOutputStream = new FileOutputStream(zipFile);
            // 实例化 ZipOutputStream 对象
            zipOutputStream = new ZipOutputStream(fileOutputStream);
            // 创建 ZipEntry 对象
            ZipEntry zipEntry = null;
            // 遍历源文件数组
            for (int i = 0; i < srcFiles.length; i++) {
                // 将源文件数组中的当前文件读入 FileInputStream 流中
                fileInputStream = new FileInputStream(srcFiles[i]);
                // 实例化 ZipEntry 对象，源文件数组中的当前文件
                //zipEntry = new ZipEntry(srcFiles[i].getName());
                //指定导出的文件名字
                zipEntry = new ZipEntry(KjcProjectFiles.get(i).getFileName() + srcFiles[i].getName().substring(srcFiles[i].getName().lastIndexOf(".")));
                zipOutputStream.putNextEntry(zipEntry);
                // 该变量记录每次真正读的字节个数
                int len;
                // 定义每次读取的字节数组
                byte[] buffer = new byte[1024];
                while ((len = fileInputStream.read(buffer)) > 0) {
                    zipOutputStream.write(buffer, 0, len);
                }
            }
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            fileInputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
