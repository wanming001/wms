package com.sxt.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.sys.constants.SYSConstants;
import com.sxt.sys.domain.Dept;
import com.sxt.sys.mapper.DeptMapper;
import com.sxt.sys.service.DeptService;
import com.sxt.sys.utils.DataView;
import com.sxt.sys.vo.DeptVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author WanMing
 * @date 2019/2/20 21:14
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    /**
     * 模糊加分页
     *
     * @param deptVo
     * @return
     */
    @Override
    public DataView queryAllDept(DeptVo deptVo) {
        Page<Object> page = PageHelper.startPage(deptVo.getPage(),deptVo.getLimit());
        List<Dept> depts = this.deptMapper.queryAllDept(deptVo);
        //判断该页是否有数据
        if(page.getTotal()!=0 && page.size()==0){
            deptVo.setPage(deptVo.getPage()-1);
            Page<Object> page2 = PageHelper.startPage(deptVo.getPage(),deptVo.getLimit());
            List<Dept> depts2 = this.deptMapper.queryAllDept(deptVo);
            return new DataView(SYSConstants.STATUS_CODE,SYSConstants.STATUS_MSG,page2.getTotal(),depts2);
        }
        return new DataView(SYSConstants.STATUS_CODE,SYSConstants.STATUS_MSG,page.getTotal(),depts);
    }

    /**
     * 加载所有的部门
     *
     * @param deptVo
     * @return
     */
    @Override
    public List<Dept> queryAllDeptByTreeeView(DeptVo deptVo) {
        return this.deptMapper.queryAllDept(deptVo);
    }

    /**
     * 添加
     *
     * @param deptVo
     */
    @Override
    public void addDept(DeptVo deptVo) {
        this.deptMapper.insertSelective(deptVo);
    }

    /**
     * 修改
     *
     * @param deptVo
     */
    @Override
    public void updateDept(DeptVo deptVo) {
        this.deptMapper.updateByPrimaryKeySelective(deptVo);
    }

    /**
     * 删除
     *
     * @param id
     */
    @Override
    public void deleteDept(Integer id) {
        this.deptMapper.deleteByPrimaryKey(id);
    }

    /**
     * 获取最大排序码
     *
     * @return
     */
    @Override
    public Integer queryDeptMaxOrderNum() {
        return this.deptMapper.queryDeptMaxOrderNum();
    }

    /**
     * 判断该节点下面是否有子节点
     *
     * @param id
     * @return
     */
    @Override
    public Integer queryDeptHasChild(Integer id) {
        return this.deptMapper.queryDeptHasChild(id);
    }
}
