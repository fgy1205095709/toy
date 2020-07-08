package com.admin.admin.Interceptor;

import com.admin.admin.pojo.ToyAdmin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tid
 * @create 2019-02-10 22:39
 **/
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI ();
        String uri = requestURI.substring (requestURI.lastIndexOf ("/"));
        ToyAdmin user = (ToyAdmin) request.getSession ().getAttribute ("USER");
        if ( "/login.html".equals (uri)||"/vendor.bundle.base.css".equals (uri)||"/materialdesignicons.min.css".equals (uri)||"/style.css".equals (uri)||"/vendor.bundle.base.js".equals (uri)||"/off-canvas.js".equals (uri)||"/vendor.bundle.addons.js".equals (uri)||"/misc.js".equals (uri)||"/logo.png".equals (uri)||"/Ubuntu-Medium.woff2".equals (uri)||"/Ubuntu-Regular.woff2".equals (uri)||"/favicon.png".equals (uri)||"/Ubuntu-Bold.woff2".equals (uri)||"/Ubuntu-Light.woff2".equals (uri)||"/Ubuntu-Bold.woff".equals (uri)||"/Ubuntu-Regular.woff".equals (uri)||"/Ubuntu-Medium.woff".equals (uri)||"/Ubuntu-Light.woff".equals (uri)||"/Ubuntu-Regular.ttf".equals (uri)||"/Ubuntu-Medium.ttf".equals (uri)||"/login".equals (uri)) {
            return true;
        } else if (user == null) {
            response.sendRedirect (request.getContextPath () + "/login.html");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
