package com.sxt.bus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 处理页面的跳转,
 * @author WanMing
 * @date 2019/2/20 15:28
 */

@Controller
@RequestMapping("bus")
public class BusController {

    /**
     * 跳转到客户页面
     */
    @RequestMapping("toCustomerManager")
    public String  toCustomerManager(){
        return "business/customerManager";
    }

    /**
     * 跳转到供应商页面
     */
    @RequestMapping("toProviderManager")
    public String  toProviderManager(){
        return "business/providerManager";
    }

    /**
     * 跳转到商品页面
     */
    @RequestMapping("toGoodsManager")
    public String  toGoodsManager(){
        return "business/goodsManager";
    }

    /**
     * 跳转到进货单页面
     */
    @RequestMapping("toInportManager")
    public String  toInportManager(){
        return "business/inportManager";
    }
}
