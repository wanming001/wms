package com.sxt.sys.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 结果集对象
 * @author WanMing
 * @date 2019/2/3 13:44
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResultObj {

    private Integer code;//code<0操作失败
    private String msg;

}
