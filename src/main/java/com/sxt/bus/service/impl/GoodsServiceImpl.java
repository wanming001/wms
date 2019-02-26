package com.sxt.bus.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.bus.domain.Goods;
import com.sxt.bus.mapper.GoodsMapper;
import com.sxt.bus.service.GoodsService;
import com.sxt.bus.vo.GoodsVo;
import com.sxt.sys.constants.SYSConstants;
import com.sxt.sys.utils.DataView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * @author WanMing
 * @date 2019/2/20 21:14
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;
    /**
     * 模糊加分页
     *
     * @param goodsVo
     * @return
     */
    @Override
    public DataView queryAllGoods(GoodsVo goodsVo) {
        Page<Object> page = PageHelper.startPage(goodsVo.getPage(),goodsVo.getLimit());
        List<GoodsVo> goodss = this.goodsMapper.queryAllGoods(goodsVo);
        //判断该页是否有数据
        if(page.getTotal()!=0 && page.size()==0){
            goodsVo.setPage(goodsVo.getPage()-1);
            Page<Object> page2 = PageHelper.startPage(goodsVo.getPage(),goodsVo.getLimit());
            List<GoodsVo> goodss2 = this.goodsMapper.queryAllGoods(goodsVo);
            return new DataView(SYSConstants.STATUS_CODE,SYSConstants.STATUS_MSG,page2.getTotal(),goodss2);
        }

        return new DataView(SYSConstants.STATUS_CODE,SYSConstants.STATUS_MSG,page.getTotal(),goodss);
    }

    /**
     * 添加
     *
     * @param goodsVo
     */
    @Override
    public void addGoods(GoodsVo goodsVo) {
        this.goodsMapper.insertSelective(goodsVo);
    }

    /**
     * 修改
     *
     * @param goodsVo
     */
    @Override
    public void updateGoods(GoodsVo goodsVo) {
        this.goodsMapper.updateByPrimaryKeySelective(goodsVo);
    }

    /**
     * 删除
     *
     * @param id
     */
    @Override
    public void deleteGoods(Integer id) {
        //删除商品，删除商品图片
        Goods goods = this.goodsMapper.selectByPrimaryKey(id);
        if(!SYSConstants.DEFAULT_IMG.equals(goods.getGoodsimg())) {
            //构建图片地址
            File file = new File(SYSConstants.IMG_ROOT + goods.getGoodsimg());
            file.delete();
        }

        this.goodsMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据供应商id查询
     *
     * @param goodsVo
     * @return
     */
    @Override
    public List<GoodsVo> queryAllGoodsByProviderId(GoodsVo goodsVo) {
        return this.goodsMapper.queryAllGoods(goodsVo);
    }
}
