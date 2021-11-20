package io.github.vino42.web.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.vino42.domain.entity.ResourceEntity;
import io.github.vino42.service.IResourceService;
import io.github.vino42.support.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * =====================================================================================
 *
 * @Created :   2021/11/20 21:58:32
 * @Compiler :  jdk 11
 * @Author :    VINO
 * @Copyright : VINO
 * @Decription :  控制器
 * =====================================================================================
 */
@RestController
@RequestMapping("/resourceEntity")
public class ResourceController {

    @Autowired
    private IResourceService sysResourceService;


    @GetMapping(value = "/page")
    public Result<IPage> getResourceEntityPage(Page<ResourceEntity> page, ResourceEntity sysResource) {
        return Result.ok(sysResourceService.page(page, Wrappers.query(sysResource)));
    }


    @PostMapping(value = "/add")
    public Result create(@Valid @RequestBody ResourceEntity sysResource, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return Result.illegalArgument();
        }
        return Result.ok(sysResourceService.save(sysResource));
    }


    @PutMapping(value = "/update")
    public Result update(@Valid @RequestBody ResourceEntity sysResource, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return Result.illegalArgument();
        }
        return Result.ok(sysResourceService.updateById(sysResource));
    }


    @DeleteMapping(value = "/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        return Result.ok(sysResourceService.removeById(id));
    }
}
