package com.cnct.service.serviceImp;

import com.cnct.entity.*;
import com.cnct.mapper.WxappMapper;
import com.cnct.service.CommonService;
import com.cnct.service.WxappService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangwenchao
 * 2018/11/14.
 */
@Service
public class WxappServiceImp implements WxappService {

    @Autowired
    WxappMapper wam;

    @Autowired
    CommonService common;

    //初始化导航菜单
    @Override
    public Map<String,Object> wnavInit() {
        Map<String,Object> nav = new HashMap<>();
        List<Map<String,Object>> nextall = new ArrayList();
        List<Types> type = wam.wnavInita(); //类型
        List<Colors> color = wam.wnavInitb(); //色系
        nav.put("type",type);
        nav.put("color",color);
        nav.put("nextall",nextall);
        return nav;
    }

    /**
     * 分页查询
     * @param vo
     * @return
     */
    @Override
    public PageBean<ModelBean> queryWxapp(PageVo vo) {
        PageBean<ModelBean> pagelist = new PageBean<ModelBean>();
        pagelist.setCurrentPage(vo.getCurrentPage()); //当前页
        List<ModelBean> list = new ArrayList<>();
        int pagesize = vo.getPageSize();
        int serpoint = (vo.getCurrentPage() - 1) * pagesize; //转成分页查询下标
        vo.setCurrentPage(serpoint);
        pagelist.setPageSize(vo.getPageSize()); //每页大小
        int rows = getAllRows(vo);
        pagelist.setTotalRows(rows); //查询总数
        pagelist.setTotalPages((int) Math.ceil((double)rows / (double)pagesize)); //总页数 ceil向上取整
        list = wam.queryWxapp(vo);
        pagelist.setList(list); //查询的该页数据
        return pagelist;
    }

    /**
     * 数据持久化--添加微传单
     * @param model
     * @return
     */
    @Override
    @Transactional
    public Integer addWxapp(ModelBean model) {
        Integer id = wam.getMaxId();
        model.setModel_id(id + 1);
        String keyw = common.keyForHfwx(model);
        model.setKeyword(keyw);
        return wam.addWxapp(model);
    }

    @Override
    @Transactional
    public Integer updateWxapp(ModelBean model) {
        return wam.updateWxapp(model);
    }

    @Override
    public Integer delWxapp(Integer model_id) {
        return wam.delWxapp(model_id);
    }

    //动态查询导航
    @Override
    public Map<String, Object> getWxnav(PageVo vo) {
        Map<String,Object> nav = wnavInit(); //类型，色系
        List<Map<String,Object>> nextall = new ArrayList();
        if (vo.getTid() != null){ //如果类型tid不为null 需要去查联动级导航 为null的话说明是初始化导航请求
            //行业
            List<Ctype> hangye = wam.getHangye(vo);
            if (hangye.size() > 0){
                Map<String,Object> maph = new HashMap<>();
                /*Ctype zeroh = new Ctype(2,null,"全部");
                hangye.add(0,zeroh);*/
                maph.put("name","行业");
                maph.put("list",hangye);
                nextall.add(maph);
            }
            //场景（用途）
            List<Ctype> scene = wam.getScene(vo);
            if (scene.size() > 0){
                Map<String,Object> mapa = new HashMap<>();
                /*Ctype zeroa = new Ctype(3,null,"全部");
                scene.add(0,zeroa);*/
                mapa.put("name","场景");
                mapa.put("list",scene);
                nextall.add(mapa);
            }
            //风格
            List<Ctype> style = wam.getStyle(vo);
            if (style.size() > 0){
                Map<String,Object> maps = new HashMap<>();
                /*Ctype zeros = new Ctype(4,null,"全部");
                style.add(0,zeros);*/
                maps.put("name","风格");
                maps.put("list",style);
                nextall.add(maps);
            }
        }
        nav.put("nextall",nextall);
        return nav;
    }

    //================功能函数=============================


    //查总数
    private Integer getAllRows(PageVo vo){
        Integer rows = wam.getAllRows(vo);
        return rows;
    }

}
