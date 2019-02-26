package com.sxt.sys.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 自定义异常类
 * @author WanMing
 * @date 2019/2/21 19:25
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MyException extends RuntimeException {

    private String code;
    private String msg;

}
