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
 * @date：2022/8/23 8:31
 * @version：1.0
 */

/**
 * 动态定时任务表
 */
@ApiModel(value = "动态定时任务表")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "acl_task")
public class AclTask extends BaseEntity implements Serializable {
    /**
     * 定时任务id
     */
    @TableId(value = "task_id", type = IdType.INPUT)
    @ApiModelProperty(value = "定时任务id")
    private Integer taskId;

    /**
     * 定时任务名称
     */
    @TableField(value = "task_name")
    @ApiModelProperty(value = "定时任务名称")
    private String taskName;

    /**
     * 定时任务描述
     */
    @TableField(value = "task_desc")
    @ApiModelProperty(value = "定时任务描述")
    private String taskDesc;

    /**
     * 定时任务Cron表达式
     */
    @TableField(value = "task_exp")
    @ApiModelProperty(value = "定时任务Cron表达式")
    private String taskExp;

    /**
     * 定时任务状态，0停用 1启用
     */
    @TableField(value = "task_status")
    @ApiModelProperty(value = "定时任务状态，0停用 1启用")
    private Integer taskStatus;

    /**
     * 定时任务的Runnable任务类完整路径
     */
    @TableField(value = "task_class")
    @ApiModelProperty(value = "定时任务的Runnable任务类完整路径")
    private String taskClass;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}
