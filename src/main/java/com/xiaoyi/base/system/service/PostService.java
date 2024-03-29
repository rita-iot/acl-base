package com.xiaoyi.base.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiaoyi.base.system.entity.Post;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @description: --
 * @author：Bing
 * @date：2022/3/26 21:49
 * @version：1.0
 */
public interface PostService extends IService<Post> {

    /**
     * 分页查询
     * @param post
     * @return
     */
    IPage<Post> findBypage(Post post);
}
