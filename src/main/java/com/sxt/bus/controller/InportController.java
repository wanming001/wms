package com.sxt.bus.controller;

import com.sxt.bus.domain.Provider;
import com.sxt.bus.service.InportService;
import com.sxt.bus.service.ProviderService;
import com.sxt.bus.vo.InportVo;
import com.sxt.sys.constants.SYSConstants;
import com.sxt.sys.utils.DataView;
import com.sxt.sys.utils.ResultObj;
import com.sxt.sys.utils.TreeNode;
import com.sxt.sys.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author WanMing
 * @date 2019/2/20 21:20
 */
@RestController
@RequestMapping("inport")
public class InportController {

    @Autowired
    private InportService inportService;


    /**
     * 查询进货单
     * @param inportVo
     * @return
     */
    @RequestMapping("loadAllInport")
    public DataView loadAllInport(InportVo inportVo){
        return this.inportService.queryAllInport(inportVo);
    }


    /**
     * 添加进货单
     * @param inportVo
     * @return
     */
    @RequestMapping("addInport")
    public ResultObj addInport(InportVo inportVo){
        inportVo.setInporttime(new Date());
        inportVo.setOperateperson(WebUtils.getCurrentUser().getLoginname());
        ResultObj resultObj = null;
        try {
            this.inportService.addInport(inportVo);
            resultObj = new ResultObj(SYSConstants.OPERATE_SUCCESS_CODE,SYSConstants.OPERATE_ADD_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            resultObj = new ResultObj(SYSConstants.OPERATE_FAILURE_CODE,SYSConstants.OPERATE_ADD_FAILURE);
        }

        return resultObj;
    }


    /**
     * 删除进货单
     * @param inportVo
     * @return
     */
    @RequestMapping("deleteInport")
    public ResultObj deleteInport(InportVo inportVo){
        ResultObj resultObj = null;
        try {
            this.inportService.deleteInport(inportVo);
            resultObj = new ResultObj(SYSConstants.OPERATE_SUCCESS_CODE,SYSConstants.OPERATE_DELETE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            resultObj = new ResultObj(SYSConstants.OPERATE_FAILURE_CODE,SYSConstants.OPERATE_DELETE_FAILURE);
        }

        return resultObj;
    }




}
