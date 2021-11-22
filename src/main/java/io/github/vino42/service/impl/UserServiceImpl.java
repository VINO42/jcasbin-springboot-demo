package io.github.vino42.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.vino42.domain.entity.ResourceEntity;
import io.github.vino42.domain.entity.RoleResourceEntity;
import io.github.vino42.domain.entity.UserEntity;
import io.github.vino42.domain.entity.UserRoleEntity;
import io.github.vino42.domain.mapper.UserMapper;
import io.github.vino42.domain.model.CasbinRoleResourceModel;
import io.github.vino42.domain.model.CasbinUserResourcePermissionModel;
import io.github.vino42.domain.model.CasbinUserRoleModel;
import io.github.vino42.service.IResourceService;
import io.github.vino42.service.IRoleResourceService;
import io.github.vino42.service.IUserRoleService;
import io.github.vino42.service.IUserService;
import org.casbin.jcasbin.main.Enforcer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static io.github.vino42.support.Constant.*;

/**
 * =====================================================================================
 *
 * @Created :   2021/11/20 14:46:27
 * @Compiler :  jdk 11
 * @Author :    VINO
 * @Copyright : VINO
 * @Decription :  服务实现类
 * =====================================================================================
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements IUserService {

    @Autowired
    IUserRoleService userRoleService;
    @Autowired
    IRoleResourceService roleResourceService;
    @Autowired
    IResourceService resourceService;
    @Autowired
    UserMapper userMapper;
    @Autowired
    private Enforcer enforcer;

    @Override
    public List<CasbinUserResourcePermissionModel> getCasbinUserResourcePermissionModel() {
        return this.getBaseMapper().getCasbinUserResourcePermissionModel();
    }

    @Override
    public List<CasbinUserRoleModel> getCasbinUserRoleModel() {
        return this.getBaseMapper().getCasbinUserRoleModel();
    }

    @Override
    public List<CasbinRoleResourceModel> getCasbinRoleResourceModel() {
        return this.getBaseMapper().getCasbinRoleResourceModel();
    }

    @Override
    @Transactional
    public Boolean allocateRole(Integer userId, Integer roleId) {

        UserRoleEntity one = userRoleService.getOne(Wrappers.<UserRoleEntity>lambdaQuery().eq(UserRoleEntity::getUserId, userId).eq(UserRoleEntity::getRoleId, roleId));
        if (one == null) {
            UserRoleEntity userRoleEntity = new UserRoleEntity();
            userRoleEntity.setUserId(userId);
            userRoleEntity.setRoleId(roleId);
            userRoleEntity.setCreateTime(LocalDateTime.now());
            userRoleEntity.setUpdateTime(LocalDateTime.now());
            userRoleService.save(userRoleEntity);
        }
        UserEntity userEntity = this.getBaseMapper().selectById(userId);
        try {
            enforcer.addRoleForUserInDomain(CASBIN_USER_PREFIX + userId, CASBIN_ROLE_PREFIX + roleId, CASBIN_DOMAIN_PREFIX + userEntity.getDomainId());
            List<CasbinUserResourcePermissionModel> casbinUserResourcePermissionModels = userMapper.getCasbinUserResourcePermissionModelByUserIdAndRoleId(userId, roleId);
            casbinUserResourcePermissionModels.forEach(casbinUserResourcePermissionModel -> {
                enforcer.addPermissionForUser(casbinUserResourcePermissionModel.getUserId(),
                        CASBIN_DOMAIN_PREFIX + userEntity.getDomainId(),
                        casbinUserResourcePermissionModel.getResourcePath(),
                        casbinUserResourcePermissionModel.getPermission());
            });
            enforcer.savePolicy();
            enforcer.loadPolicy();
        } catch (Exception e) {
            throw new RuntimeException("casbin handle policy failed");
        }
        return Boolean.TRUE;
    }

    //g2, /ask2, role_11
    @Override
    @Transactional
    public Boolean allocateRoleResource(Integer roleId, Integer resourceId) {
        RoleResourceEntity one = roleResourceService.getOne(Wrappers.<RoleResourceEntity>lambdaQuery().eq(RoleResourceEntity::getRoleId, roleId).eq(RoleResourceEntity::getResourceId, resourceId));
        if (one == null) {
            RoleResourceEntity roleResourceEntity = new RoleResourceEntity();
            roleResourceEntity.setResourceId(resourceId);
            roleResourceEntity.setRoleId(roleId);
            roleResourceEntity.setCreateTime(LocalDateTime.now());
            roleResourceEntity.setUpdateTime(LocalDateTime.now());
            roleResourceService.save(roleResourceEntity);
        }
        ResourceEntity resourceEntity = resourceService.getById(resourceId);

        try {
            enforcer.addNamedGroupingPolicy(CASBIN_POLICY_G2, resourceEntity.getResourcePath(), CASBIN_ROLE_PREFIX + roleId);
            enforcer.savePolicy();
            enforcer.loadPolicy();
        } catch (Exception e) {
            throw new RuntimeException("casbin handle policy failed");
        }
        return Boolean.TRUE;
    }

    @Override
    public List<CasbinUserResourcePermissionModel> getCasbinUserResourcePermissionModel(Integer userId, Integer roleId) {
        return this.getBaseMapper().getCasbinUserResourcePermissionModelByUserIdAndRoleId(userId, roleId);
    }
}
