package com.sxt.bus.controller;

import com.sxt.bus.domain.Provider;
import com.sxt.bus.service.GoodsService;
import com.sxt.bus.service.ProviderService;
import com.sxt.bus.vo.GoodsVo;
import com.sxt.sys.constants.SYSConstants;
import com.sxt.sys.utils.DataView;
import com.sxt.sys.utils.ResultObj;
import com.sxt.sys.utils.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/**
 * @author WanMing
 * @date 2019/2/20 21:20
 */
@RestController
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private ProviderService providerService;

    /**
     * 查询商品
     * @param goodsVo
     * @return
     */
    @RequestMapping("loadAllGoods")
    public DataView loadAllGoods(GoodsVo goodsVo){
        return this.goodsService.queryAllGoods(goodsVo);
    }


    /**
     * 添加商品
     * @param goodsVo
     * @return
     */
    @RequestMapping("addGoods")
    public ResultObj addGoods(GoodsVo goodsVo){
        ResultObj resultObj = null;
        try {
            this.goodsService.addGoods(goodsVo);
            resultObj = new ResultObj(SYSConstants.OPERATE_SUCCESS_CODE,SYSConstants.OPERATE_ADD_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            resultObj = new ResultObj(SYSConstants.OPERATE_FAILURE_CODE,SYSConstants.OPERATE_ADD_FAILURE);
        }

        return resultObj;
    }


    /**
     * 删除商品
     * @param goodsVo
     * @return
     */
    @RequestMapping("deleteGoods")
    public ResultObj deleteGoods(GoodsVo goodsVo){
        ResultObj resultObj = null;
        try {
            this.goodsService.deleteGoods(goodsVo.getId());
            resultObj = new ResultObj(SYSConstants.OPERATE_SUCCESS_CODE,SYSConstants.OPERATE_DELETE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            resultObj = new ResultObj(SYSConstants.OPERATE_FAILURE_CODE,SYSConstants.OPERATE_DELETE_FAILURE);
        }

        return resultObj;
    }


    /**
     * 修改商品
     * @param goodsVo
     * @return
     */
    @RequestMapping("updateGoods")
    public ResultObj updateGoods(GoodsVo goodsVo){
        ResultObj resultObj = null;
        try {
            this.goodsService.updateGoods(goodsVo);
            resultObj = new ResultObj(SYSConstants.OPERATE_SUCCESS_CODE,SYSConstants.OPERATE_UPDATE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            resultObj = new ResultObj(SYSConstants.OPERATE_FAILURE_CODE,SYSConstants.OPERATE_UPDATE_FAILURE);
        }

        return resultObj;
    }

    /**
     * 加载商品管理左边的供应商的树
     * @return
     */
    @RequestMapping("loadGoodsManagerLeftTreeJson")
    public List<TreeNode> loadGoodsManagerLeftTreeJson(Provider provider, Model model){
        List<TreeNode> nodes = new ArrayList<>();
        provider.setAvailable(SYSConstants.SYS_AVAILABLE_TRUE);
        List<Provider> providers = this.providerService.queryAllProvider(provider);
        for (Provider pro : providers) {
            nodes.add(new TreeNode(pro.getId(),pro.getProvidername(),true));
        }
        model.addAttribute("prods",nodes);

        return nodes;

    }
}
