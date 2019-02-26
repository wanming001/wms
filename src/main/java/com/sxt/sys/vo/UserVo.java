package com.sxt.sys.vo;

import com.sxt.sys.domain.User;
import lombok.Getter;
import lombok.Setter;

/**
 * @author WanMing
 * @date 2019/2/20 10:58
 */

@Setter
@Getter
public class UserVo extends User {

    /**
     * 分页属性
     */
    private Integer page;
    private Integer limit;

    /**
     * 外键属性
     */
    private String deptName;
    private String leaderName;

    //角色数组
    private Integer[] ids;

    //旧密码
    private String oldPwd;







}
