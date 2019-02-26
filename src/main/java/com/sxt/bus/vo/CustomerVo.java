package com.sxt.bus.vo;

import com.sxt.bus.domain.Customer;
import com.sxt.sys.domain.Notice;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author WanMing
 * @date 2019/2/20 20:58
 */
@Setter
@Getter
public class CustomerVo extends Customer {

    //当前页
    private Integer page;

    //分页大小
    private Integer limit;


}
