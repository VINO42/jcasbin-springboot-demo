package io.github.vino42.web.filter;

import cn.hutool.json.JSONUtil;
import io.github.vino42.support.Constant;
import io.github.vino42.support.Result;
import org.casbin.jcasbin.main.Enforcer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static io.github.vino42.support.Constant.CASBIN_USER_PREFIX;

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
        String userId = request.getHeader(Constant.CustomRequestHeaders.X_USER_ID);
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        enforcer.loadPolicy();
        boolean enforce = enforcer.enforce(CASBIN_USER_PREFIX + userId, requestURI, method);
        if (enforce) {
            filterChain.doFilter(request, response);
        } else {
            Result<Object> objectResult = Result.noPermission();
            response.setCharacterEncoding(StandardCharsets.UTF_8.displayName());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.getWriter().write(JSONUtil.toJsonStr(objectResult));
        }

    }
}
