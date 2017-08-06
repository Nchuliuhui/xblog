package com.xp.util;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @Author xp
 * @Description MD5加密工具类
 * @Date 2017/8/6 00:11
 */
public class MD5Util {

    public final static String SALT = "xp";
    /**
     * @Description 使用Shiro中的md5加密
     * @param str
     * @param salt
     * @return
     */
    public static String md5(String str,String salt){
        //Md5Hash是Shiro中的一个方法
        return new Md5Hash(str, salt).toString();
    }
}
