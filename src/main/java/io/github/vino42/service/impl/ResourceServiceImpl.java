package io.github.vino42.service.impl;

import io.github.vino42.domain.entity.ResourceEntity;
import io.github.vino42.domain.mapper.ResourceMapper;
import io.github.vino42.service.IResourceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * =====================================================================================
 *
 * @Created :   2021/11/20 20:43:07
 * @Compiler :  jdk 11
 * @Author :    VINO
 * @Copyright : VINO
 * @Decription :  服务实现类
 * =====================================================================================
 */
@Service
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, ResourceEntity> implements IResourceService {

}
