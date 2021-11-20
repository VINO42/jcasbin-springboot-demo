package io.github.vino42.domain.mapper;

import io.github.vino42.domain.entity.UserEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.vino42.domain.model.CasbinRoleResourceModel;
import io.github.vino42.domain.model.CasbinUserResourcePermissionModel;
import io.github.vino42.domain.model.CasbinUserRoleModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * =====================================================================================
 *
 * @Created :   2021/11/20 14:46:27
 * @Compiler :  jdk 11
 * @Author :    VINO
 * @Email : 38912428@qq.com
 * @Copyright : VINO
 * @Decription :  Mapper 接口
 * =====================================================================================
 */
@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {

    List<CasbinUserResourcePermissionModel> getCasbinUserResourcePermissionModel();

    List<CasbinUserRoleModel> getCasbinUserRoleModel();

    List<CasbinRoleResourceModel> getCasbinRoleResourceModel();


    List<CasbinUserResourcePermissionModel> getCasbinUserResourcePermissionModelByUserIdAndRoleId(Integer userId, Integer roleId);
}
