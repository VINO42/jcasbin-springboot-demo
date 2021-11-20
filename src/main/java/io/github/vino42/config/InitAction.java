package io.github.vino42.config;

import io.github.vino42.domain.model.CasbinRoleResourceModel;
import io.github.vino42.domain.model.CasbinUserResourcePermissionModel;
import io.github.vino42.domain.model.CasbinUserRoleModel;
import io.github.vino42.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.casbin.jcasbin.main.Enforcer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

import static io.github.vino42.support.Constant.CASBIN_POLICY_G2;

/**
 * =====================================================================================
 *
 * @Created :   2021/11/20 19:35
 * @Compiler :  jdk 11
 * @Author :    VINO
 * @Email : 38912428@qq.com
 * @Copyright : VINO
 * @Decription :
 * =====================================================================================
 */
@Slf4j
@Component
public class InitAction {
    @Autowired
    private Enforcer enforcer;
    @Autowired
    private IUserService sysUserService;

    @PostConstruct
    public void init() {
        //p, user_1, /ask, POST
        List<CasbinUserResourcePermissionModel> casbinUserResourcePermissionModels = sysUserService.getCasbinUserResourcePermissionModel();
        //g, user_1, role_admin
        List<CasbinUserRoleModel> casbinUserRoleModels = sysUserService.getCasbinUserRoleModel();
        //p, user_1, /ask, POST
        List<CasbinRoleResourceModel> casbinRoleResourceModels = sysUserService.getCasbinRoleResourceModel();

        casbinUserResourcePermissionModels.forEach(casbinUserResourcePermissionModel -> {
            enforcer.addPermissionForUser(casbinUserResourcePermissionModel.getUserId(),
                    casbinUserResourcePermissionModel.getResourcePath(),
                    casbinUserResourcePermissionModel.getPermission());
        });
        //g, user_12, role_admin
        casbinUserRoleModels.forEach(casbinUserRoleModel -> {
            enforcer.addRoleForUser(casbinUserRoleModel.getUserId(), casbinUserRoleModel.getRoleId());
        });
        //g2, /ask2, role_11
        casbinRoleResourceModels.forEach(casbinRoleResourceModel -> {
            enforcer.addNamedGroupingPolicy(CASBIN_POLICY_G2, casbinRoleResourceModel.getResourcePath(), casbinRoleResourceModel.getRoleId());
        });
        enforcer.buildRoleLinks();
        enforcer.savePolicy();
        log.info("[ ==========================init casbin policy over============================ ]");
    }
}
