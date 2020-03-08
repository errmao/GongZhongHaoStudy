package com.xiaoshu.jyl.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 发送http请求
 *
 * @author zhaow.zhu
 * @date 2020/2/28 15:10
 */
@Slf4j
public class HttpUtils {
    /**
     * @param url    请求路径
     * @param params 参数
     * @Title: doGet
     * @Description: get方式
     * @author Mundo
     */
    public static String doGet(String url, Map<String, String> params) {
        // 返回结果
        String result = "";
        // 创建HttpClient对象
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = null;
        try {
            // 拼接参数,可以用URIBuilder,也可以直接拼接在？传值，拼在url后面，如下--httpGet = new
            // HttpGet(uri+"?id=123");
            URIBuilder uriBuilder = new URIBuilder(url);
            if (null != params && !params.isEmpty()) {
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    uriBuilder.addParameter(entry.getKey(), entry.getValue());
                }
            }
            URI uri = uriBuilder.build();
            // 创建get请求
            httpGet = new HttpGet(uri);
            log.info("访问路径：" + uri);
            HttpResponse response = httpClient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {// 返回200，请求成功
                // 结果返回
                result = EntityUtils.toString(response.getEntity());
                log.info("请求成功！，返回数据：" + result);
            } else {
                log.info("请求失败！");
            }
        } catch (Exception e) {
            log.info("请求失败!");
            log.error(ExceptionUtils.getStackTrace(e));
        } finally {
            // 释放连接
            if (null != httpGet) {
                httpGet.releaseConnection();
            }
        }
        return result;
    }

    /**
     * @param url
     * @param params
     * @return
     * @Title: doPost
     * @Description: post请求
     * @author Mundo
     */
    public static String doPost(String url, Map<String, String> params) {
        String result = "";
        // 创建httpclient对象
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);
        try { // 参数键值对
            if (null != params && !params.isEmpty()) {
                List<NameValuePair> pairs = new ArrayList<NameValuePair>();
                NameValuePair pair = null;
                for (String key : params.keySet()) {
                    pair = new BasicNameValuePair(key, params.get(key));
                    pairs.add(pair);
                }
                // 模拟表单
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(pairs);
                httpPost.setEntity(entity);
            }
            log.info("访问路径：" + url);
            HttpResponse response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                result = EntityUtils.toString(response.getEntity(), "utf-8");
                log.info("返回数据：>>>" + result);
            } else {
                log.info("请求失败！，url:" + url);
            }
        } catch (Exception e) {
            log.error("请求失败");
            log.error(ExceptionUtils.getStackTrace(e));
            e.printStackTrace();
        } finally {
            if (null != httpPost) {
                // 释放连接
                httpPost.releaseConnection();
            }
        }
        return result;
    }

    /**
     * post 发送 String 类型数据
     *
     * @param url  地址
     * @param data 数据
     * @return
     * @throws Exception
     */
    public static String doPost(String url, String data) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");
        httpPost.setHeader("Accept", "application/json");
        httpPost.setEntity(new StringEntity(data, StandardCharsets.UTF_8));
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("请求发送失败，请求地址：{}", url);
            log.error("请求发送失败，异常信息：{}", e);
        }
        HttpEntity entity = response.getEntity();
        String responseContent = null;
        try {
            responseContent = EntityUtils.toString(entity, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            log.error("获取返回信息失败，请求地址：{}", url);
            log.error("获取返回信息失败，异常信息：{}", e);
        }
        try {
            response.close();
            httpClient.close();
        } catch (IOException e) {
            e.printStackTrace();
            log.error("资源关闭失败，异常信息：{}", e);
        }
        log.info("接收返回信息：{}", responseContent);
        return responseContent;
    }

    /**
     * @param url
     * @param params
     * @return 返回数据
     * @Title: sendJsonStr
     * @Description: post发送json字符串
     * @author Mundo
     */
    public static String sendJsonStr(String url, String params) {
        String result = "";

        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);
        try {
            httpPost.addHeader("Content-type", "application/json; charset=utf-8");
            httpPost.setHeader("Accept", "application/json");
            if (StringUtils.isNotBlank(params)) {
                httpPost.setEntity(new StringEntity(params, StandardCharsets.UTF_8));
            }
            HttpResponse response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                result = EntityUtils.toString(response.getEntity());
                log.info("返回数据：" + result);
            } else {
                log.info("请求失败");
            }
        } catch (IOException e) {
            log.error("请求异常");
            log.error(ExceptionUtils.getStackTrace(e));
        }
        return result;
    }
}