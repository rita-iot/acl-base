package com.base.example.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @description: --
 * @author：Bing
 * @date：2022/1/12 10:21
 * @version：1.0
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Page<T> {
    private Integer currentPage;// 当前页
    private Integer pageSize;// 每页条数
    private Integer totalPage;// 总页数
    private Integer totalCount;// 总条数
    private List<T> list;
}
