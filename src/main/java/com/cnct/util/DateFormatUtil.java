package com.cnct.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wangwenchao
 * 2018/10/8.
 */
public class DateFormatUtil {

    private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String date_to_str(Date date){
        String str = "";
        str = df.format(date);
        return str;
    }
}
