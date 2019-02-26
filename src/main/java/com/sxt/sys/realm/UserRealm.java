package com.sxt.sys.realm;

import com.sxt.sys.constants.SYSConstants;
import com.sxt.sys.domain.Permission;
import com.sxt.sys.domain.User;
import com.sxt.sys.service.PermissionService;
import com.sxt.sys.service.UserService;
import com.sxt.sys.utils.ActiverUser;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * Shiro认证授权
 *
 * @author WanMing
 * @date 2019/1/27 17:53
 */
@Component
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

   @Autowired
   private PermissionService permissionService;

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }



    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户名
        String username = authenticationToken.getPrincipal().toString();
        //查询该用户名的用户是否存在
        User user = userService.queryUserByloginName(username);
        if (null != user) {
            //存在，继续验证密码
            //获取该用户的权限的角色放入activeUser中
            ActiverUser activerUser = new ActiverUser();
            activerUser.setUser(user);

            if(user.getType()== SYSConstants.USER_TYPE_NORMAL){
                //查询角色
                //查询权限
                List<String> permissions = this.permissionService.queryAllPermissionByUserId(user.getId());
                activerUser.setPermissions(permissions);
            }
            //设置凭证匹配器根据用户d数据库随机盐
            ByteSource bytes = ByteSource.Util.bytes(user.getSalt());
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(activerUser,user.getPwd(), bytes, getName());
            return authenticationInfo;
        } else {
            //用户不存在

            return null;
        }

    }

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        ActiverUser activerUser = (ActiverUser) principalCollection.getPrimaryPrincipal();

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //超级用户配置所有权限
        if(activerUser.getUser().getType()==SYSConstants.USER_TYPE_SUPER){
            info.addStringPermission("*:*");
        }else {
            //角色不为空，添加角色
            if(null!=activerUser.getRoles()&&!activerUser.getRoles().isEmpty()){
                info.addRoles(activerUser.getRoles());
            }
            //权限不为空，添加权限
            if(null!=activerUser.getPermissions()&&!activerUser.getPermissions().isEmpty()){
                info.addStringPermissions(activerUser.getPermissions());
            }
        }



        return info;
    }
}
