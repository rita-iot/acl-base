package com.base.example.primary.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.base.example.primary.entity.User;
import com.base.example.primary.mapper.UserMapper;
import com.base.example.primary.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 * @author testjava
 * @since 2020-01-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User selectByUsername(String username) {
        return baseMapper.selectOne(new QueryWrapper<User>().eq("username", username));
    }

    @Override
    public IPage<User> findPage(User user) {
        IPage<User> iPage = new Page<>(user.getCurrentPage(), user.getPageSize());
        return this.page(iPage, new QueryWrapper<User>().orderByDesc("gmt_create"));
    }

    @Override
    public Boolean findByUserName(User user) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("username", user.getUsername());
        List<User> list = this.list(qw);
        if (list.size() > 0) {
            return true;
        }
        return false;
    }
}
