package com.sxt.bus.service;

import com.sxt.bus.vo.InportVo;
import com.sxt.sys.utils.DataView;

/**
 * @author WanMing
 * @date 2019/2/20 21:11
 */

public interface InportService {

    /**
     * 模糊加分页
     * @param inportVo
     * @return
     */
    DataView queryAllInport(InportVo inportVo);

    /**
     * 添加
     * @param inportVo
     */
    void addInport(InportVo inportVo);

    /**
     * 修改
     * @param inportVo
     */
    void updateInport(InportVo inportVo);

    /**
     * 删除
     * @param id
     */
    void deleteInport(Integer id);


}
