package io.github.vino42.service.impl;

import io.github.vino42.domain.entity.UserRoleEntity;
import io.github.vino42.domain.mapper.UserRoleMapper;
import io.github.vino42.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * =====================================================================================
 *
 * @Created :   2021/11/20 14:03:29
 * @Compiler :  jdk 11
 * @Author :    VINO
 * @Copyright : VINO
 * @Decription :  服务实现类
 * =====================================================================================
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRoleEntity> implements IUserRoleService {

}
