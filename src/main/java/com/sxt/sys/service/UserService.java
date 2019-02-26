package com.sxt.sys.service;

import com.sxt.sys.domain.User;
import com.sxt.sys.utils.DataView;
import com.sxt.sys.vo.UserVo;

import java.util.List;


/**
 * 用户业务接口
 * @author WanMing
 * @date 2019/2/20 10:59
 */

public interface UserService {

    /**
     * 用户登陆验证
     */
    User queryUserByloginName(String loginName);

    /**
     * 模糊加分页
     *
     * @param userVo
     * @return
     */
    DataView queryAllUser(UserVo userVo);


    /**
     * 添加
     *
     * @param userVo
     */
    void addUser(UserVo userVo);

    /**
     * 修改
     *
     * @param userVo
     */
    void updateUser(UserVo userVo);

    /**
     * 删除
     *
     * @param id
     */
    void deleteUser(Integer id);

    /**
     * 获取最大排序码
     *
     * @return
     */
    Integer queryUserMaxOrderNum();

    /**
     * 查询用户的角色
     * @param uid
     * @return
     */
    DataView queryRoleByUser(Integer uid);

    /**
     * 给用户天添加角色
     * @param userVo
     */
    void addRoleToUser(UserVo userVo);

    /**
     * 根据部门id加载用户
     * @param userVo
     * @return
     */
    List<UserVo> queryAllUserByDeptId(UserVo userVo);

    //查询用户
    User queryUserByMgr(Integer mgr);
}


