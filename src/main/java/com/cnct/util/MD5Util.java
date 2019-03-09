package com.cnct.util;


import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by wangwenchao
 * 2018/9/25.
 */
public class MD5Util {

    public static String MD5(String str){
        String md5Str = null;
        md5Str = DigestUtils.md5Hex(str);
        return md5Str;
    }
}
