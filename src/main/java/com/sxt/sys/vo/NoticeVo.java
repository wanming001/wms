package com.sxt.sys.vo;

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
public class NoticeVo extends Notice {

    //当前页
    private Integer page;

    //分页大小
    private Integer limit;

    //开始时间
    private Date startTime;

    //结束时间
    private Date endTime;
}
