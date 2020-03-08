package com.xiaoshu.jyl.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baidu.aip.ocr.AipOcr;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;

/**
 * 百度图片文字识别
 *
 * @author xxddds
 * @date 2020/3/7 18:45
 */
public class BaiduApiUtil {

    public static final String APP_ID = "18720387";
    public static final String API_KEY = "QfLGC47NKZZYYs3LlC6tbwsw";
    public static final String SECRET_KEY = "BAHamg4jq2HyzUezrq2Sn5a5En1d50en";

    private static AipOcr aipOcr;

    /**
     * 识别图片中的文字返回信息
     *
     * @param picUrl 图片路径
     * @return
     */
    public static String recoginzedImage(String picUrl) {
        // 初始化一个AipOcr
        AipOcr client = getInstance();

        // 调用接口
        org.json.JSONObject res = client.generalUrl(picUrl, new HashMap<String, String>());
        String json = res.toString();
        com.alibaba.fastjson.JSONObject obj = JSON.parseObject(json);
        JSONArray jsonArray = obj.getJSONArray("words_result");

        StringBuilder sb = new StringBuilder();
        for (Object jsonObject : jsonArray) {
            JSONObject o = JSONObject.parseObject(jsonObject.toString());
            sb.append(o.get("words"));
        }
        return sb.toString();
    }

    /**
     * 单例初始化
     *
     * @return
     */
    public static synchronized AipOcr getInstance() {
        if (null == aipOcr) {
            synchronized (BaiduApiUtil.class) {
                if (null == aipOcr) {
                    aipOcr = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
                }
            }
        }
        return aipOcr;
    }
}
