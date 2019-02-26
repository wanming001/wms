package com.sxt.sys.controller;

import com.sxt.sys.constants.SYSConstants;
import com.sxt.sys.domain.LogInfo;
import com.sxt.sys.service.LogInfoService;
import com.sxt.sys.utils.ActiverUser;
import com.sxt.sys.utils.WebUtils;
import com.sxt.sys.vo.LogInfoVo;
import com.sxt.sys.vo.UserVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @author WanMing
 * @date 2019/2/20 11:39
 */

@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    private LogInfoService logInfoService;

    @RequestMapping("login")
    public String login(UserVo userVo, Model model){
        //得到当前线程的subject
        Subject subject = SecurityUtils.getSubject();
        //构造用户名的密码
        AuthenticationToken token = new UsernamePasswordToken(userVo.getLoginname(),userVo.getPwd());
        try {
            // 6,使用subject去执行认证
            subject.login(token);
            System.out.println("登录成功");
            //存入session
            ActiverUser user=(ActiverUser) subject.getPrincipal();
            WebUtils.getCurrentSession().setAttribute(SYSConstants.SESSION_USER_NAME, user.getUser());
            //添加日志
            LogInfoVo LogInfoVo = new LogInfoVo();
            LogInfoVo.setLoginname(user.getUser().getName()+"-"+user.getUser().getLoginname());
            LogInfoVo.setLoginip(WebUtils.getCurrentHttpServletRequest().getRemoteAddr());
            LogInfoVo.setLogintime(new Date());
            logInfoService.addLogInfo(LogInfoVo);
            return "index";
        } catch (IncorrectCredentialsException e) {
            System.out.println("密码不正确");
            model.addAttribute(SYSConstants.LOGIN_ERROR_MSG,SYSConstants.LOGIN_PASSWORD_ERROR);
        } catch (UnknownAccountException e) {
            System.out.println("用户不存在");
            model.addAttribute(SYSConstants.LOGIN_ERROR_MSG,SYSConstants.LOGIN_NAME_ERROR);
        }
        return "login";

    }
}
