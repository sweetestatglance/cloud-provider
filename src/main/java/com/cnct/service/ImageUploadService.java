package com.cnct.service;

import com.cnct.entity.ModelImg;

import java.util.Map;

/**
 * Created by wangwenchao
 * 2018/9/30.
 */
public interface ImageUploadService {

    /**
     * 图片、文件上传服务器静态资源目录
     * @return
     */
    Map<String,Object> saveimg(ModelImg mi);
}
