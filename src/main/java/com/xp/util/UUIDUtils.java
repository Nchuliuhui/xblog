package com.xp.util;

import java.util.UUID;

/**
 * @Author xp
 * @Description 生成随机字符串的工具类 uuid
 * @Date 2017/8/7 08:15
 */
public class UUIDUtils {
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
