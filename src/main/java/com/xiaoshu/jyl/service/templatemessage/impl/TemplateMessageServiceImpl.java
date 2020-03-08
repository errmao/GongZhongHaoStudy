package com.xiaoshu.jyl.service.templatemessage.impl;

import com.xiaoshu.jyl.service.templatemessage.TemplateMessageService;
import com.xiaoshu.jyl.utils.AccessTokenUtil;
import com.xiaoshu.jyl.utils.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 模板消息接口
 *
 * @author xxddds
 * @date 2020/3/8 13:15
 */
@Service("templateMessageService")
@Slf4j
public class TemplateMessageServiceImpl implements TemplateMessageService {

    /**
     * 设置行业信息（post）
     */
    private String setIndustryUrl = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=ACCESS_TOKEN";

    /**
     * 获取设置的所属行业（get）
     */
    private String getIndustryUrl = "https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=ACCESS_TOKEN";

    /**
     * 获取模板ID（post）
     */
    private String getTemplateIdUrl = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=ACCESS_TOKEN";

    /**
     * 获取模板列表
     */
    private String getTemplateList = "https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token=ACCESS_TOKEN";

    /**
     * 发送模板消息
     */
    private String sendTemplateMessageUrl = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";

    /**
     * 设置行业信息
     * 39 : 娱乐休闲
     * 37 : 传媒
     */
    @Override
    public String setIndustry() {

        String token = AccessTokenUtil.getAccessToken();
        String url = setIndustryUrl.replace("ACCESS_TOKEN", token);
        String data = "{\n" +
                " \"industry_id1\":\"39\", \n " +
                " \"industry_id2\":\"37\", \n " +
                "}";

        String result = HttpUtils.doPost(url, data);
        log.info("设置行业：{}", result);
        return result;
    }

    /**
     * 获取设置的行业信息
     *
     * @return
     */
    @Override
    public String getIndustry() {
        String token = AccessTokenUtil.getAccessToken();
        String url = getIndustryUrl.replace("ACCESS_TOKEN", token);
        String result = HttpUtils.doGet(url, null);
        log.info("获取设置行业：{}", result);
        return result;
    }

    /**
     * 获得模板ID
     *
     * @return
     */
    @Override
    public String getTemplateId() {

        String url = getTemplateIdUrl.replace("ACCESS_TOKEN", AccessTokenUtil.getAccessToken());
        // 模板库中模板的编号，有“TM**”和“OPENTMTM**”等形式
        String templateCode = "TM05454";
        String data = "{\n" +
                " \"template_id_short\":" + templateCode +
                "}";
        String result = HttpUtils.doPost(url, data);
        log.info("获取模板ID：{}", result);
        return result;
    }

    /**
     * 获取模板列表
     *
     * @return
     */
    @Override
    public String getTemplateList() {
        String token = AccessTokenUtil.getAccessToken();
        String url = getTemplateList.replace("ACCESS_TOKEN", token);
        String result = HttpUtils.doGet(url, null);
        log.info("获取模板列表：{}", result);
        return result;
    }

    /**
     * 发送模板消息
     *
     * @return
     */
    @Override
    public String sendTemplateMessage() {
        String at = AccessTokenUtil.getAccessToken();
        String url = sendTemplateMessageUrl.replace("ACCESS_TOKEN", at);
        String data = "{\n" +
                "           \"touser\":\"oIzSpw7VW9TJd1cuTR7LxrydDqZE\",\n" +
                "           \"template_id\":\"oZ5FwpvLVE_Ggb0igVLKBA_pbrzwWJA5Vs1RU59wU4o\",\n" +
                "           \"data\":{\n" +
                "                   \"first\": {\n" +
                "                       \"value\":\"您好，有待办事件需处理如下：\",\n" +
                "                       \"color\":\"#173172\"\n" +
                "                   },\n" +
                "                   \"keyword1\":{\n" +
                "                       \"value\":\"乘坐航班CA550去拉萨\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"keyword2\": {\n" +
                "                       \"value\":\"2022年2月2日 13：25：26\",\n" +
                "                       \"color\":\"#173277\"\n" +
                "                   },\n" +
                "                   \"keyword3\": {\n" +
                "                       \"value\":\"杭州萧山机场\",\n" +
                "                       \"color\":\"#123177\"\n" +
                "                   },\n" +
                "                   \"remark\":{\n" +
                "                       \"value\":\"希望您尽快处理！\",\n" +
                "                       \"color\":\"#373177\"\n" +
                "                   }\n" +
                "           }\n" +
                "       }";
        String result = HttpUtils.doPost(url, data);
        log.info("发送模板消息：{}", result);
        return result;
    }
}