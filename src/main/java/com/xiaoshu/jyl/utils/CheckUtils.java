package com.xiaoshu.jyl.utils;

import java.util.Arrays;

/**
 * 微信公众号校验
 *
 * @author xxddds
 * @date 2020/2/15 15:16
 */
public class CheckUtils {

    private static final String TOKEN = "XXDDDS";

    /**
     * 微信公众号接入校验
     *
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    public static boolean checkSignature(String signature, String timestamp, String nonce) {
        String arr[] = new String[]{TOKEN, timestamp, nonce};
        // 排序
        Arrays.sort(arr);
        // 生成字符串
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        // sha1加密
        String temp = CommonUtils.shaEncode(sb.toString());
        // 与微信传的参数是否一致校验
        return temp.equals(signature);
    }
}
