package io.github.vino42.service;

import io.github.vino42.domain.entity.UserEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import io.github.vino42.domain.model.CasbinRoleResourceModel;
import io.github.vino42.domain.model.CasbinUserResourcePermissionModel;
import io.github.vino42.domain.model.CasbinUserRoleModel;

import java.util.List;

/**
 * =====================================================================================
 *
 * @Created :   2021/11/20 14:46:27
 * @Compiler :  jdk 11
 * @Author :    VINO
 * @Copyright : VINO
 * @Decription :  服务类
 * =====================================================================================
 */
public interface IUserService extends IService<UserEntity> {

    List<CasbinUserResourcePermissionModel> getCasbinUserResourcePermissionModel();

    List<CasbinUserRoleModel> getCasbinUserRoleModel();

    List<CasbinRoleResourceModel> getCasbinRoleResourceModel();

    Boolean allocateRole(Integer userId, Integer roleId);

    Boolean allocateRoleResource(Integer roleId, Integer resourceId);

    List<CasbinUserResourcePermissionModel> getCasbinUserResourcePermissionModel(Integer userId, Integer roleId);
}
