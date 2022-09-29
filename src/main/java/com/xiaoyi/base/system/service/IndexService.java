package com.xiaoyi.base.system.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;
/**
 * @description: --
 * @author：Bing
 * @date：2022/8/23 8:31
 * @version：1.0
 */
public interface IndexService {

    /**
     * 根据用户名获取用户登录信息
     * @param username
     * @return
     */
    Map<String, Object> getUserInfo(String username);

    /**
     * 根据用户名获取动态菜单
     * @param username
     * @return
     */
    List<JSONObject> getMenu(String username);
}
