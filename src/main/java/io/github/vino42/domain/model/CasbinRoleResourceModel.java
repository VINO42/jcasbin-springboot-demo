package io.github.vino42.domain.model;

import java.io.Serializable;

import static io.github.vino42.support.Constant.CASBIN_ROLE_PREFIX;

/**
 * =====================================================================================
 *
 * @Created :   2021/11/20 19:37
 * @Compiler :  jdk 11
 * @Author :    VINO
 * @Email : 38912428@qq.com
 * @Copyright : VINO
 * @Decription :
 * =====================================================================================
 */

public class CasbinRoleResourceModel implements Serializable {


    private String g = "g2";

    private String resourcePath;

    private String roleId;

    public String getG() {
        return g;
    }

    public void setG(String g) {
        this.g = g;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = CASBIN_ROLE_PREFIX + roleId;
    }
}
