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
    // 存储token
    private static AccessToken at;

    /**
     * 获取token
     */
    private static void getToken() {
        String url = accessTokenUrl.replace("APPID", appId).replace("APPSECRET", appsecret);
        String result = HttpUtils.doGet(url, null);
        JSONObject jsonObject = JSONObject.parseObject(result);
        String accessToken = jsonObject.getString("access_token");
        String expiresIn = jsonObject.getString("expires_in");
        // 创建token对象并保存
        at = new AccessToken(accessToken, expiresIn);
    }

    /**
     * 向外暴露获取access token的方法
     *
     * @return
     */
    public static String getAccessToken() {
        if (at == null || at.isExpired()) {
            getToken();
        }
        return at.getAccessToken();
    }

}