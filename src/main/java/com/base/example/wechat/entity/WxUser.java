package com.base.example.wechat.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: --
 * @author：Bing
 * @date：2022/8/25 17:17
 * @version：1.0
 */

/**
 * wx_user
 */
@ApiModel(value = "wx_user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "wx_user")
public class WxUser implements Serializable {
    /**
     * 用户的标识，对当前公众号唯一
     */
    @TableId(value = "open_id", type = IdType.INPUT)
    @ApiModelProperty(value = "用户的标识，对当前公众号唯一")
    private String openId;

    /**
     * nickname
     */
    @TableField(value = "nickname")
    @ApiModelProperty(value = "nickname")
    private String nickname;

    /**
     * 性别描述信息：男、女、未知等.
     */
    @TableField(value = "sex_desc")
    @ApiModelProperty(value = "性别描述信息：男、女、未知等.")
    private String sexDesc;

    /**
     * 性别表示：1，2等数字.
     */
    @TableField(value = "sex")
    @ApiModelProperty(value = "性别表示：1，2等数字.")
    private Integer sex;

    /**
     * 用户的语言，简体中文为zh_CN
     */
    @TableField(value = "`language`")
    @ApiModelProperty(value = "用户的语言，简体中文为zh_CN")
    private String language;

    /**
     * city
     */
    @TableField(value = "city")
    @ApiModelProperty(value = "city")
    private String city;

    /**
     * province
     */
    @TableField(value = "province")
    @ApiModelProperty(value = "province")
    private String province;

    /**
     * country
     */
    @TableField(value = "country")
    @ApiModelProperty(value = "country")
    private String country;

    /**
     * headImgUrl
     */
    @TableField(value = "head_img_url")
    @ApiModelProperty(value = "headImgUrl")
    private String headImgUrl;

    /**
     * 用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
     */
    @TableField(value = "subscribe_time")
    @ApiModelProperty(value = "用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间")
    private Date subscribeTime;

    /**
     * remark
     */
    @TableField(value = "remark")
    @ApiModelProperty(value = "remark")
    private String remark;

    /**
     * groupId
     */
    @TableField(value = "group_id")
    @ApiModelProperty(value = "groupId")
    private Integer groupId;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    private static final long serialVersionUID = 1L;
}