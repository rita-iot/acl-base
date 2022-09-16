package com.xiaoyi.base.core.task;


import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.xiaoyi.base.framework.qywx.Articles;
import com.xiaoyi.base.framework.qywx.News;
import com.xiaoyi.base.framework.qywx.QywxMessageVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class SentenceDayTiming {

    /**
     * 获取CORPID
     */
    private static String CORPID = "ww29ff21ee9838bb61";
    /**
     * 获取CORPSECRET
     */
    private static String CORPSECRET = "gEQRNZaeeWcfLgKTfyXKqQ4IJlbFtZIW2dGvVhbXQZU";
    /**
     * 发送消息请求地址
     */
    private static String PUSH_MESSAGE_URL = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=";

    /**
     * 获取access_token
     */
    private static String ACCESS_TOKEN_URL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=" + CORPID + "&corpsecret=" + CORPSECRET;

    /**
     * 每日一句 每天7点半推送
     */
    //@Scheduled(cron = "0 40 7 * * ? ")
    public void sentenceDay() {
        DateTime date = DateUtil.date();
        String format = DateUtil.format(date, "yyyy-MM-dd");
        String url = "http://sentence.iciba.com/index.php?c=dailysentence&m=getdetail&title=" + format;
        String res = HttpUtil.get(url);
        JSONObject jsonObject = JSONUtil.parseObj(res);
        String errmsg = (String) jsonObject.get("errmsg");
        String title = (String) jsonObject.get("title");
        String content = (String) jsonObject.get("content");
        String note = (String) jsonObject.get("note");
        String translation = (String) jsonObject.get("translation");
        String picture = (String) jsonObject.get("picture");
        String picture2 = (String) jsonObject.get("picture2");
        String picture3 = (String) jsonObject.get("picture3");
        String caption = (String) jsonObject.get("caption");
        Articles articles = new Articles();
        articles.setTitle(title + " 每日一言");
        //articles.setDescription(content + note);
        articles.setDescription(content + "\n" + note);
        articles.setUrl(picture);
        articles.setPicurl(picture);
        List<Articles> result = new ArrayList<>();
        result.add(articles);
        QywxMessageVo qywxMessageVo = new QywxMessageVo();
        qywxMessageVo.setTouser("");
        qywxMessageVo.setNews(new News(result));
        String accessToken = getAccessToken();
        JSONObject jsonObject3 = JSONUtil.parseObj(qywxMessageVo, true);
        //Map<String, Object> paramMap = objectToMap(qywxMessageVo);
        String post = HttpUtil.post(PUSH_MESSAGE_URL + accessToken, jsonObject3.toStringPretty());
        log.debug(post);
    }

    /**
     * 获取token
     * @return
     */
    public static String getAccessToken() {
        String s = HttpUtil.get(ACCESS_TOKEN_URL);
        Map map = JSONUtil.toBean(s, Map.class);
        String access_token = (String) map.get("access_token");
        //accessTokenMap.put("access_token", access_token);
        return access_token;
    }
}
