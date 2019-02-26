package com.sxt.sys.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @author WanMing
 * @date 2019/2/24 20:46
 */

public class MD5Utils {



    /**
     * md5加密处理密码
     * @param source（原密码）
     * @param salt（加密用到的盐）
     * @param hashInterations（加密的次数）
     * @return
     */
    public static String getMD5(String source,String salt,Integer hashInterations){
        return new Md5Hash(source,salt,hashInterations).toString();
    }


}
