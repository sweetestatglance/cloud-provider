package com.cnct.mapper;

import com.cnct.entity.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by wangwenchao
 * 2018/11/14.
 */
@Repository
public interface WxappMapper {

    @Select("select max(model_id) from model")
    @ResultType(Integer.class)
    Integer getMaxId();

    //类型
    @Select("select * from types")
    @ResultType(Types.class)
    List<Types> wnavInita();

    //行业
    List<Ctype> getHangye(PageVo vo);

    //场景（用途）
    List<Ctype> getScene(PageVo vo);

    //风格
    List<Ctype> getStyle(PageVo vo);

    //色系
    @Select("select * from color")
    @ResultType(Colors.class)
    List<Colors> wnavInitb();

    List<ModelBean> queryWxapp(PageVo vo);

    Integer getAllRows(PageVo vo);

    @Insert("insert into model(model_id, mname, author, seoword, describtion, pcurl, pcpath, phoneurl, phpath, tid, hid, sid, aid, cid, keyword, addtime, status, mprice, bid) " +
            "values(#{model_id}, #{mname}, #{author}, #{seoword}, #{describtion}, #{pcurl}, #{pcpath}, #{phoneurl}, #{phpath}, #{tid}, #{hid}, #{sid}, #{aid}, #{cid}," +
            " #{keyword}, str_to_date(#{addtime},'%Y-%m-%d %T'), #{status}, #{mprice}, #{bid})")
    @ResultType(Integer.class)
    Integer addWxapp(ModelBean model);

    Integer updateWxapp(ModelBean model);

    @Delete("delete from model where model_id = #{model_id}")
    @ResultType(Integer.class)
    Integer delWxapp(@Param("model_id") Integer model_id);


}
