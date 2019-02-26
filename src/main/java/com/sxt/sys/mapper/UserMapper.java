package com.sxt.sys.mapper;

import com.sxt.sys.domain.User;
import com.sxt.sys.vo.UserVo;

import java.util.List;


public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //登陆查询
    User queryUserByLoginName(String loginName);

    //查询
    List<UserVo> queryAllUser(User user);

    //获取最大排序码
    Integer queryUserMaxOrderNum();
}