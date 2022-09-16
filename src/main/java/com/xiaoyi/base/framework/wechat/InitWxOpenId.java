package com.xiaoyi.base.framework.wechat;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaoyi.base.framework.entity.WxUser;
import com.xiaoyi.base.framework.service.WxUserService;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.WxMpUserQuery;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.chanjar.weixin.mp.bean.result.WxMpUserList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @description: --
 * @author：Bing
 * @date：2022/8/25 16:28
 * @version：1.0
 */
@Component
public class InitWxOpenId {
    @Autowired
    private WxMpService wxMpService;
    @Autowired
    private WxUserService wxUserService;

    //@Scheduled(cron = "0/1 * * * * ? ")
    public void getOpenId() throws WxErrorException {
        WxMpUserList wxMpUserList = wxMpService.getUserService().userList(null);
        List<String> openids = wxMpUserList.getOpenids();
        //for (String s:openids){
        //    WxMpUser wxMpUser = wxMpService.getUserService().userInfo(s);
        //    System.out.println(wxMpUser.toString());
        //}
        WxMpUserQuery wxMpUserQuery = new WxMpUserQuery();
        //wxMpUserQuery.
        List<WxMpUser> wxMpUsers = wxMpService.getUserService().userInfoList(openids);
        for (WxMpUser wxMpUser : wxMpUsers) {
            Date date = new Date(wxMpUser.getSubscribeTime());
            WxUser wxUser = new WxUser();
            BeanUtil.copyProperties(wxMpUser, wxUser);
            wxUser.setSubscribeTime(date);
            QueryWrapper<WxUser> qw = new QueryWrapper<>();
            qw.eq("open_id", wxMpUser.getOpenId());
            WxUser one = wxUserService.getOne(qw, false);
            if (one == null) {
                wxUserService.save(wxUser);
            }
        }
    }
}
