package com.xiaoyi.base.framework.qywx;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.xiaoyi.base.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: --企业微信消息推送
 * @author：Bing
 * @date：2022/6/6 16:53
 * @version：1.0
 */

@RestController
@RequestMapping("push/message")
@Api(tags = "消息推送")
public class QywxMessagePushController {

    /**
     * 获取CORPID
     */
    private static final String CORPID = "ww29ff21ee9838bb61";
    /**
     * 获取CORPSECRET
     */
    private static final String CORPSECRET = "gEQRNZaeeWcfLgKTfyXKqQ4IJlbFtZIW2dGvVhbXQZU";
    /**
     * 发送消息请求地址
     */
    private static final String PUSH_MESSAGE_URL = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=";

    /**
     * 获取access_token
     */
    private static final String ACCESS_TOKEN_URL = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=" + CORPID + "&corpsecret=" + CORPSECRET;

    /**
     * 存放access_token
     */
    private static final Map<String, Object> accessTokenMap = new HashMap<>();

    /**
     * 获取token
     * @return
     */
    public static String getAccessToken() {
        String s = HttpUtil.get(ACCESS_TOKEN_URL);
        Map map = JSONUtil.toBean(s, Map.class);
        String access_token = (String) map.get("access_token");
        accessTokenMap.put("access_token", access_token);
        return access_token;
    }

    /**
     * 推送消息
     * @param articles
     */
    @PostMapping("push")
    @ApiOperation("推送消息")
    public Result pushMessage1(@RequestBody Articles articles) {
        List<Articles> res = new ArrayList<>();
        res.add(articles);
        QywxMessageVo qywxMessageVo = new QywxMessageVo();
        qywxMessageVo.setNews(new News(res));
        if (accessTokenMap.size() <= 0) {
            getAccessToken();
        }
        String accessToken = (String) accessTokenMap.get("access_token");
        JSONObject jsonObject = JSONUtil.parseObj(qywxMessageVo, true);
        //Map<String, Object> paramMap = objectToMap(qywxMessageVo);
        String post = HttpUtil.post(PUSH_MESSAGE_URL + accessToken, jsonObject.toStringPretty());

        JSONObject jsonObject1 = JSONUtil.parseObj(post);
        return Result.ok(jsonObject1);
    }

    @GetMapping("/")
    @ApiOperation("推送消息")
    public Result pushMessage2(@RequestBody Articles articles) {
        List<Articles> res = new ArrayList<>();
        res.add(articles);
        QywxMessageVo qywxMessageVo = new QywxMessageVo();
        qywxMessageVo.setNews(new News(res));
        if (accessTokenMap.size() <= 0) {
            getAccessToken();
        }
        String accessToken = (String) accessTokenMap.get("access_token");
        JSONObject jsonObject = JSONUtil.parseObj(qywxMessageVo, true);
        //Map<String, Object> paramMap = objectToMap(qywxMessageVo);
        String post = HttpUtil.post(PUSH_MESSAGE_URL + accessToken, jsonObject.toStringPretty());

        JSONObject jsonObject1 = JSONUtil.parseObj(post);
        return Result.ok(jsonObject1);
    }


    /**
     * 对象转为map
     * @param object
     * @return
     */
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
