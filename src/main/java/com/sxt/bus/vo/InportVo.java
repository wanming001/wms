package com.sxt.bus.vo;

import com.sxt.bus.domain.Inport;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author WanMing
 * @date 2019/2/20 20:58
 */
@Setter
@Getter
public class InportVo extends Inport {

    //当前页
    private Integer page;

    //分页大小
    private Integer limit;

    //商家名称
    private String providername;

    //商品名称
    private String goodsname;

    //开始时间
    private Date startTime;

    //结束时间
    private Date endTime;

}
