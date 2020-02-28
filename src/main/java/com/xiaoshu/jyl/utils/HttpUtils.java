package com.xiaoshu.jyl.utils;

import java.net.MalformedURLException;

/**
 * 发送http请求
 *
 * @author zhaow.zhu
 * @date 2020/2/28 15:10
 */
public class HttpUtils {

    /**
     * 获取微信公众号access token请求地址
     */
    private static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    private String AppID = "wx463d77c010f7142a";
    private String appsecret = "d2655d10a91ff210ce09dbbfaf037b51";

    /**
     * 发送http get请求
     *
     * @param url 请求地址
     * @return
     */
    public static String sendGet(String url) {

        return null;
    }
}
