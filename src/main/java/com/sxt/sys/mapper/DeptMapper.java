package com.sxt.sys.mapper;

import com.sxt.sys.domain.Dept;

import java.util.List;

public interface DeptMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);

    //查询
    List<Dept> queryAllDept(Dept dept);

    //查询最大排序码
    Integer queryDeptMaxOrderNum();

    //查询子节点的个数
    Integer queryDeptHasChild(Integer id);
}