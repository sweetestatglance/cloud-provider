package com.cnct.controller;

import com.cnct.entity.ModelImg;
import com.cnct.entity.StaticValue;
import com.cnct.service.ImageUploadService;
import com.cnct.util.FileSuffixUtil;
import com.cnct.util.UUIDUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangwenchao
 * 2018/6/15.
 */
@RestController
@RequestMapping("/cnctsys")
@Api("企业建站--图片上传")
public class ImageUploadController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ImageUploadService ius;

    /**
     * 图片、文件上传服务器静态资源目录
     */
    @PostMapping(value = "/imageUpload",consumes = "multipart/*",headers = "content-type=multipart/form-data")
    @ApiOperation("上传图片")
    public Map<String, Object> imageUpload(@ApiParam(value = "上传图片",required = true) MultipartFile file) {
        Map<String, Object> result = new HashMap<>();
        if (file.isEmpty()) {
            result.put("code", 400);
            result.put("msg", "文件为空！");
            return result;
        }
        //图片存放路径
        String imagePath = System.getProperty("user.dir")+"/showimgs/";
        //String imagePath = "G:/CompanyWebsite/temp/";
        //String resPath = StaticValue.PATH + "/temp/";
        String resPath = StaticValue.PATH + "/showimgs/";
        // 获取源文件名
        String fileName = file.getOriginalFilename();
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 文件上传后的路径
        /*if (!(FileSuffixUtil.isImage(suffixName))) {
            result.put("code", 400);
            result.put("msg", "上传文件格式错误！");
            return result;
        }*/
        //上传文件名
        String uploadName = UUIDUtil.newUUID() + suffixName;
        File dest = new File(imagePath + uploadName);
        /*// 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }*/
        try {
            //上传文件至服务器资源文件夹
            file.transferTo(dest);
            ModelImg mi = new ModelImg();
            //mi.setModel_id(Integer.parseInt(mid));
            mi.setPath(resPath + uploadName); //图片路径
            mi.setImgname(uploadName); //上传名
            mi.setOriginname(fileName); //图片原名
            //mi.setPcorph(pcorph); //pc or phone
            Map<String,Object> rs = ius.saveimg(mi);
            ModelImg img = (ModelImg) rs.get("img");
            result.put("code", 200);
            result.put("msg", "上传成功！");
            result.put("data", img);
            result.put("src", img.getPath());
            return result;
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        result.put("code", 400);
        result.put("msg", "上传失败！");
        return result;
    }


    /**
     * 点击取消保存时 对应删除上传的文件
     * @param filenames
     * @return
     */
    /*@RequestMapping("/cancleSave")
    public Map<String,Object> cancleSave(@RequestBody List<String> filenames){
        Map<String,Object> result = new HashMap<>();
        //word、excel 文件存放路径
        String wordPath = System.getProperty("user.dir")+"/src/main/resources/static/fj/";
        //图片存放路径
        String imagePath = System.getProperty("user.dir")+"/src/main/resources/static/images/";
        String delpath = null;
        //后缀
        String suff = null;
        String filename = null;
        if (filenames.size() == 0){
            result.put("code", 200);
            result.put("msg", "无需要删除的上传文件！");
        }else {
            for (int i = 0;i < filenames.size();i ++){
                filename = filenames.get(i);
                suff = filename.substring(filename.lastIndexOf("."));
                //如果是图片
                if (FileSuffixUtil.isImage(suff)){
                    delpath = imagePath + filename;
                    File file = new File(delpath);
                    if (file.exists()){
                        file.delete();
                    }
                }
                //如果是word或excel
                if (FileSuffixUtil.isWordOrExcel(suff)){
                    delpath = wordPath + filename;
                    File file = new File(delpath);
                    if (file.exists()){
                        file.delete();
                    }
                }
            }
            result.put("code",200);
            result.put("msg", "上传文件已删除！");
        }
        return result;
    }*/
}
