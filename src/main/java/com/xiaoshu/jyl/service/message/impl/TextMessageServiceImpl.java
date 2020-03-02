package com.xiaoshu.jyl.service.message.impl;

import com.xiaoshu.jyl.entity.message.Articles;
import com.xiaoshu.jyl.entity.message.ArticlesMessge;
import com.xiaoshu.jyl.entity.message.TextMessage;
import com.xiaoshu.jyl.service.message.TextMessageService;
import com.xiaoshu.jyl.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

/**
 * 文本消息接口实现
 *
 * @author zhaow.zhu
 * @date 2020/3/2 11:27
 */
@Service("textMessageService")
public class TextMessageServiceImpl implements TextMessageService {

    @Value("ngrok.addr")
    private String ngrokIp;

    /**
     * 接收文本消息并回复
     *
     * @param map 接收文本消息内容
     * @return 回复消息
     */
    @Override
    public String replyMessage(Map<String, String> map) {
        String receiverContent = map.get("Content");
        switch (receiverContent) {
            case "1":
                // 本期作家推荐
                return getLatestAuthor(map);
            case "2":
                // 本期图片推荐
            case "3":
                break;
            case "6":
                // 本期电影推荐（图文）
                return getLatestNews(map);
            case "0":
                // 获取导航菜单
                return MessageUtil.getGzhNavigationMenu(map);
            default:
                return MessageUtil.replayTextMessage(map, "您发送的内容是：" + receiverContent);
        }
        return null;
    }


    /**
     * 本期作家推荐
     *
     * @return
     */
    private String getLatestAuthor(Map<String, String> map) {
        String msg = "金庸（1924年3月10日—2018年10月30日），本名查良镛，生于浙江省海宁市，1948年移居香港。" +
                     "当代武侠小说作家、新闻学家、企业家、政治评论家、社会活动家，被誉为“香港四大才子”之一，与古龙、梁羽生、温瑞安并称为中国武侠小说四大宗师。";
        TextMessage textMessage = new TextMessage(map);
        textMessage.setContent(msg);
        return MessageUtil.messageBeanToXml(textMessage);
    }

    /**
     * 本期电影推荐
     *
     * @param map
     * @return
     */
    private String getLatestNews(Map<String, String> map) {
        ArticlesMessge articlesMessge = new ArticlesMessge(map);
        Articles articles = new Articles();
        articles.setTitle("国家破产之日影评");
        articles.setDescription("《国家破产之日》将镜头对准了1997年的亚洲金融风暴。讲述国家破产前的一周时间内，想要阻止危机的人和追逐利益的人身上发生的故事。金慧秀在片中饰演最早预见破产并开始寻找对策的韩国银行通货政策小组组长韩诗贤，面对复杂的体系和权利关系，她面前的道路可谓困难重重.");
        articles.setPicUrl(ngrokIp + "/images/4.jpg");
        articles.setUrl("http://www.baidu.com");
        ArrayList<Articles> list = new ArrayList<>();
        list.add(articles);
        articlesMessge.setArticleCount(1);
        articlesMessge.setArticlesList(list);
        return MessageUtil.messageBeanToXml(articlesMessge);
    }
}