package io.github.vino42.domain.model;

import lombok.Data;

import java.io.Serializable;

import static io.github.vino42.support.Constant.CASBIN_USER_PREFIX;

/**
 * =====================================================================================
 *
 * @Created :   2021/11/20 19:37
 * @Compiler :  jdk 11
 * @Author :    VINO
 * @Email : 38912428@qq.com
 * @Copyright : VINO
 * @Decription : p, user_1, /ask, POST
 * =====================================================================================
 */

public class CasbinUserResourcePermissionModel implements Serializable {
    private String p="p";

    private String userId;

    private String resourcePath;

    private String permission;

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = CASBIN_USER_PREFIX+userId;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
