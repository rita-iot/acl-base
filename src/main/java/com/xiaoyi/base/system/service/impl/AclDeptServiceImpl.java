package com.xiaoyi.base.system.service.impl;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoyi.base.system.entity.AclDept;
import com.xiaoyi.base.system.mapper.AclDeptMapper;
import com.xiaoyi.base.system.service.AclDeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: --
 * @author：Bing
 * @date：2022/8/24 9:53
 * @version：1.0
 */
@SuppressWarnings("ALL")
@Service
public class AclDeptServiceImpl extends ServiceImpl<AclDeptMapper, AclDept> implements AclDeptService{
    @Resource
    private AclDeptMapper aclDeptMapper;

    @Override
    public IPage<AclDept> findBypage(AclDept aclDept) {
        return null;
    }

    @Override
    public List<Tree<String>> tree(AclDept aclDept) {
        //配置
        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
        // 自定义属性名 都要默认值的
        //treeNodeConfig.setWeightKey("order");
        treeNodeConfig.setIdKey("deptId");
        treeNodeConfig.setNameKey("deptName");
        //  排序字段
        treeNodeConfig.setWeightKey("create_time");
        // 最大递归深度
        treeNodeConfig.setDeep(3);
        QueryWrapper<AclDept> qw = new QueryWrapper<>();
        //  根据类型 查询 菜单
        //qw.eq(aclDept.getType() != null, "type", aclDept.getType());
        //qw.eq(aclDept.getParentId() != null, "parent_id", aclDept.getParentId());
        qw.orderByAsc("create_time");
        List<AclDept> list = this.list(qw);
        //List<SysMenu> list = sysMenuMapper.findAllByUserId(sysMenu,"1");
        List<Tree<String>> treeNodes = TreeUtil.build(list, "0", treeNodeConfig,
                (treeNode, tree) -> {
                    tree.setId(treeNode.getDeptId()+"");
                    tree.setParentId(treeNode.getParentId()+"");
                    //tree.setWeight(treeNode.getWeight());
                    tree.setName(treeNode.getDeptName());
                    // 扩展属性 ...
                    tree.putExtra("leader", treeNode.getLeader());
                    tree.putExtra("status", treeNode.getStatus());
                    tree.putExtra("create_time", treeNode.getCreateTime());
                    //tree.putExtra("other", new Object());
                });
        return treeNodes;
    }
}
