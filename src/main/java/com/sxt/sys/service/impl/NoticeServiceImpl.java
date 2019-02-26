package com.sxt.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.sys.constants.SYSConstants;
import com.sxt.sys.domain.Notice;
import com.sxt.sys.mapper.NoticeMapper;
import com.sxt.sys.service.NoticeService;
import com.sxt.sys.utils.DataView;
import com.sxt.sys.vo.NoticeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WanMing
 * @date 2019/2/20 21:14
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;
    /**
     * 模糊加分页
     *
     * @param noticeVo
     * @return
     */
    @Override
    public DataView queryAllNotice(NoticeVo noticeVo) {
        Page<Object> page = PageHelper.startPage(noticeVo.getPage(),noticeVo.getLimit());
        List<Notice> notices = this.noticeMapper.queryAllNotice(noticeVo);
        //判断该页是否有数据
        if(page.getTotal()!=0 && page.size()==0){
            noticeVo.setPage(noticeVo.getPage()-1);
            Page<Object> page2 = PageHelper.startPage(noticeVo.getPage(),noticeVo.getLimit());
            List<Notice> notis2 = this.noticeMapper.queryAllNotice(noticeVo);
            return new DataView(SYSConstants.STATUS_CODE,SYSConstants.STATUS_MSG,page2.getTotal(),notis2);
        }
        return new DataView(SYSConstants.STATUS_CODE,SYSConstants.STATUS_MSG,page.getTotal(),notices);
    }

    /**
     * 添加
     *
     * @param noticeVo
     */
    @Override
    public void addNotice(NoticeVo noticeVo) {
        this.noticeMapper.insertSelective(noticeVo);
    }

    /**
     * 修改
     *
     * @param noticeVo
     */
    @Override
    public void updateNotice(NoticeVo noticeVo) {
        this.noticeMapper.updateByPrimaryKeySelective(noticeVo);
    }

    /**
     * 删除
     *
     * @param id
     */
    @Override
    public void deleteNotice(Integer id) {
        this.noticeMapper.deleteByPrimaryKey(id);
    }
}
