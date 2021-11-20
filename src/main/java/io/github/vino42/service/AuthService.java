package io.github.vino42.service;

import org.casbin.jcasbin.main.Enforcer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * =====================================================================================
 *
 * @Created :   2021/11/20 21:28
 * @Compiler :  jdk 11
 * @Author :    VINO
 * @Email : 38912428@qq.com
 * @Copyright : VINO
 * @Decription :
 * =====================================================================================
 */
@Component
public class AuthService {

    @Autowired
    private Enforcer enforcer;

    @Cacheable(key = "#sub+'_'+#resource+'_'+#permission")
    public boolean auth(String sub, String resource, String permission) {
        return enforcer.enforce(sub, resource, permission);
    }


}
