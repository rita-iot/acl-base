package com.base.example.primary.taskScheduler;

import cn.hutool.core.date.*;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.base.example.primary.component.ApplicationContextGetBeanHelper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @description: --
 * @author：Bing
 * @date：2022/8/23 21:38
 * @version：1.0
 */
@Slf4j
@Component
public class PushMessageRunnable implements Runnable {


    WxMpService wxMpService = ApplicationContextGetBeanHelper.getBean(WxMpService.class);


    @SneakyThrows
    @Override
    public void run() {
        String openid1 = "oHKof5twBeeebCQMA7N9lcY1rc7k";
        String openid2 = "oHKof5tGm_oGV5rmvcN5v27n-9NQ";
        List<String> list = new ArrayList<>();
        //list.add(openid1);
        list.add(openid2);
        for (String openid : list) {
            WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                    .toUser(openid)//要推送的用户openid
                    .templateId("nI-62Oab4508jwKxXt-XEnko32UZucgOJqn3geiNfV4")//模板id
                    //.url("http://ggkt2.vipgz1.91tunnel.com/#/pay/" + orderId)//点击模板消息要访问的网址
                    .build();
            String now = DateUtil.now();
            Map<String, Object> weather = getWeather();
            Date date1 = DateUtil.date();
            String dateStr2 = "2022-04-03 00:00:00";
            Date date2 = DateUtil.parse(dateStr2);
            long betweenDay = DateUtil.between(date1, date2, DateUnit.DAY);

            String dateStr3 = "2022-10-23 00:00:00";
            Date date3 = DateUtil.parse(dateStr3);
            long birthDay = DateUtil.between(date1, date3, DateUnit.DAY);
            DateTime date = DateUtil.date();
            // 获取农历日期
            ChineseDate chineseDate = new ChineseDate(date);
            // 获取星期
            Week week = DateUtil.dayOfWeekEnum(date);

            //3,如果是正式版发送消息，，这里需要配置你的信息
            templateMessage.addData(new WxMpTemplateData("first", now, "#009933"));
            templateMessage.addData(new WxMpTemplateData("second", chineseDate.toString() + " " + week.toChinese(), "#003199"));
            templateMessage.addData(new WxMpTemplateData("keyword1", (String) weather.get("city"), "#009933"));
            templateMessage.addData(new WxMpTemplateData("keyword2", (String) weather.get("weather"), "#272727"));
            templateMessage.addData(new WxMpTemplateData("keyword3", (BigDecimal) weather.get("low") + "度", "#272727"));
            templateMessage.addData(new WxMpTemplateData("keyword4", (BigDecimal) weather.get("high") + "度", "#ff0033"));
            templateMessage.addData(new WxMpTemplateData("keyword5", betweenDay + "", "#ff0033"));
            templateMessage.addData(new WxMpTemplateData("keyword6", birthDay + "", "#ff0033"));
            templateMessage.addData(new WxMpTemplateData("keyword7", "今天又是想宝宝的一天!", "#009933"));
            templateMessage.addData(new WxMpTemplateData("keyword8", "记得签到哦!", "#ff0033"));
            String msg = wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
            log.info("PushMessage running..."+msg);
        }
    }
    public static Map<String, Object> getWeather() {
        String wea_url = "https://autodev.openspeech.cn/csp/api/v2.1/weather?openId=aiuicus&clientType=android&sign=android&city=%E6%B1%9D%E5%B7%9E&needMoreData=true&pageNo=1&pageSize=1";
        String s = HttpUtil.get(wea_url);
        JSONObject jsonObject = JSONUtil.parseObj(s);
        Map data = jsonObject.get("data", Map.class);
        List<Map<String, Object>> list = (List<Map<String, Object>>) data.get("list");
        Map<String, Object> a = list.get(0);
        String city = (String) a.get("city");
        String weather = (String) a.get("weather");
        BigDecimal low = (BigDecimal) a.get("low");
        BigDecimal high = (BigDecimal) a.get("high");
        return a;
    }
}
