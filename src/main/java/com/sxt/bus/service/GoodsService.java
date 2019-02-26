package com.sxt.bus.service;

import com.sxt.bus.domain.Goods;
import com.sxt.bus.vo.GoodsVo;
import com.sxt.sys.utils.DataView;

import java.util.List;

/**
 * @author WanMing
 * @date 2019/2/20 21:11
 */

public interface GoodsService {

    /**
     * 模糊加分页
     * @param goodsVo
     * @return
     */
    DataView queryAllGoods(GoodsVo goodsVo);

    /**
     * 添加
     * @param goodsVo
     */
    void addGoods(GoodsVo goodsVo);

    /**
     * 修改
     * @param goodsVo
     */
    void updateGoods(GoodsVo goodsVo);

    /**
     * 删除
     * @param id
     */
    void deleteGoods(Integer id);

    /**
     * 根据供应商id查询
     * @param goodsVo
     * @return
     */
    List<GoodsVo> queryAllGoodsByProviderId(GoodsVo goodsVo);
}
