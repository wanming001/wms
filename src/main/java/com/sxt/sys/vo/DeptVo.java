package com.sxt.sys.vo;

import com.sxt.sys.domain.Dept;
import lombok.Getter;
import lombok.Setter;

/**
 * @author WanMing
 * @date 2019/2/20 15:54
 */

@Getter
@Setter
public class DeptVo extends Dept {

    //当前页
    private Integer page;

    //分页大小
    private Integer limit;
}


