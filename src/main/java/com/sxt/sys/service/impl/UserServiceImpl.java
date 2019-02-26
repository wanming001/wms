package com.sxt.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sxt.sys.constants.SYSConstants;
import com.sxt.sys.domain.Role;
import com.sxt.sys.domain.User;
import com.sxt.sys.domain.User;
import com.sxt.sys.mapper.RoleMapper;
import com.sxt.sys.mapper.UserMapper;
import com.sxt.sys.service.UserService;
import com.sxt.sys.utils.DataView;
import com.sxt.sys.utils.MD5Utils;
import com.sxt.sys.utils.UUIDSalt;
import com.sxt.sys.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author WanMing
 * @date 2019/2/20 11:01
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 用户登陆验证
     *
     * @param loginName
     */
    @Override
    public User queryUserByloginName(String loginName) {
        return userMapper.queryUserByLoginName(loginName);
    }


    /**
     * 模糊加分页
     *
     * @param userVo
     * @return
     */
    @Override
    public DataView queryAllUser(UserVo userVo) {
        Page<Object> page = PageHelper.startPage(userVo.getPage(),userVo.getLimit());
        List<UserVo> users = this.userMapper.queryAllUser(userVo);
        //判断该页是否有数据
        if(page.getTotal()!=0 && page.size()==0){
            userVo.setPage(userVo.getPage()-1);
            Page<Object> page2 = PageHelper.startPage(userVo.getPage(),userVo.getLimit());
            List<UserVo> users2 = this.userMapper.queryAllUser(userVo);
            return new DataView(SYSConstants.STATUS_CODE,SYSConstants.STATUS_MSG,page2.getTotal(),users2);
        }
        return new DataView(SYSConstants.STATUS_CODE,SYSConstants.STATUS_MSG,page.getTotal(),users);
    }



    /**
     * 添加
     *
     * @param userVo
     */
    @Override
    public void addUser(UserVo userVo) {
        this.userMapper.insertSelective(userVo);
    }

    /**
     * 修改
     *
     * @param userVo
     */
    @Override
    public void updateUser(UserVo userVo) {
        //密码加盐操作
        String salt = UUIDSalt.getSalt();
        userVo.setPwd(MD5Utils.getMD5(userVo.getPwd(),salt,SYSConstants.HASH_NUM));
        userVo.setSalt(salt);
        this.userMapper.updateByPrimaryKeySelective(userVo);
    }

    /**
     * 删除
     *
     * @param id
     */
    @Override
    public void deleteUser(Integer id) {
        //删除用户的角色
        this.roleMapper.deleteRoleByUser(id);
        //删除用户
        this.userMapper.deleteByPrimaryKey(id);
    }

    /**
     * 获取最大排序码
     *
     * @return
     */
    @Override
    public Integer queryUserMaxOrderNum() {
        return this.userMapper.queryUserMaxOrderNum();
    }

    /**
     * 查询用户的角色
     *
     * @param uid
     * @return
     */
    @Override
    public DataView queryRoleByUser(Integer uid) {
        List<Map<String,Object>> list = new ArrayList<>();
        //查询所有的角色
        Role role = new Role();
        role.setAvailable(SYSConstants.SYS_AVAILABLE_TRUE);
        List<Role> allRole = this.roleMapper.queryAllRole(role);
        //查询用户拥有的角色
        List<Role> userRole = this.roleMapper.queryRoleByUser(uid);
        if(null!=userRole && !userRole.isEmpty()){
            for (Role role1 : allRole) {
                Boolean flag = false;
                for (Role role2 : userRole) {
                    if(role1.getId() == role2.getId()){
                        flag = true;
                        break;
                    }
                }
                Map<String,Object> map = new HashMap<>();
                map.put("id",role1.getId());
                map.put("name",role1.getName());
                map.put("remark",role1.getRemark());
                map.put("LAY_CHECKED",flag);
                list.add(map);

            }
        }

        return new DataView(SYSConstants.STATUS_CODE,SYSConstants.STATUS_MSG,(long)list.size(),list);
    }

    /**
     * 给用户添加角色
     *
     * @param userVo
     */
    @Override
    public void addRoleToUser(UserVo userVo) {
        Integer id = userVo.getId();
        Integer[] ids = userVo.getIds();
        //清空角色
        this.roleMapper.deleteRoleByUser(id);
        //添加角色
        if(null!=ids && ids.length>0){
            for (Integer rid : ids) {
                this.roleMapper.addRoleToUser(id,rid);
            }
        }

    }

    /**
     * 根据部门id加载用户
     *
     * @param userVo
     * @return
     */
    @Override
    public List<UserVo> queryAllUserByDeptId(UserVo userVo) {
        return this.userMapper.queryAllUser(userVo);
    }

    @Override
    public User queryUserByMgr(Integer mgr) {
        return this.userMapper.selectByPrimaryKey(mgr);
    }


}
