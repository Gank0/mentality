//package com.bishe.mentality.handle;
//
//import org.springframework.web.servlet.HandlerInterceptor;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class LoginHandlerInterceptor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//        throws Exception{
//        Object o = request.getSession().getAttribute("Student");
//        if(o == null){
//            request.setAttribute("msg","没有权限");
//            request.getRequestDispatcher("/").forward(request,response);
//            return false;
//        }
//        return true;
//    }
//
//}
