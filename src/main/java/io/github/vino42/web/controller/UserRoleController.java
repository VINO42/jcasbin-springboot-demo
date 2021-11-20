package io.github.vino42.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.vino42.domain.entity.UserRoleEntity;
import io.github.vino42.service.IUserRoleService;
import io.github.vino42.support.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * =====================================================================================
 *
 * @Created :   2021/11/20 21:58:25
 * @Compiler :  jdk 11
 * @Author :    VINO
 * @Copyright : VINO
 * @Decription :  控制器
 * =====================================================================================
 */
@RestController
@RequestMapping("/userRoleEntity")
public class UserRoleController {

    @Autowired
    private IUserRoleService relUserRoleService;


    @GetMapping(value = "/page")
    public Result<IPage> getUserRoleEntityPage(Page<UserRoleEntity> page, UserRoleEntity relUserRole) {
        return Result.ok(relUserRoleService.page(page, Wrappers.query(relUserRole)));
    }


    @PostMapping(value = "/add")
    public Result create(@Valid @RequestBody UserRoleEntity relUserRole, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return Result.illegalArgument();
        }
        return Result.ok(relUserRoleService.save(relUserRole));
    }


    @PutMapping(value = "/update")
    public Result update(@Valid @RequestBody UserRoleEntity relUserRole, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return Result.illegalArgument();
        }
        return Result.ok(relUserRoleService.updateById(relUserRole));
    }


    @DeleteMapping(value = "/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        return Result.ok(relUserRoleService.removeById(id));
    }
}
