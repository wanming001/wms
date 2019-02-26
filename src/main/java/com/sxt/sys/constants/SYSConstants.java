package com.sxt.sys.constants;

/**
 * @author WanMing
 * @date 2019/2/20 11:18
 */

public interface SYSConstants {
    /**
     *普通用户=1
     *超级管理员=0
     */
    Integer USER_TYPE_NORMAL = 1;
    Integer USER_TYPE_SUPER = 0;

    /**
     * 定义登陆用户成功后session中的名字
     */
    String SESSION_USER_NAME = "user";

    /**
     * 登陆错误信息
     */
    String LOGIN_ERROR_MSG = "error";
    String LOGIN_NAME_ERROR = "用户名不存在";
    String LOGIN_PASSWORD_ERROR = "密码错误";
    /**
     * 菜单的类型
     */
    String MENU_TYPE_MENU = "menu";
    String MENU_TYPE_PERMISSION ="permission" ;
    Integer SYS_AVAILABLE_TRUE = 1;
    Integer SYS_AVAILABLE_FALSE = 0;
    /**
     * 菜单是否展开
     */
    Integer MENU_OPEN_TRUE = 1;
    Integer MENU_OPEN_FASLE = 0;
    /**
     * 显示二级菜单
     */
    Integer VIEW_TWO_MENU = 1;
    Integer VIEW_ONE_MENU = 0;

    /**
     * 数据返回状态码及信息
     */
    Integer STATUS_CODE = 0;
    String STATUS_MSG = "数据加载成功";


    /**
     * 添加
     */
    Integer OPERATE_SUCCESS_CODE = 1;
    Integer OPERATE_FAILURE_CODE = 0;
    

    /**
     * 添加
     */
    String OPERATE_ADD_SUCCESS = "添加成功";
    String OPERATE_ADD_FAILURE = "添加失败";

    /**
     * 修改
     */
    String OPERATE_UPDATE_SUCCESS = "修改成功";
    String OPERATE_UPDATE_FAILURE = "修改失败";

    /**
     * 删除
     */
    String OPERATE_DELETE_SUCCESS = "删除成功";
    String OPERATE_DELETE_FAILURE = "删除失败";

    /**
     * 是否是父级部门
     */
    Integer DEPT_ISPARENT_TRUE = 1;
    Integer DEPT_ISPARENT_FALSE = 0;

    /**
     * 部门是否展开
     */
    Integer DEPT_OPEN_TRUE = 1;
    Integer DEPT_OPEN_FALSE = 0;

    //权限关闭开放
    Integer PERMISSION_OPEN_FALSE = 0;
    Integer PERMISSION_OPEN_TRUE = 1;
    //不是父节点
    Integer PERMISSION_ISPARENT_FALSE = 0;

    //权限分配
    String PERMISSION_ALLOT_SUCCESS = "权限分配成功";
    String PERMISSION_ALLOT_FAILURE ="权限分配失败" ;

    //角色分配
    String ROLE_ALLOT_SUCCESS = "角色分配成功";
    String ROLE_ALLOT_FAILURE = "角色分配成功";

    //加密散列次数
    Integer HASH_NUM = 2;
    //修改面操作
    String OLDPWD_ERROR = "原密码错误";

    //默认图片地址
    String DEFAULT_IMG = "defaultimg.png";

    //图片根路径
    String IMG_ROOT = "D:/upload/";
}
