package com.xp.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xp on 2017/8/7.
 */
public class DateUtil {


    public static String dateToString2(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMDDHHMMSS");
        return sdf.format(date);
    }
}
