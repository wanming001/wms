package com.sxt.sys.service;

import com.sxt.sys.utils.DataView;
import com.sxt.sys.vo.NoticeVo;

/**
 * @author WanMing
 * @date 2019/2/20 21:11
 */

public interface NoticeService {

    /**
     * 模糊加分页
     * @param noticeVo
     * @return
     */
    DataView queryAllNotice(NoticeVo noticeVo);

    /**
     * 添加
     * @param noticeVo
     */
    void addNotice(NoticeVo noticeVo);

    /**
     * 修改
     * @param noticeVo
     */
    void updateNotice(NoticeVo noticeVo);

    /**
     * 删除
     * @param id
     */
    void deleteNotice(Integer id);


}
