package com.xiaoyi.base.project.wechat.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaoyi.base.project.wechat.entity.WxUser;
import com.xiaoyi.base.project.wechat.mapper.WxUserMapper;
import com.xiaoyi.base.project.wechat.service.WxUserService;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.WxMpUserQuery;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import me.chanjar.weixin.mp.bean.result.WxMpUserList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @description: --
 * @author：Bing
 * @date：2022/8/25 16:58
 * @version：1.0
 */
@Service
public class WxUserServiceImpl extends ServiceImpl<WxUserMapper, WxUser> implements WxUserService {
    @Resource
    private WxUserMapper wxUserMapper;
    @Autowired
    private WxMpService wxMpService;

    @Override
    public IPage<WxUser> findBypage(WxUser wxUser) {
        IPage<WxUser> iPage = new Page<>(wxUser.getCurrentPage(), wxUser.getPageSize());
        QueryWrapper<WxUser> qw = new QueryWrapper<>();
        qw.orderByDesc("create_time");
        return this.page(iPage, qw);
    }

    @Override
    public void syncUserList() {
        wxUserMapper.removeAllUser();
        WxMpUserList wxMpUserList = null;
        try {
            wxMpUserList = wxMpService.getUserService().userList(null);
            List<String> openids = wxMpUserList.getOpenids();
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
                WxUser one = this.getOne(qw, false);
                if (one == null) {
                    this.save(wxUser);
                }
            }
        } catch (WxErrorException e) {
            throw new RuntimeException(e);
        }

    }
}


