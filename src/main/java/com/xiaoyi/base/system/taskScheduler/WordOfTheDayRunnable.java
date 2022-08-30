package com.xiaoyi.base.system.taskScheduler;

import cn.hutool.core.date.ChineseDate;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.Week;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiaoyi.base.core.redis.RedisService;
import com.xiaoyi.base.project.wechat.entity.WxUser;
import com.xiaoyi.base.project.wechat.service.WxUserService;
import com.xiaoyi.base.system.cpt.ApplicationContextGetBeanHelper;
import com.xiaoyi.base.system.entity.AclEmo;
import com.xiaoyi.base.system.service.AclEmoService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;

import java.util.List;

/**
 * @description: -- 词霸每日一句推送任务
 * @author：Bing
 * @date：2022/8/26 8:50
 * @version：1.0
 */
@Slf4j
public class WordOfTheDayRunnable implements Runnable {
    /**
     * 在没有交给spring管理的类中注入service
     */
    WxMpService wxMpService = ApplicationContextGetBeanHelper.getBean(WxMpService.class);
    WxUserService wxUserService = ApplicationContextGetBeanHelper.getBean(WxUserService.class);
    AclEmoService aclEmoService = ApplicationContextGetBeanHelper.getBean(AclEmoService.class);
    RedisService redisService = ApplicationContextGetBeanHelper.getBean(RedisService.class);

    @SneakyThrows
    @Override
    public void run() {
        DateTime date = DateUtil.date();
        String format = DateUtil.format(date, "yyyy-MM-dd");
        String url = "http://sentence.iciba.com/index.php?c=dailysentence&m=getdetail&title=" + format;
        String res = HttpUtil.get(url);
        JSONObject jsonObject = JSONUtil.parseObj(res);
        //String errmsg = (String) jsonObject.get("errmsg");
        //String title = (String) jsonObject.get("title");
        String content = (String) jsonObject.get("content");
        String note = (String) jsonObject.get("note");
        //String translation = (String) jsonObject.get("translation");
        //String picture = (String) jsonObject.get("picture");
        String picture2 = (String) jsonObject.get("picture2");
        //String picture3 = (String) jsonObject.get("picture3");
        //String caption = (String) jsonObject.get("caption");
        QueryWrapper<WxUser> qw = new QueryWrapper<>();
        qw.eq("status", 1);
        List<WxUser> list = wxUserService.list(qw);

        String now = DateUtil.now();
        // 获取农历日期
        ChineseDate chineseDate = new ChineseDate(date);
        // 获取星期
        Week week = DateUtil.dayOfWeekEnum(date);
        for (WxUser wxUser : list) {
            WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                    .toUser(wxUser.getOpenId())//要推送的用户openid
                    .templateId("VvddfiwmIbOnDvjHbUqoQX9G6lnf0MIHHzCDOb5U6Yg")//模板id
                    .url(picture2)//点击模板消息要访问的网址
                    .build();
            templateMessage.addData(new WxMpTemplateData("first", now, "#009933"));
            templateMessage.addData(new WxMpTemplateData("second", chineseDate.toString() + " " + week.toChinese(), "#003199"));
            templateMessage.addData(new WxMpTemplateData("keyword1", note, "#009933"));
            templateMessage.addData(new WxMpTemplateData("keyword2", content, "#272727"));
            //templateMessage.addData(new WxMpTemplateData("keyword8", "记得签到哦!", "#ff0033"));
            String msg = wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
            log.info("WordOfTheDayRunnable running..." + msg);
        }
        // 设置1天保存一次
        Boolean aclEmoSave = redisService.hasKey("aclEmoSave");
        if (aclEmoSave) {
            log.info("当天已保存过，不在保存");
        } else {
            AclEmo aclEmo = new AclEmo();
            aclEmo.setText(note);
            aclEmo.setContent(content);
            aclEmo.setImgUrl(picture2);
            aclEmoService.save(aclEmo);
            redisService.set("aclEmoSave", 3600);
        }
    }
}
