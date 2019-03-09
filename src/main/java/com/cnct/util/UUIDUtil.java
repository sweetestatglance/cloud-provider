package com.cnct.util;


import java.util.UUID;

/**
 * Created by Tiffany on 2018-09-25.
 */
public class UUIDUtil {

    public static String newUUID(){
        String str = UUID.randomUUID().toString();
        return str.replaceAll("\\-","");
    }

}
