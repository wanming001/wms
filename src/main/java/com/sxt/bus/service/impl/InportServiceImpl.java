package com.sxt.bus.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.bus.domain.Goods;
import com.sxt.bus.mapper.GoodsMapper;
import com.sxt.bus.mapper.InportMapper;
import com.sxt.bus.service.InportService;
import com.sxt.bus.vo.InportVo;
import com.sxt.sys.constants.SYSConstants;
import com.sxt.sys.utils.DataView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WanMing
 * @date 2019/2/20 21:14
 */
@Service
public class InportServiceImpl implements InportService {

    @Autowired
    private InportMapper inportMapper;

    @Autowired
    private GoodsMapper goodsMapper;
    /**
     * 模糊加分页
     *
     * @param inportVo
     * @return
     */
    @Override
    public DataView queryAllInport(InportVo inportVo) {
        Page<Object> page = PageHelper.startPage(inportVo.getPage(),inportVo.getLimit());
        List<InportVo> inports = this.inportMapper.queryAllInport(inportVo);
        //判断该页是否有数据
        if(page.getTotal()!=0 && page.size()==0){
            inportVo.setPage(inportVo.getPage()-1);
            Page<Object> page2 = PageHelper.startPage(inportVo.getPage(),inportVo.getLimit());
            List<InportVo> inports2 = this.inportMapper.queryAllInport(inportVo);
            return new DataView(SYSConstants.STATUS_CODE,SYSConstants.STATUS_MSG,page2.getTotal(),inports2);
        }

        return new DataView(SYSConstants.STATUS_CODE,SYSConstants.STATUS_MSG,page.getTotal(),inports);
    }

    /**
     * 添加
     *
     * @param inportVo
     */
    @Override
    public void addInport(InportVo inportVo) {
        //添加商品的库存
        Goods goods = this.goodsMapper.selectByPrimaryKey(inportVo.getGoodsid());
        goods.setNumber(goods.getNumber()+inportVo.getNumber());
        this.goodsMapper.updateByPrimaryKeySelective(goods);
        this.inportMapper.insertSelective(inportVo);
    }

    /**
     * 修改
     *
     * @param inportVo
     */
    @Override
    public void updateInport(InportVo inportVo) {
        this.inportMapper.updateByPrimaryKeySelective(inportVo);
    }

    /**
     * 删除
     *
     * @param inportVo
     */
    @Override
    public void deleteInport(InportVo inportVo) {
        //先及修改商品库存
        Goods goods = this.goodsMapper.selectByPrimaryKey(inportVo.getGoodsid());
        goods.setNumber(goods.getNumber()-inportVo.getNumber());
        this.goodsMapper.updateByPrimaryKeySelective(goods);
        //再删除
        this.inportMapper.deleteByPrimaryKey(inportVo.getId());
    }
}
