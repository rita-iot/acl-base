package com.base.example.primary.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.base.example.primary.entity.AclEmo;

import java.util.List;

/**
 * @description: --
 * @author：Bing
 * @date：2022/3/24 15:19
 * @version：1.0
 */
public interface AclEmoService  extends IService<AclEmo> {

    /**
     * 查询所有
     * @return
     */
    List<AclEmo> findAll();

    /**
     * 分页查询
     * @param aclEmo
     * @return
     */
    IPage<AclEmo> page(AclEmo aclEmo);
}


