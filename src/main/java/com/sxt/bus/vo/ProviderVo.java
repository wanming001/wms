package com.sxt.bus.vo;

import com.sxt.bus.domain.Provider;
import lombok.Getter;
import lombok.Setter;

/**
 * @author WanMing
 * @date 2019/2/20 20:58
 */
@Setter
@Getter
public class ProviderVo extends Provider {

    //当前页
    private Integer page;

    //分页大小
    private Integer limit;

}
