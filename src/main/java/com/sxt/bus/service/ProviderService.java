package com.sxt.bus.service;

import com.sxt.bus.domain.Goods;
import com.sxt.bus.domain.Provider;
import com.sxt.bus.vo.GoodsVo;
import com.sxt.bus.vo.ProviderVo;
import com.sxt.sys.utils.DataView;

import java.util.List;

/**
 * @author WanMing
 * @date 2019/2/20 21:11
 */

public interface ProviderService {

    /**
     * 模糊加分页
     *
     * @param providerVo
     * @return
     */
    DataView queryAllProvider(ProviderVo providerVo);

    /**
     * 添加
     *
     * @param providerVo
     */
    void addProvider(ProviderVo providerVo);

    /**
     * 修改
     *
     * @param providerVo
     */
    void updateProvider(ProviderVo providerVo);

    /**
     * 删除
     *
     * @param id
     */
    void deleteProvider(Integer id);

    /**
     * 查询所有的商家集合
     *
     * @return
     */
    List<Provider> queryAllProvider(Provider provider);
}


