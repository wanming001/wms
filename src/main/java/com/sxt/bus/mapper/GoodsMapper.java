package com.sxt.bus.mapper;


import com.sxt.bus.domain.Goods;
import com.sxt.bus.vo.GoodsVo;

import java.util.List;

public interface GoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    //查询
    List<GoodsVo> queryAllGoods(Goods goods);
}