package com.sxt.bus.vo;

import com.sxt.bus.domain.Goods;
import lombok.Getter;
import lombok.Setter;

/**
 * @author WanMing
 * @date 2019/2/20 20:58
 */
@Setter
@Getter
public class GoodsVo extends Goods {

    //当前页
    private Integer page;

    //分页大小
    private Integer limit;

    //供应商
    private String providerName;

}
