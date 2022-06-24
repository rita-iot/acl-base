

## MetaObjectHandler介绍

1. 编写MetaObjectHandler 实现类
2. 实体类上边加上@TableField(fill = FieldFill.INSERT_UPDATE)

## MetaObjectHandler介绍

MetaObjectHandler接口是mybatisPlus为我们提供的的一个扩展接口，我们可以利用这个接口在我们插入或者更新数据的时候，为一些字段指定默认值。实现这个需求的方法不止一种，在sql层面也可以做到，在建表的时候也可以指定默认值。

### 1：编写MetaObjectHandler 实现类

编写类实现MetaObjectHandler接口，重写里面的方法就是了。

```
/**
 * @author 张子行
 * @class mybatisPlus属性自动填充，对应的实体类字段上需要加@TableField(fill = FieldFill.INSERT_UPDATE)
 */
@Configuration
@Slf4j
public class autoFillConfig implements MetaObjectHandler {
    /**
     * @param
     * @method 插入时自动填充
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("插入时自动填充");
        this.setFieldValByName("stock", 1, metaObject);
    }

    /**
     * @param
     * @method 更新时自动填充
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("更新时自动填充");
        this.setFieldValByName("stock", -9090, metaObject);
    }
}
```

### 2：实体类上边加上@TableField(fill = FieldFill.INSERT_UPDATE)

指定进行属性填充的时机（更新、插入、或者更新和插入）

```
@TableField(fill = FieldFill.INSERT_UPDATE)
@ApiModelProperty(value = "商品库存")
private Integer stock;
```

## 注意点

### 这种情况不会进行属性填充，mybatisPlus指定字段更新，其他字段不会更新

```
  UpdateWrapper<Goods> goodsUpdateWrapper = new UpdateWrapper<>();
  goodsUpdateWrapper.eq("id", 30).set("name", "张子行666");
  goodsService.update(null, goodsUpdateWrapper);
```

### 这种情况会进行属性填充，指定了实体类

    Goods goods = new Goods();
    goods.setId(30).setName("zzh").setPrice(100D).setRemark("张子行5").setGoodsTypeId(666).setStock(10);
    goodsUpdateWrapper.eq("id", 30).set("name", "张子行666");
    goodsService.update(goods, goodsUpdateWrapper);
原文链接：https://blog.csdn.net/qq_42875345/article/details/113273533