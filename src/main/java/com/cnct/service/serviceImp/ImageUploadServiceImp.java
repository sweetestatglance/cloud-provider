package com.cnct.service.serviceImp;

import com.cnct.entity.ModelImg;
import com.cnct.mapper.ImageUploadMapper;
import com.cnct.service.ImageUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangwenchao
 * 2018/9/30.
 */
@Service
public class ImageUploadServiceImp implements ImageUploadService {

    @Autowired
    ImageUploadMapper ium;

    /**
     * 图片、文件上传服务器静态资源目录
     * @param mi
     * @return
     */
    @Override
    @Transactional
    public Map<String, Object> saveimg(ModelImg mi) {
        Map<String, Object> se = new HashMap<>();
        Integer maxid = ium.getMaxId();
        mi.setId(maxid + 1);
        Integer count = ium.saveimg(mi);
        se.put("count",count);
        se.put("img",mi);
        return se;
    }
}
