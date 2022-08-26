package com.xiaoyi.base.project.qywx;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: --
 * @author：Bing
 * @date：2022/6/6 17:11
 * @version：1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class QywxMessageVo {

    private String touser = "@all";
    //private String toparty;
    //private String totag;
    private String msgtype = "news";
    private int agentid = 1000002;
    private News news;
    private int enable_id_trans = 0;
    private int enable_duplicate_check = 0;
    private int duplicate_check_interval = 1800;
}
