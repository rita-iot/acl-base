package com.xiaoyi.base.framework.qywx;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: --
 * @author：Bing
 * @date：2022/6/6 17:16
 * @version：1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Articles {
    private String title;
    private String description;
    private String url;
    private String picurl = "http://res.mail.qq.com/node/ww/wwopenmng/images/independent/doc/test_pic_msg1.png";
    private String appid;
    private String pagepath;
}
