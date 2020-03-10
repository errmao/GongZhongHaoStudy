package com.xiaoshu.jyl.service.user.impl;

import com.alibaba.fastjson.JSONObject;
import org.jsoup.Connection.Response;
import com.xiaoshu.jyl.entity.user.UserInfo;
import com.xiaoshu.jyl.service.user.UserManagerService;
import com.xiaoshu.jyl.utils.AccessTokenUtil;
import com.xiaoshu.jyl.utils.HttpUtils;
import com.xiaoshu.jyl.utils.HttpsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * 用户管理实现
 *
 * @author zhaow.zhu
 * @date 2020/3/10 11:00
 */
@Service("userManagerService")
@Slf4j
public class UserManagerServiceImpl implements UserManagerService {

    /**
     * 获取用户基本信息(UnionID机制)
     *
     * @param openId 普通用户的标识，对当前公众号唯一
     * @return
     */
    @Override
    public UserInfo getUserInfo(String openId) {
        String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
        url = url.replace("ACCESS_TOKEN", AccessTokenUtil.getAccessToken()).replace("OPENID", openId);

        String data = HttpUtils.doGet(url, null);
        log.info("查询用户基本信息：{}", data);

        UserInfo userInfo = JSONObject.parseObject(data, UserInfo.class);
        return userInfo;
    }

    /**
     * 批量获取用户基本信息
     *
     * @return
     */
    @Override
    public String getUserInfoBatch() {
        String postData = "{\n" +
                          "    \"user_list\": [\n" +
                          "        {\n" +
                          "            \"openid\": \"oIzSpw7VW9TJd1cuTR7LxrydDqZE\", \n" +
                          "            \"lang\": \"zh_CN\"\n" +
                          "        }, \n" +
                          "        {\n" +
                          "            \"openid\": \"oIzSpw7VW9TJd1cuTR7LxrydDqZE\", \n" +
                          "            \"lang\": \"zh_CN\"\n" +
                          "        }\n" +
                          "    ]\n" +
                          "}";

        String url = "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=ACCESS_TOKEN";
        url = url.replace("ACCESS_TOKEN", AccessTokenUtil.getAccessToken());

        String data = HttpUtils.doPost(url, postData);
        log.info("批量获取用户基本信息：{}", data);
        return data;
    }

    /**
     * 获取用户列表
     *
     * @return
     */
    @Override
    public String getUserList() {
        // https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN&next_openid=NEXT_OPENID
        // NEXT_OPENID : 第一个拉取的OPENID，不填默认从头开始拉取
        String url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN";
        url = url.replace("ACCESS_TOKEN", AccessTokenUtil.getAccessToken());

        try {
            Response response = HttpsUtil.get(url);
            String data = response.body();
            log.info("批量获取用户基本信息：{}", data);
            return data;
        } catch (IOException e) {
            log.error("获取用户列表失败，失败信息：{}", e);
        }
        return null;
    }
}
