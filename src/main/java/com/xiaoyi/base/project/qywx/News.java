package com.xiaoyi.base.project.qywx;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @description: --
 * @author：Bing
 * @date：2022/6/6 17:15
 * @version：1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class News {
    private List<Articles> articles;
}
