package com.base.example.primary.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
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
 * @date：2022/8/24 9:53
 * @version：1.0
 */
/**
    * 部门表
    */
@ApiModel(value="部门表")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "acl_dept")
public class AclDept implements Serializable {
    /**
     * 部门id
     */
    @TableId(value = "dept_id", type = IdType.INPUT)
    @ApiModelProperty(value="部门id")
    private Integer deptId;

    /**
     * 父部门id
     */
    @TableField(value = "parent_id")
    @ApiModelProperty(value="父部门id")
    private Integer parentId;

    /**
     * 祖级列表
     */
    @TableField(value = "ancestors")
    @ApiModelProperty(value="祖级列表")
    private String ancestors;

    /**
     * 部门名称
     */
    @TableField(value = "dept_name")
    @ApiModelProperty(value="部门名称")
    private String deptName;

    /**
     * 显示顺序
     */
    @TableField(value = "order_num")
    @ApiModelProperty(value="显示顺序")
    private Integer orderNum;

    /**
     * 负责人
     */
    @TableField(value = "leader")
    @ApiModelProperty(value="负责人")
    private String leader;

    /**
     * 联系电话
     */
    @TableField(value = "phone")
    @ApiModelProperty(value="联系电话")
    private String phone;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    @ApiModelProperty(value="邮箱")
    private String email;

    /**
     * 部门状态（0正常 1停用）
     */
    @TableField(value = "`status`")
    @ApiModelProperty(value="部门状态（0正常 1停用）")
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    @TableField(value = "del_flag")
    @ApiModelProperty(value="删除标志（0代表存在 2代表删除）")
    private String delFlag;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "update_time")
    @ApiModelProperty(value="更新时间")
    private Date updateTime;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "create_time")
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}
