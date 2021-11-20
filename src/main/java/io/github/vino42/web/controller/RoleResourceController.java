package io.github.vino42.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.vino42.domain.entity.RoleResourceEntity;
import io.github.vino42.service.IRoleResourceService;
import io.github.vino42.support.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * =====================================================================================
 *
 * @Created :   2021/11/20 21:57:38
 * @Compiler :  jdk 11
 * @Author :    VINO
 * @Copyright : VINO
 * @Decription :  控制器
 * =====================================================================================
 */
@RestController
@RequestMapping("/roleResourceEntity")
public class RoleResourceController {

    @Autowired
    private IRoleResourceService relRoleResourceService;


    @GetMapping(value = "/page")
    public Result<IPage> getRoleResourceEntityPage(Page<RoleResourceEntity> page, RoleResourceEntity relRoleResource) {
        return Result.ok(relRoleResourceService.page(page, Wrappers.query(relRoleResource)));
    }


    @PostMapping(value = "/add")
    public Result create(@Valid @RequestBody RoleResourceEntity relRoleResource, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            return Result.illegalArgument();
        }
        return Result.ok(relRoleResourceService.save(relRoleResource));
    }


    @PutMapping(value = "/update")
    public Result update(@Valid @RequestBody RoleResourceEntity relRoleResource, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            return Result.illegalArgument();
        }
        return Result.ok(relRoleResourceService.updateById(relRoleResource));
    }


    @DeleteMapping(value = "/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        return Result.ok(relRoleResourceService.removeById(id));
    }
}