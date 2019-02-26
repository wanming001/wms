package com.sxt.bus.service;

import com.sxt.sys.utils.DataView;
import com.sxt.bus.vo.CustomerVo;

/**
 * @author WanMing
 * @date 2019/2/20 21:11
 */

public interface CustomerService {

    /**
     * 模糊加分页
     * @param customerVo
     * @return
     */
    DataView queryAllCustomer(CustomerVo customerVo);

    /**
     * 添加
     * @param customerVo
     */
    void addCustomer(CustomerVo customerVo);

    /**
     * 修改
     * @param customerVo
     */
    void updateCustomer(CustomerVo customerVo);

    /**
     * 删除
     * @param id
     */
    void deleteCustomer(Integer id);


}
