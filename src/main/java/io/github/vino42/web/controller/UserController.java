package io.github.vino42.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.vino42.domain.entity.UserEntity;
import io.github.vino42.service.IUserService;
import io.github.vino42.support.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * =====================================================================================
 *
 * @Created :   2021/11/20 21:58:37
 * @Compiler :  jdk 11
 * @Author :    VINO
 * @Copyright : VINO
 * @Decription :  控制器
 * =====================================================================================
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService sysUserService;


    @GetMapping(value = "/page")
    public Result<IPage> getUserEntityPage(Page<UserEntity> page, UserEntity sysUser) {
        return Result.ok(sysUserService.page(page, Wrappers.query(sysUser)));
    }


    @PostMapping(value = "/add")
    public Result create(@Valid @RequestBody UserEntity sysUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            return Result.illegalArgument();
        }
        return Result.ok(sysUserService.save(sysUser));
    }


    @PutMapping(value = "/update")
    public Result update(@Valid @RequestBody UserEntity sysUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            return Result.illegalArgument();
        }
        return Result.ok(sysUserService.updateById(sysUser));
    }


    @DeleteMapping(value = "/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        return Result.ok(sysUserService.removeById(id));
    }

    /**
     * @param userId
     * @param roleId
     * @return 为用户分匹配角色
     */
    //g, user_12, role_admin
    @PostMapping(value = "/allocate/role/{userId}")
    public Result allocateRole(@PathVariable Integer userId, @RequestParam Integer roleId) {
        return Result.ok(sysUserService.allocateRole(userId, roleId));
    }

    /**
     * @param roleId
     * @param resourceId
     * @return 为角色分配资源权限
     */
    //g2, /ask2, role_11
    @PostMapping(value = "/allocate/role/resource")
    public Result allocateRoleResource(@RequestParam Integer roleId, @RequestParam Integer resourceId) {
        return Result.ok(sysUserService.allocateRoleResource(roleId, resourceId));
    }
}
