package com.base.example.primary.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.base.example.primary.entity.UserRole;
import com.base.example.primary.mapper.UserRoleMapper;
import com.base.example.primary.service.UserRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-01-12
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
