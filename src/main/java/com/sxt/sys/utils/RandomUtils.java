package com.sxt.sys.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * 随机工具类
 * @author WanMing
 * @date 2019/1/9 21:33
 */

public class RandomUtils {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    private static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
    private static Random random = new Random();

    /**
     * 根据旧的文件转换成当前时间加上四位随机数.后缀名
     * @param oldName
     * @return
     */
    public static String createFileNameUseTime(String oldName){
        //获取旧名称的后缀
        String suffix = oldName.substring(oldName.lastIndexOf("."),oldName.length());
        //生成当前时间
        String nowTime = sdf.format(new Date());
        //获得四位随机数
        int num = random.nextInt(9000)+1000;
        return nowTime+num+suffix;
    }

    /**
     * 通过随机的UUID修改文件ming
     * @param oldName
     * @return
     */
    public static String createFileNameUseUUID(String oldName){
        //获取旧名称的后缀
        String suffix = oldName.substring(oldName.lastIndexOf("."),oldName.length());
        //获取UUID,去掉中间的—然后转大写
        String uuid = UUID.randomUUID().toString().replace("-","").toUpperCase();
        return uuid+suffix;
    }

    /**
     * 获取日期的年月日转String,例如20190109
     * @return
     */
    public static String createDirUseTime(){
        return sdf1.format(new Date());
    }
}
