package com.cnct.wsdemo;

import com.cnct.entity.ModelBean;
import com.cnct.entity.PageBean;
import com.cnct.entity.PageVo;
import com.cnct.mapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tiffany on 2019-03-04.
 */

@WebService(serviceName = "modelService",
            targetNamespace = "http://wsdemo.cnct.com",
            endpointInterface = "com.cnct.wsdemo.AppService")
@Service
public class AppServiceImp implements AppService {

    @Autowired
    ModelMapper moma;

    @Override
    public PageBean<ModelBean> queryModels(PageVo vo) {
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
        list = moma.queryModels(vo);
        pagelist.setList(list); //查询的该页数据
        return pagelist;
    }

    //--------------restful地址----

    @Override
    public ModelBean getmodel(Integer model_id){
        ModelBean m = moma.getmodelbyid(model_id);
        return m;
    }


    //================功能函数=============================

    //查总数
    private Integer getAllRows(PageVo vo){
        Integer rows = moma.getAllRows(vo);
        return rows;
    }
}
