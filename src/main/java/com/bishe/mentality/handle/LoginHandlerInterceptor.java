package com.bishe.mentality.handle;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception{
        Object o = request.getSession().getAttribute("student");
        Object oo = request.getSession().getAttribute("adm");
        Object ooo = request.getSession().getAttribute("con");
        if(o == null && oo==null && ooo==null){
            request.setAttribute("msg",1);
            request.getRequestDispatcher("/index").forward(request,response);
            return false;
        }
        return true;
    }

}