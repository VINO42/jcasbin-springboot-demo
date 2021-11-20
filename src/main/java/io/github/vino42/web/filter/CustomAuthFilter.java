package io.github.vino42.web.filter;

import cn.hutool.json.JSONUtil;
import org.casbin.jcasbin.main.Enforcer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * =====================================================================================
 *
 * @Created :   2021/11/20 0:28
 * @Compiler :  jdk 11
 * @Author :    VINO
 * @Email : 38912428@qq.com
 * @Copyright : VINO
 * @Decription :
 * =====================================================================================
 */
@WebFilter(filterName = "authFilter", urlPatterns = "/*")
public class CustomAuthFilter extends OncePerRequestFilter {
    @Autowired
    private Enforcer enforcer;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String userId = request.getHeader("X-user-id");
        String requestURI = request.getRequestURI();
        String method = request.getMethod();

        boolean enforce = enforcer.enforce("user_"+userId, requestURI, method);
        if (enforce) {
            filterChain.doFilter(request, response);
        } else {
            Map<String, Object> result = new HashMap<String, Object>(3);
            result.put("code", 401);
            result.put("msg", "用户权限不足");
            result.put("data", null);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            response.getWriter().write(JSONUtil.toJsonStr(result));
        }

    }
}
