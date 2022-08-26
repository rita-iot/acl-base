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
 * @date：2022/3/25 9:46
 * @version：1.0
 */
@ApiModel(value = "acl_emo")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "acl_emo")
@Data
public class AclEmo extends BaseEntity implements Serializable {

    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value = "")
    private Integer id;

    @TableField(value = "`text`")
    @ApiModelProperty(value = "")
    private String text;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "create_time")
    @ApiModelProperty(value = "")
    private Date createTime;

    private static final long serialVersionUID = 1L;
    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页")
    @TableField(exist = false)
    private Integer currentPage = 1;

    /**
     * 每页条数
     */
    @ApiModelProperty(value = "每页条数")
    @TableField(exist = false)
    private Integer pageSize = 10;
}
