package com.cqnu.dbopersix.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class OperSession {
    public static HttpSession getSession(){
        HttpServletRequest request= ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getSession();
    }

    public static void writeSession(String key, String value) {
        HttpSession session=getSession();
        session.setAttribute(key, value);
    }

    public static String readSession(String key) {
        HttpSession session=getSession();
        return (String) session.getAttribute(key);
    }

    public static void removeSessionKey(String key) {
        HttpSession session=getSession();
        session.removeAttribute(key);
    }
}
