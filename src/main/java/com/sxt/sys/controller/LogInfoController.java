package com.sxt.sys.controller;

import com.sxt.sys.constants.SYSConstants;
import com.sxt.sys.service.LogInfoService;
import com.sxt.sys.utils.DataView;
import com.sxt.sys.utils.ResultObj;
import com.sxt.sys.vo.LogInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WanMing
 * @date 2019/2/20 16:28
 */

@RestController
@RequestMapping("logInfo")
public class LogInfoController {

    @Autowired
    private LogInfoService logInfoService;


    /**
     * 查询
     * @param logInfoVo
     * @return
     */
    @RequestMapping("loadAllLogInfo")
    public DataView loadAllLogInfo(LogInfoVo logInfoVo){
        return this.logInfoService.queryAllLogInfo(logInfoVo);
    }

    /**
     * 删除
     * @param logInfoVo
     * @return
     */
    @RequestMapping("deleteLogInfo")
    public ResultObj addLogInfo(LogInfoVo logInfoVo){
        ResultObj resultObj = null;
        try {
            this.logInfoService.deleteLogInfo(logInfoVo.getId());
            resultObj = new ResultObj(SYSConstants.OPERATE_SUCCESS_CODE,SYSConstants.OPERATE_DELETE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            resultObj = new ResultObj(SYSConstants.OPERATE_FAILURE_CODE,SYSConstants.OPERATE_DELETE_FAILURE);
        }

        return resultObj;
    }
}
