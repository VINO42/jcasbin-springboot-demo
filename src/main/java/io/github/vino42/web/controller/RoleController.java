package io.github.vino42.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.vino42.domain.entity.RoleEntity;
import io.github.vino42.service.IRoleService;
import io.github.vino42.support.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * =====================================================================================
 *
 * @Created :   2021/11/20 21:58:35
 * @Compiler :  jdk 11
 * @Author :    VINO
 * @Copyright : VINO
 * @Decription :  控制器
 * =====================================================================================
 */
@RestController
@RequestMapping("/roleEntity")
public class RoleController {

    @Autowired
    private IRoleService sysRoleService;


    @GetMapping(value = "/page")
    public Result<IPage> getRoleEntityPage(Page<RoleEntity> page, RoleEntity sysRole) {
        return Result.ok(sysRoleService.page(page, Wrappers.query(sysRole)));
    }


    @PostMapping(value = "/add")
    public Result create(@Valid @RequestBody RoleEntity sysRole, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            return Result.illegalArgument();
        }
        return Result.ok(sysRoleService.save(sysRole));
    }


    @PutMapping(value = "/update")
    public Result update(@Valid @RequestBody RoleEntity sysRole, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            return Result.illegalArgument();
        }
        return Result.ok(sysRoleService.updateById(sysRole));
    }


    @DeleteMapping(value = "/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        return Result.ok(sysRoleService.removeById(id));
    }
}
