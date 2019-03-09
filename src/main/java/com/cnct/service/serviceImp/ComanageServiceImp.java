package com.cnct.service.serviceImp;

import com.alibaba.fastjson.JSONObject;
import com.cnct.entity.*;
import com.cnct.mapper.ComanageMapper;
import com.cnct.service.ComanageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangwenchao
 * 2018/9/29.
 */
@Service
public class ComanageServiceImp implements ComanageService {

    @Autowired
    ComanageMapper cmm;

    /**
     * 新增客户信息
     * @param comp
     * @return
     */
    @Override
    @Transactional
    public Integer addCustomer(CompanyInfo comp) {
        Integer maxid = cmm.getMaxId();
        comp.setComid(maxid + 1);
        comp.setUser(StaticValue.ORIGINUSER);
        comp.setPassword(StaticValue.ORIGINPWD);
        Integer count = cmm.addCustomer(comp);
        Integer nx = 0;
        if (count > 0){
            //复制模板数据
            //显出模板的所有页面对象
            Jsondata html = new Jsondata();
            html = cmm.getModeldata(comp.getModel_id());
            //添加网页数据(初始)
            Integer jmax = cmm.getMaxIdForJsondata();
            html.setId(jmax + 1);
            html.setComid(comp.getComid());
            String jstr = html.getJsonstr();
            if (jstr != null || jstr != ""){
                JSONObject jsonobj = JSONObject.parseObject(jstr);
                JSONObject data = (JSONObject)jsonobj.get("data");
                data.put("id",html.getId());
                data.put("cid",html.getComid());
                html.setJsonstr(jsonobj.toString());
            }
            nx = cmm.addModelJson(html);
        }
        return nx;
    }

    /**
     * 根据comid查询客户
     * @param comid
     * @return
     */
    @Override
    public CompanyInfo getCusById(Integer comid) {
        CompanyInfo cop = new CompanyInfo();
        cop = cmm.getCusById(comid);
        return cop;
    }

    @Override
    @Transactional
    public Integer resetUser(CompanyInfo com) {
        return cmm.resetUser(com);
    }

    @Override
    public PageBean<CompanyInfo> queryComs(PageVo vo) {
        PageBean<CompanyInfo> page = new PageBean<>();
        List<CompanyInfo> list = new ArrayList<>();
        Integer currentPage = vo.getCurrentPage();
        Integer pagesize = vo.getPageSize();
        page.setCurrentPage(currentPage);
        page.setPageSize(pagesize);
        vo.setCurrentPage((currentPage - 1) * pagesize);
        Integer rows = getTotal();
        page.setTotalRows(rows);
        page.setTotalPages((int) Math.ceil((double)rows / (double)pagesize)); //总页数 ceil向上取整
        list = cmm.queryComs(vo);
        page.setList(list);
        return page;
    }

    //================功能函数=============================

    public Integer getTotal() {
        Integer total = cmm.getTotal();
        return total;
    }
}
