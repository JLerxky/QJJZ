package com.jler.qjjz.until;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.jar.Attributes;

public class Interceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(Interceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // TODO Auto-generated method stub
//        logger.info("-------访问控制");
        //获取session
        HttpSession session = request.getSession(true);
        //获取ipMac
        Attributes ipMac = UserInfo.iPMac(request);
        //判断用户ID是否存在，不存在就跳转到登录界面
        if (session.getAttribute("uAcct") == null) {
            logger.info("------未登录用户访问,ip:" + ipMac.getValue("ip"));
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        } else {
//            logger.info("------用户:" + session.getAttribute("uAcct") + "登录");
            session.setAttribute("uAcct", session.getAttribute("uAcct"));
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub

    }

}
