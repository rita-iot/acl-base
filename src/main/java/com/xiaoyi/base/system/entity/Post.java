package com.xiaoyi.base.system.entity;

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
 * @date：2022/3/26 21:49
 * @version：1.0
 */
@ApiModel(value="com-tx-base-primary-entity-Post")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "acl_post")
public class Post extends BaseEntity implements Serializable {
    /**
     * 岗位ID
     */
    @TableId(value = "post_id", type = IdType.INPUT)
    @ApiModelProperty(value="岗位ID")
    private Long postId;

    /**
     * 岗位编码
     */
    @TableField(value = "post_code")
    @ApiModelProperty(value="岗位编码")
    private String postCode;

    /**
     * 岗位名称
     */
    @TableField(value = "post_name")
    @ApiModelProperty(value="岗位名称")
    private String postName;

    /**
     * 显示顺序
     */
    @TableField(value = "post_sort")
    @ApiModelProperty(value="显示顺序")
    private Integer postSort;

    /**
     * 状态（0正常 1停用）
     */
    @TableField(value = "`status`")
    @ApiModelProperty(value="状态（0正常 1停用）")
    private String status;

    /**
     * 创建者
     */
    @TableField(value = "create_by")
    @ApiModelProperty(value="创建者")
    private String createBy;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "create_time")
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
     * 更新者
     */
    @TableField(value = "update_by")
    @ApiModelProperty(value="更新者")
    private String updateBy;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "update_time")
    @ApiModelProperty(value="更新时间")
    private Date updateTime;

    /**
     * 备注
     */
    @TableField(value = "remark")
    @ApiModelProperty(value="备注")
    private String remark;

    private static final long serialVersionUID = 1L;
}
