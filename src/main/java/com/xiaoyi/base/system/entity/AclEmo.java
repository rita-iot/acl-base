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
 * @date：2022/8/26 15:37
 * @version：1.0
 */
@ApiModel(value = "acl_emo")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "acl_emo")
public class AclEmo extends BaseEntity implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "id")
    private Integer id;

    /**
     * 原文
     */
    @TableField(value = "`text`")
    @ApiModelProperty(value = "原文")
    private String text;

    /**
     * 翻译
     */
    @TableField(value = "content")
    @ApiModelProperty(value = "翻译")
    private String content;

    /**
     * 图片路径
     */
    @TableField(value = "img_url")
    @ApiModelProperty(value = "图片路径")
    private String imgUrl;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}
