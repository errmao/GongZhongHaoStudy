package com.xiaoshu.jyl.utils;

import com.alibaba.fastjson.JSONObject;
import com.xiaoshu.jyl.entity.token.AccessToken;

/**
 * 关于微信公众号access token工具类
 *
 * @author zhaow.zhu
 * @date 2020/3/2 15:13
 */
public class AccessTokenUtil {

    private static String appId = "wx463d77c010f7142a";
    private static String appsecret = "d2655d10a91ff210ce09dbbfaf037b51";
    private static String accessTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    /**
     * 获取token
     */
    private static String getToken() {
        String url = accessTokenUrl.replace("APPID", appId).replace("APPSECRET", appsecret);
        String result = HttpUtils.doGet(url, null);
        JSONObject jsonObject = JSONObject.parseObject(result);
        String accessToken = jsonObject.getString("access_token");
        String expiresIn = jsonObject.getString("expires_in");

        return "";
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        getToken();
    }
}