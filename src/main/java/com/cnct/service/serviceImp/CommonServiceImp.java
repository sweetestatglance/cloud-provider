package com.cnct.service.serviceImp;

import com.cnct.entity.*;
import com.cnct.mapper.CommonMapper;
import com.cnct.service.CommonService;
import com.cnct.util.FileSuffixUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangwenchao
 * 2018/11/22.
 */
@Service
public class CommonServiceImp implements CommonService {

    @Autowired
    CommonMapper kym;

    //for h5 and wxapp
    @Override
    public String keyForHfwx(ModelBean model) {
        String keywords = forHfAndWx(model);
        return keywords;
    }

    //为模板准备的key查询
    @Override
    public String KeyForModel(ModelBean model) {
        String keywords = forModel(model);
        return keywords;
    }

    //类型、等下拉选 for model
    @Override
    public Map<String, Object> selecForModel() {
        Map<String, Object> map = new HashMap<>();
        List<Types> type = kym.getTypexs();
        List<Hangye> hangye = kym.getHangyex();
        List<Applications> scene = kym.getScenex();
        List<Styles> style = kym.getStylex();
        List<Colors> color = kym.getColorx();
        map.put("type",type);
        map.put("hangye",hangye);
        map.put("scene",scene);
        map.put("style",style);
        map.put("color",color);
        return map;
    }

    //类型、等下拉选 for h5 wxapp
    @Override
    public Map<String, Object> selecForHfwx() {
        Map<String, Object> map = new HashMap<>();
        List<Types> type = kym.getTypex();
        List<Hangye> hangye = kym.getHangyex();
        List<Applications> scene = kym.getScenex();
        List<Styles> style = kym.getStylex();
        List<Colors> color = kym.getColorx();
        map.put("type",type);
        map.put("hangye",hangye);
        map.put("scene",scene);
        map.put("style",style);
        map.put("color",color);
        return map;
    }

    //删除模板
    @Override
    @Transactional
    public boolean delMdByids(Integer[] ids) {
        Integer flag;
        Integer mid;
        ModelBean delmodel;
        String delname;
        //循环删除数据库数据及图片资源
        try {
            for (int i = 0;i < ids.length;i ++){
                mid = ids[i];
                delmodel = kym.getPicurl(mid);
                delname = FileSuffixUtil.getImgnameByUrl(delmodel.getPcpath());
                flag = kym.delModelByid(mid);
                if (flag != 1){
                    return false;
                }
                //删除图片
                File file = new File(StaticValue.IMGPATH + delname);
                if (file.exists()){
                    file.delete();
                    kym.delByimgname(delname);
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public Integer countVisites(Integer model_id) {
        return kym.countVisites(model_id);
    }


    //-------------------功能函数---------------------

    //model的keyword
    private String forModel(ModelBean model) {
        String keywords = commonKey(model);
        String keytype = null;
        if (model.getTid() != null){
            keytype = kym.tnameFormodel(model.getTid());
            keywords += keytype;
        }
        return keywords;
    }

    //h5 、wxapp的类型keyword
    private String forHfAndWx(ModelBean model) {
        String keywords = commonKey(model);
        String keytype = null;
        if (model.getTid() != null){
            keytype = kym.tnameForHfwx(model.getTid());
            keywords += keytype;
        }
        return keywords;
    }

    //公共keyword获取
    private String commonKey(ModelBean model) {
        String keywords = model.getMname();
        String keyhangye = null;
        String keytapp = null;
        String keytstyle = null;
        String keytcolor = null;
        if (model.getHid() != null){
            keyhangye = kym.getHname(model.getHid());
            keywords += keyhangye;
        }
        if (model.getAid() != null){
            keytapp = kym.getAname(model.getAid());
            keywords += keytapp;
        }
        if (model.getSid() != null){
            keytstyle = kym.getSname(model.getSid());
            keywords += keytstyle;
        }
        if (model.getCid() != null){
            keytcolor = kym.getCname(model.getCid());
            keywords += keytcolor;
        }
        return keywords;
    }
}
