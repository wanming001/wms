package com.sxt.bus.controller;

import com.sxt.sys.constants.SYSConstants;
import com.sxt.bus.service.CustomerService;
import com.sxt.sys.utils.DataView;
import com.sxt.sys.utils.ResultObj;
import com.sxt.bus.vo.CustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author WanMing
 * @date 2019/2/20 21:20
 */
@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * 查询客户
     * @param customerVo
     * @return
     */
    @RequestMapping("loadAllCustomer")
    public DataView loadAllCustomer(CustomerVo customerVo){
        return this.customerService.queryAllCustomer(customerVo);
    }


    /**
     * 添加客户
     * @param customerVo
     * @return
     */
    @RequestMapping("addCustomer")
    public ResultObj addCustomer(CustomerVo customerVo){
        ResultObj resultObj = null;
        try {
            this.customerService.addCustomer(customerVo);
            resultObj = new ResultObj(SYSConstants.OPERATE_SUCCESS_CODE,SYSConstants.OPERATE_ADD_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            resultObj = new ResultObj(SYSConstants.OPERATE_FAILURE_CODE,SYSConstants.OPERATE_ADD_FAILURE);
        }

        return resultObj;
    }


    /**
     * 删除客户
     * @param customerVo
     * @return
     */
    @RequestMapping("deleteCustomer")
    public ResultObj deleteCustomer(CustomerVo customerVo){
        ResultObj resultObj = null;
        try {
            this.customerService.deleteCustomer(customerVo.getId());
            resultObj = new ResultObj(SYSConstants.OPERATE_SUCCESS_CODE,SYSConstants.OPERATE_DELETE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            resultObj = new ResultObj(SYSConstants.OPERATE_FAILURE_CODE,SYSConstants.OPERATE_DELETE_FAILURE);
        }

        return resultObj;
    }


    /**
     * 修改客户
     * @param customerVo
     * @return
     */
    @RequestMapping("updateCustomer")
    public ResultObj updateCustomer(CustomerVo customerVo){
        ResultObj resultObj = null;
        try {
            this.customerService.updateCustomer(customerVo);
            resultObj = new ResultObj(SYSConstants.OPERATE_SUCCESS_CODE,SYSConstants.OPERATE_UPDATE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            resultObj = new ResultObj(SYSConstants.OPERATE_FAILURE_CODE,SYSConstants.OPERATE_UPDATE_FAILURE);
        }

        return resultObj;
    }
}
