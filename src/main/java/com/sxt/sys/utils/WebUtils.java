package com.sxt.sys.utils;

import com.sxt.sys.constants.SYSConstants;
import com.sxt.sys.domain.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author WanMing
 * @date 2019/2/2 18:35
 */

public class WebUtils {

    /**
     * 得到当前线程的HttpServletRequest
     */
    public static HttpServletRequest getCurrentHttpServletRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        return request;
    }

    /**
     * 得到HttpServletResponse
     */
    public static HttpServletResponse getCurrentHttpServletResponse() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletResponse response = requestAttributes.getResponse();
        return response;
    }

    /**
     * 得到session
     *
     */
    public static HttpSession getCurrentSession() {
        return getCurrentHttpServletRequest().getSession();
    }

    /**
     * 得到context
     *
     */
    public static ServletContext getServletContext() {
        return getCurrentHttpServletRequest().getServletContext();
    }


    /**
     *  得到User的对象
     */
    @SuppressWarnings("unchecked")
    public static User getCurrentUser(){
        return (User) getCurrentSession().getAttribute(SYSConstants.SESSION_USER_NAME);
    }
}
