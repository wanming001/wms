package com.sxt.sys.controller;

import com.sxt.sys.constants.SYSConstants;
import com.sxt.sys.domain.Dept;
import com.sxt.sys.service.DeptService;
import com.sxt.sys.utils.DataView;
import com.sxt.sys.utils.ResultObj;
import com.sxt.sys.utils.TreeNode;
import com.sxt.sys.utils.WebUtils;
import com.sxt.sys.vo.DeptVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author WanMing
 * @date 2019/2/20 21:20
 */
@RestController
@RequestMapping("dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * 查询部门
     * @param deptVo
     * @return
     */
    @RequestMapping("loadAllDept")
    public DataView loadAllDept(DeptVo deptVo){
        return this.deptService.queryAllDept(deptVo);
    }

    /**
     * 加载部门管理左侧的菜单
     * @param deptVo
     * @return
     */
    @RequestMapping("loadDeptManagerLeftTreeJson")
    public List<TreeNode> loadDeptManagerLeftTreeJson(DeptVo deptVo){
        List<TreeNode> nodes = new ArrayList<>();
        List<Dept> depts = this.deptService.queryAllDeptByTreeeView(deptVo);
        for (Dept dept : depts) {
            Boolean isParent = dept.getParent()==SYSConstants.DEPT_ISPARENT_TRUE?true:false;
            Boolean open = dept.getOpen()==SYSConstants.DEPT_OPEN_TRUE?true:false;
            nodes.add(new TreeNode(dept.getId(),dept.getPid(),dept.getName(),isParent,open));
        }
        return nodes;
    }


    /**
     * 添加部门
     * @param deptVo
     * @return
     */
    @RequestMapping("addDept")
    public ResultObj addDept(DeptVo deptVo){
        ResultObj resultObj = null;
        try {
            this.deptService.addDept(deptVo);
            resultObj = new ResultObj(SYSConstants.OPERATE_SUCCESS_CODE,SYSConstants.OPERATE_ADD_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            resultObj = new ResultObj(SYSConstants.OPERATE_FAILURE_CODE,SYSConstants.OPERATE_ADD_FAILURE);
        }

        return resultObj;
    }


    /**
     * 删除部门
     * @param deptVo
     * @return
     */
    @RequestMapping("deleteDept")
    public ResultObj deleteDept(DeptVo deptVo){
        ResultObj resultObj = null;
        try {
            this.deptService.deleteDept(deptVo.getId());
            resultObj = new ResultObj(SYSConstants.OPERATE_SUCCESS_CODE,SYSConstants.OPERATE_DELETE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            resultObj = new ResultObj(SYSConstants.OPERATE_FAILURE_CODE,SYSConstants.OPERATE_DELETE_FAILURE);
        }

        return resultObj;
    }


    /**
     * 修改部门
     * @param deptVo
     * @return
     */
    @RequestMapping("updateDept")
    public ResultObj updateDept(DeptVo deptVo){
        ResultObj resultObj = null;
        try {
            this.deptService.updateDept(deptVo);
            resultObj = new ResultObj(SYSConstants.OPERATE_SUCCESS_CODE,SYSConstants.OPERATE_UPDATE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            resultObj = new ResultObj(SYSConstants.OPERATE_FAILURE_CODE,SYSConstants.OPERATE_UPDATE_FAILURE);
        }

        return resultObj;
    }

    /**
     * 获取最大的排序码
     * @return
     */
    @RequestMapping("getDeptMaxOrderNum")
    public Map<String,Object> getDeptMaxOrderNum(){
        Map<String,Object> map = new HashMap<>();
        Integer orderNum = this.deptService.queryDeptMaxOrderNum();
        map.put("value",orderNum+1);
        return map;
    }


    /**
     * 查询是否有子节点
     * @param deptVo
     * @return
     */
    @RequestMapping("deptHasChild")
    public Map<String,Object> deptHasChild(DeptVo deptVo){
        Map<String,Object> map = new HashMap<>();
        Boolean num = this.deptService.queryDeptHasChild(deptVo.getId())>0?true:false;
        map.put("value",num);
        return map;
    }
}
