package com.sxt.bus.controller;

import com.sxt.bus.service.ProviderService;
import com.sxt.bus.vo.ProviderVo;
import com.sxt.sys.constants.SYSConstants;
import com.sxt.sys.utils.DataView;
import com.sxt.sys.utils.ResultObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author WanMing
 * @date 2019/2/20 21:20
 */
@RestController
@RequestMapping("provider")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    /**
     * 查询供应商
     * @param providerVo
     * @return
     */
    @RequestMapping("loadAllProvider")
    public DataView loadAllProvider(ProviderVo providerVo){
        return this.providerService.queryAllProvider(providerVo);
    }


    /**
     * 添加供应商
     * @param providerVo
     * @return
     */
    @RequestMapping("addProvider")
    public ResultObj addProvider(ProviderVo providerVo){
        ResultObj resultObj = null;
        try {
            this.providerService.addProvider(providerVo);
            resultObj = new ResultObj(SYSConstants.OPERATE_SUCCESS_CODE,SYSConstants.OPERATE_ADD_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            resultObj = new ResultObj(SYSConstants.OPERATE_FAILURE_CODE,SYSConstants.OPERATE_ADD_FAILURE);
        }

        return resultObj;
    }


    /**
     * 删除供应商
     * @param providerVo
     * @return
     */
    @RequestMapping("deleteProvider")
    public ResultObj deleteProvider(ProviderVo providerVo){
        ResultObj resultObj = null;
        try {
            this.providerService.deleteProvider(providerVo.getId());
            resultObj = new ResultObj(SYSConstants.OPERATE_SUCCESS_CODE,SYSConstants.OPERATE_DELETE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            resultObj = new ResultObj(SYSConstants.OPERATE_FAILURE_CODE,SYSConstants.OPERATE_DELETE_FAILURE);
        }

        return resultObj;
    }


    /**
     * 修改供应商
     * @param providerVo
     * @return
     */
    @RequestMapping("updateProvider")
    public ResultObj updateProvider(ProviderVo providerVo){
        ResultObj resultObj = null;
        try {
            this.providerService.updateProvider(providerVo);
            resultObj = new ResultObj(SYSConstants.OPERATE_SUCCESS_CODE,SYSConstants.OPERATE_UPDATE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            resultObj = new ResultObj(SYSConstants.OPERATE_FAILURE_CODE,SYSConstants.OPERATE_UPDATE_FAILURE);
        }

        return resultObj;
    }
}
