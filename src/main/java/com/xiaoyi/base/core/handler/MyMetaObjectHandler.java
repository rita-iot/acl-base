package com.xiaoyi.base.core.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
/**
 * @description: --
 * @author：Bing
 * @date：2022/8/23 8:31
 * @version：1.0
 * 前端传值添加默认值
 * 给对象属性添加默认值
 * MetaObjectHandler接口是mybatisPlus为我们提供的的一个扩展接口，我们可以利用这个接口在我们插入或者更新数据的时候，
 * 为一些字段指定默认值。实现这个需求的方法不止一种，在sql层面也可以做到，在建表的时候也可以指定默认值。
 * 用法：
 * 1. 编写MetaObjectHandler 实现类
 * 2. 实体类上边加上@TableField(fill = FieldFill.INSERT_UPDATE)
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    /**
     * 新增方法触发
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        //属性名称，不是字段名称
        //this.setFieldValByName("gmtCreate", new Date(), metaObject);
        //this.setFieldValByName("gmtModified", new Date(), metaObject);
    }

    /**
     * 修改方法触发
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        //this.setFieldValByName("gmtModified", new Date(), metaObject);
    }
}
