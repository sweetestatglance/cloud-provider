package com.cnct.util;

/**
 * Created by wangwenchao
 * 2018/9/25.
 */
public class FileSuffixUtil {

    /**
     * 判断是否为图片
     * @param suffixName
     * @return
     */
    public static boolean isImage(String suffixName) {
        if (".jpg".equals(suffixName) || ".png".equals(suffixName) || ".jpeg".equals(suffixName)
                || ".gif".equals(suffixName) || ".bmp".equals(suffixName) || ".tiff".equals(suffixName)
                || ".webp".equals(suffixName) || ".pcx".equals(suffixName) || ".tga".equals(suffixName)
                ){
            return true;
        }
        return false;
    }

    /**
     * 判断是否是word、excel
     * @param suffixName
     * @return
     */
    public static boolean isWordOrExcel(String suffixName){
        if (".doc".equals(suffixName) || ".docx".equals(suffixName)
                || ".xls".equals(suffixName) || ".xlsx ".equals(suffixName)
                ){
            return true;
        }
        return false;
    }

    public static String getImgnameByUrl(String url){
        String imgname;
        imgname = (url.substring(url.lastIndexOf("/"))).replace("/","").trim();
        return imgname;
    }
}
