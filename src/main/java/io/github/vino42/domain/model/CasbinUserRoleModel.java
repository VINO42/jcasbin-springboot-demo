package io.github.vino42.domain.model;

import java.io.Serializable;

import static io.github.vino42.support.Constant.*;

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

public class CasbinUserRoleModel implements Serializable {

    private String g = "g";

    private String userId;

    private String domainId;

    private String roleId;

    public void setG(String g) {
        this.g = g;
    }

    public void setUserId(String userId) {
        this.userId = CASBIN_USER_PREFIX + userId;
    }

    public void setRoleId(String roleId) {
        this.roleId = CASBIN_ROLE_PREFIX + roleId;
    }

    public String getG() {
        return g;
    }

    public String getUserId() {
        return userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = CASBIN_DOMAIN_PREFIX + domainId;
    }
}
