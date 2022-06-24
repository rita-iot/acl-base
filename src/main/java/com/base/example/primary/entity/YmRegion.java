package com.base.example.primary.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: --
 * @author：Bing
 * @date：2021/12/3 10:43
 * @version：1.0
 */
@ApiModel(value = "YmRegion")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "ym_region")
public class YmRegion implements Serializable {
    public static final String COL_REGION_ID = "region_id";
    public static final String COL_REGION_NAME = "region_name";
    public static final String COL_REGION_CODE = "region_code";
    public static final String COL_REGION_PARENT_ID = "region_parent_id";
    public static final String COL_REGION_LEVEL = "region_level";
    public static final String COL_CREATE_USER = "create_user";
    public static final String COL_CREATE_TIME = "create_time";
    public static final String COL_UPDATE_USER = "update_user";
    public static final String COL_UPDATE_TIME = "update_time";
    public static final String COL_REMARKS = "remarks";
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @TableId(value = "region_id", type = IdType.AUTO)
    @ApiModelProperty(value = "id")
    private String regionId;
    /**
     * 地区名字
     */
    @TableField(value = "region_name")
    @ApiModelProperty(value = "地区名字")
    private String regionName;
    /**
     * 地区编号
     */
    @TableField(value = "region_code")
    @ApiModelProperty(value = "地区编号")
    private String regionCode;
    /**
     * 父级id
     */
    @TableField(value = "region_parent_id")
    @ApiModelProperty(value = "父级id")
    private String regionParentId;
    /**
     * 层级（1 省 2市 3县）
     */
    @TableField(value = "region_level")
    @ApiModelProperty(value = "层级（1 省 2市 3县）")
    private String regionLevel;
    /**
     * 创建人
     */
    @TableField(value = "create_user")
    @ApiModelProperty(value = "创建人")
    private String createUser;
    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    /**
     * 更新人
     */
    @TableField(value = "update_user")
    @ApiModelProperty(value = "更新人")
    private String updateUser;
    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
    /**
     * 备注
     */
    @TableField(value = "remarks")
    @ApiModelProperty(value = "备注")
    private String remarks;
}
