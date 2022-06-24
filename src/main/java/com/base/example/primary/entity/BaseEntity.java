package com.base.example.primary.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @description: --
 * @author：Bing
 * @date：2022/1/12 16:10
 * @version：1.0
 */
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity {
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

    @JsonIgnore
    public Integer getCurrentPage() {
        return currentPage;
    }
    @JsonProperty
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
    @JsonIgnore
    public Integer getPageSize() {
        return pageSize;
    }
    @JsonProperty
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
