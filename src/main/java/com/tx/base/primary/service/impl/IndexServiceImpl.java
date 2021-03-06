package com.tx.base.primary.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.tx.base.exception.GuliException;
import com.tx.base.primary.entity.Role;
import com.tx.base.primary.entity.User;
import com.tx.base.primary.service.IndexService;
import com.tx.base.primary.service.PermissionService;
import com.tx.base.primary.service.RoleService;
import com.tx.base.primary.service.UserService;
import com.tx.base.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 根据用户名获取用户登录信息
     * @param username
     * @return
     */
    public Map<String, Object> getUserInfo(String username) {
        Map<String, Object> result = new HashMap<>();
        User user = userService.selectByUsername(username);
        if (null == user) {
            // 自定义异常返回
            // enum使用案例
            throw new GuliException(ResultCodeEnum.USER_NULL.getCode(), ResultCodeEnum.USER_NULL.getMessage());
        }
        //根据用户id查询获取角色
        List<Role> roleList = roleService.selectRoleByUserId(user.getId());
        List<String> roleNameList = roleList.stream().map(item -> item.getRoleName()).collect(Collectors.toList());
        if (roleNameList.size() == 0) {
            //前端框架必须返回一个角色，否则报错，如果没有角色，返回一个空角色
            roleNameList.add("");
        }
        //根据用户id查询获取操作权限值
        List<String> permissionValueList = permissionService.selectPermissionValueByUserId(user.getId());
        // 将权限列表放入到redis中
        redisTemplate.opsForValue().set(username, permissionValueList);
        result.put("name", user.getUsername());
        result.put("avatar", "xxxx");
        result.put("roles", roleNameList);
        result.put("permissionValueList", permissionValueList);
        return result;
    }

    /**
     * 根据用户名获取动态菜单
     * @param username
     * @return
     */
    public List<JSONObject> getMenu(String username) {
        User user = userService.selectByUsername(username);
        //根据用户id获取用户菜单权限
        List<JSONObject> permissionList = permissionService.selectPermissionByUserId(user.getId());
        return permissionList;
    }


}
