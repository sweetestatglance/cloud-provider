package com.cnct.mapper;

import com.cnct.entity.ModelImg;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by wangwenchao
 * 2018/9/30.
 */
@Repository
public interface ImageUploadMapper {

    @Select("select max(id) from modelimg")
    @ResultType(Integer.class)
    Integer getMaxId();

    @Insert("insert into modelimg(id,model_id,imgname,originname,path,pcorph) " +
            "values(#{id},#{model_id},#{imgname},#{originname},#{path},#{pcorph})")
    @ResultType(Integer.class)
    Integer saveimg(ModelImg mi);
}
