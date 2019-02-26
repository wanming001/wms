package com.sxt.sys.service;

import com.sxt.sys.domain.Dept;
import com.sxt.sys.utils.DataView;
import com.sxt.sys.vo.DeptVo;

import java.util.List;

/**
 * @author WanMing
 * @date 2019/2/20 21:11
 */

public interface DeptService {

    /**
     * 模糊加分页
     * @param deptVo
     * @return
     */
    DataView queryAllDept(DeptVo deptVo);

    /**
     * 加载所有的部门
     * @return
     */
    List<Dept> queryAllDeptByTreeeView(DeptVo deptVo);

    /**
     * 添加
     * @param deptVo
     */
    void addDept(DeptVo deptVo);

    /**
     * 修改
     * @param deptVo
     */
    void updateDept(DeptVo deptVo);

    /**
     * 删除
     * @param id
     */
    void deleteDept(Integer id);

    /**
     * 获取最大排序码
     * @return
     */
    Integer queryDeptMaxOrderNum();

    /**
     * 判断该节点下面是否有子节点
     * @param id
     * @return
     */
    Integer queryDeptHasChild(Integer id);
}
