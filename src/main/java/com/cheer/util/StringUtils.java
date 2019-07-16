package com.cheer.util;

import java.util.Date;

public class StringUtils {
    public static void main(String[] args) {
        String s = StringUtils.long2String(120);
        System.out.println(s);
    }

    /**
     *
     * @param date long类型的时间
     * @return  返回值是：0年0月0日0时2分0秒
     */
    public static String long2String(long date){
        String year = ((int)date/3600/24/30/12)+"年";
        String mon = ((int)date/3600/24/30%12)+"月";
        String day = ((int)date/3600/24%30)+"日";
        String hr = ((int) date/3600%24)+"时";
        String min = ((int)date/60%60)+"分";
        String sec = ((int)date%60)+"秒";
        return year+mon+day+hr+min+sec;
    }

}
