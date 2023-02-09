package nl.coffee.coffeestore.postConfig;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class InterceptorJava implements HandlerInterceptor{

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {
        // your code
        System.out.println("Method pre:");
        System.out.println(request.getMethod());
        return true;
    }

    @Override
    public void postHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            ModelAndView modelAndView) throws Exception {
        // your code
        System.out.println("Method post:");
        System.out.println(request.getMethod());
    }

    @Override
    public void afterCompletion(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler, Exception ex) {
        // your code
        System.out.println("Method after:");
        System.out.println(request.getMethod());
    }
}
