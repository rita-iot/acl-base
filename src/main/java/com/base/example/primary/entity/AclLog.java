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
 * @date：2022/3/29 11:30
 * @version：1.0
 */
@ApiModel(value = "acl_log")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "acl_log")
public class AclLog extends BaseEntity implements Serializable {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 日志类型，1登录日志，2操作日志
     */
    @TableField(value = "`type`")
    @ApiModelProperty(value = "日志类型，1登录日志，2操作日志")
    private String type;

    /**
     * 标题
     */
    @TableField(value = "title")
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * ip
     */
    @TableField(value = "remote_ip")
    @ApiModelProperty(value = "ip")
    private String remoteIp;

    /**
     * url
     */
    @TableField(value = "request_url")
    @ApiModelProperty(value = "url")
    private String requestUrl;

    /**
     * 请求方法
     */
    @TableField(value = "`method`")
    @ApiModelProperty(value = "请求方法")
    private String method;

    /**
     * 请求参数
     */
    @TableField(value = "params")
    @ApiModelProperty(value = "请求参数")
    private String params;

    /**
     * 请求时长 ms
     */
    @TableField(value = "opsTime")
    @ApiModelProperty(value = "请求时长 ms")
    private Integer opstime;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField(value = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 备注
     */
    @TableField(value = "remarks")
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 创建人
     */
    @TableField(value = "create_by")
    @ApiModelProperty(value = "创建人")
    private String createBy;

    /**
     * 请求方式
     */
    @TableField(value = "request_type")
    @ApiModelProperty(value = "请求方式")
    private String requestType;

    private static final long serialVersionUID = 1L;
}
