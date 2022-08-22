package com.base.example.moning;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;

/**
 * @description: --
 * @author：Bing
 * @date：2022/8/22 13:34
 * @version：1.0
 */
@Component
public class PushMessage {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private WxMpService wxMpService;

    //@Scheduled(cron = "0/1 * * * * ? ")
    @Scheduled(cron = "0 0 7 * * ? ")
    public void pushMessage() throws Exception {
        String openid1 = "oHKof5twBeeebCQMA7N9lcY1rc7k";
        String openid2 = "oHKof5tGm_oGV5rmvcN5v27n-9NQ";
        List<String> list = new ArrayList<>();
        list.add(openid1);
        list.add(openid2);
        for (String openid : list) {
            WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                    .toUser(openid)//要推送的用户openid
                    .templateId("6g8rY4CQEg3oXVhv0UYNu3ZYIStTQUWUPndJjpFMQqs")//模板id
                    //.url("http://ggkt2.vipgz1.91tunnel.com/#/pay/" + orderId)//点击模板消息要访问的网址
                    .build();
            String now = DateUtil.now();
            Map<String, Object> weather = getWeather();
            Date date1 = DateUtil.date();
            String dateStr2 = "2022-04-03 12:00:00";
            Date date2 = DateUtil.parse(dateStr2);
            long betweenDay = DateUtil.between(date1, date2, DateUnit.DAY);

            String dateStr3 = "2022-10-23 00:00:00";
            Date date3 = DateUtil.parse(dateStr3);
            long birthDay = DateUtil.between(date1, date3, DateUnit.DAY);

            //3,如果是正式版发送消息，，这里需要配置你的信息
            templateMessage.addData(new WxMpTemplateData("first", now, "#009933"));
            templateMessage.addData(new WxMpTemplateData("keyword1", (String) weather.get("city"), "#009933"));
            templateMessage.addData(new WxMpTemplateData("keyword2", (String) weather.get("weather"), "#272727"));
            templateMessage.addData(new WxMpTemplateData("keyword3", (BigDecimal) weather.get("low") + "", "#272727"));
            templateMessage.addData(new WxMpTemplateData("keyword4", (BigDecimal) weather.get("high") + "", "#272727"));
            templateMessage.addData(new WxMpTemplateData("keyword5", betweenDay + "", "#272727"));
            templateMessage.addData(new WxMpTemplateData("keyword6", birthDay + "", "#272727"));
            templateMessage.addData(new WxMpTemplateData("keyword7", "今天又是想老婆的一天", "#272727"));
            templateMessage.addData(new WxMpTemplateData("keyword8", "记得签到哦!", "#cc0033"));
            String msg = wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
            System.out.println(msg);
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


    public static Map<String, Object> objectToMap(Object object) {
        Map<String, Object> dataMap = new HashMap<>();
        Class<?> clazz = object.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                dataMap.put(field.getName(), field.get(object));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return dataMap;
    }
}
