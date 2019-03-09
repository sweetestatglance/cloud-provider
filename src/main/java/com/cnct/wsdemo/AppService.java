package com.cnct.wsdemo;

import com.cnct.entity.ModelBean;
import com.cnct.entity.PageBean;
import com.cnct.entity.PageVo;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by Tiffany on 2019-03-04.
 */

@WebService
public interface AppService {

    @WebMethod
    PageBean<ModelBean> queryModels(PageVo vo);

    @WebMethod
    ModelBean getmodel(Integer model_id);
}
