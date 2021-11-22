package io.github.vino42.support;

/**
 * =====================================================================================
 *
 * @Created :   2021/11/20 20:12
 * @Compiler :  jdk 11
 * @Author :    VINO
 * @Email : 38912428@qq.com
 * @Copyright : VINO
 * @Decription : 常量池
 * =====================================================================================
 */
public interface Constant {

    String CASBIN_USER_PREFIX = "user_";

    String CASBIN_ROLE_PREFIX = "role_";

    String CASBIN_DOMAIN_PREFIX = "domain_";

    String CASBIN_POLICY_G = "g";

    String CASBIN_POLICY_G2 = "g2";

    interface Response {
        int SUCCESS_CODE = 0;

        String SUCCESS_MSG = "success";

        int ILLEGAL_ARGUMENT_ERROR_CODE = 40000;

        String ILLEGAL_ARGUMENT_ERROR_MSG = "illegal param";

        int NEED_AUT_ERROR_CODE = 40100;

        String NEED_AUT_ERROR_MSG = "没有权限";
    }

    interface CustomRequestHeaders {

        String X_USER_ID = "X-user-id";
        String X_DOMAIN_ID = "X-domain-id";
    }

}
