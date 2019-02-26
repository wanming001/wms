package com.sxt.sys.utils;

import java.util.UUID;

/**
 * UUID大写生成器
 * @author WanMing
 * @date 2019/2/24 20:39
 */

public class UUIDSalt {

    public static String getSalt(){
        return UUID.randomUUID().toString().replace("-","").toUpperCase();
    }
}
