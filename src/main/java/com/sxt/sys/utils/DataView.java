package com.sxt.sys.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 数据视图
 * @author WanMing
 * @date 2019/2/3 19:40
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DataView {

    private Integer code;
    private String msg;
    private Long count;
    private List<?> data;




}
