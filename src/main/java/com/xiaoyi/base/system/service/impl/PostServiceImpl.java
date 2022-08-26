package com.xiaoyi.base.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoyi.base.system.entity.Post;
import com.xiaoyi.base.system.mapper.PostMapper;
import com.xiaoyi.base.system.service.PostService;
import org.springframework.stereotype.Service;
/**
 * @description: --
 * @author：Bing
 * @date：2022/3/26 21:49
 * @version：1.0
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements PostService {
    @Override
    public IPage<Post> findBypage(Post post) {
        IPage<Post> iPage = new Page<>(post.getCurrentPage(), post.getPageSize());
        return this.page(iPage, new QueryWrapper<Post>().orderByDesc("create_time"));
    }
}
