package com.cnct.mapper;

import com.cnct.entity.Cncter;
import com.cnct.entity.CompanyInfo;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * Created by wangwenchao
 * 2018/9/29.
 */
@Repository
public interface LoginCnctMapper {

    @Select("select count(1) from cncter where username = #{username} and password = #{password}")
    @ResultType(Integer.class)
    Integer loginCnct(Cncter cnc);

}
