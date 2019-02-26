package com.sxt.sys.controller;

import com.sxt.sys.constants.SYSConstants;
import com.sxt.sys.service.NoticeService;
import com.sxt.sys.utils.DataView;
import com.sxt.sys.utils.ResultObj;
import com.sxt.sys.utils.WebUtils;
import com.sxt.sys.vo.NoticeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author WanMing
 * @date 2019/2/20 21:20
 */
@RestController
@RequestMapping("notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    /**
     * 查询公告
     * @param noticeVo
     * @return
     */
    @RequestMapping("loadAllNotice")
    public DataView loadAllNotice(NoticeVo noticeVo){
        return this.noticeService.queryAllNotice(noticeVo);
    }


    /**
     * 添加公告
     * @param noticeVo
     * @return
     */
    @RequestMapping("addNotice")
    public ResultObj addNotice(NoticeVo noticeVo){
        ResultObj resultObj = null;
        try {
            noticeVo.setCreatetime(new Date());
            noticeVo.setOpername(WebUtils.getCurrentUser().getName());
            this.noticeService.addNotice(noticeVo);
            resultObj = new ResultObj(SYSConstants.OPERATE_SUCCESS_CODE,SYSConstants.OPERATE_ADD_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            resultObj = new ResultObj(SYSConstants.OPERATE_FAILURE_CODE,SYSConstants.OPERATE_ADD_FAILURE);
        }

        return resultObj;
    }


    /**
     * 删除公告
     * @param noticeVo
     * @return
     */
    @RequestMapping("deleteNotice")
    public ResultObj deleteNotice(NoticeVo noticeVo){
        ResultObj resultObj = null;
        try {
            this.noticeService.deleteNotice(noticeVo.getId());
            resultObj = new ResultObj(SYSConstants.OPERATE_SUCCESS_CODE,SYSConstants.OPERATE_DELETE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            resultObj = new ResultObj(SYSConstants.OPERATE_FAILURE_CODE,SYSConstants.OPERATE_DELETE_FAILURE);
        }

        return resultObj;
    }


    /**
     * 修改公告
     * @param noticeVo
     * @return
     */
    @RequestMapping("updateNotice")
    public ResultObj updateNotice(NoticeVo noticeVo){
        ResultObj resultObj = null;
        try {
            this.noticeService.updateNotice(noticeVo);
            resultObj = new ResultObj(SYSConstants.OPERATE_SUCCESS_CODE,SYSConstants.OPERATE_UPDATE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            resultObj = new ResultObj(SYSConstants.OPERATE_FAILURE_CODE,SYSConstants.OPERATE_UPDATE_FAILURE);
        }

        return resultObj;
    }
}
