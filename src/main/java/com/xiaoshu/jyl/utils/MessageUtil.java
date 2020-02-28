package com.xiaoshu.jyl.utils;

import com.thoughtworks.xstream.XStream;
import com.xiaoshu.jyl.constant.MessageTypeConstant;
import com.xiaoshu.jyl.entity.NewsItem;
import com.xiaoshu.jyl.entity.NewsMessage;
import com.xiaoshu.jyl.entity.TextMessage;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 微信消息转换工具类
 *
 * @author xxddds
 * @date 2020/2/15 16:05
 */
public class MessageUtil {

    /**
     * xml转Map集合
     *
     * @param request
     * @return
     * @throws IOException
     * @throws DocumentException
     */
    public static Map<String, String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException {
        Map<String, String> map = new HashMap<>();
        SAXReader reader = new SAXReader();

        InputStream inputStream = request.getInputStream();
        Document doc = reader.read(inputStream);

        Element root = doc.getRootElement();

        List<Element> list = root.elements();
        for (Element element : list) {
            map.put(element.getName(), element.getText());
        }
        inputStream.close();
        return map;
    }

    /**
     * 文本消息对象转xml
     *
     * @param textMessage
     * @return
     */
    public static String textMessageToXml(TextMessage textMessage) {
        XStream xStream = new XStream();
        xStream.alias("xml", textMessage.getClass());
        return xStream.toXML(textMessage);
    }

    /**
     * 图文消息对象转xml
     *
     * @param newsMessage
     * @return
     */
    public static String newsMessageToXml(NewsMessage newsMessage) {
        XStream xStream = new XStream();
        xStream.alias("xml", NewsMessage.class);
        xStream.alias("item", NewsItem.class);
        return xStream.toXML(newsMessage);
    }

    /**
     * 回复文本消息
     *
     * @param map     接收消息
     * @param content 返回的文本内容
     * @return
     */
    public static String returnTextMessage(Map<String, String> map, String content) {
        String fromUserName = map.get("FromUserName");
        String toUserName = map.get("ToUserName");
        TextMessage textMessage = new TextMessage();
        textMessage.setFromUserName(toUserName);
        textMessage.setToUserName(fromUserName);
        textMessage.setMsgType(MessageTypeConstant.TEXT);
        textMessage.setCreateTime(System.currentTimeMillis());
        textMessage.setContent(content);
        return MessageUtil.textMessageToXml(textMessage);
    }

    /**
     * 回复图文消息
     *
     * @param map
     * @param list 图文集合
     * @return
     */
    public static String returnNewsMessage(Map<String, String> map, List<NewsItem> list) {
        String fromUserName = map.get("FromUserName");
        String toUserName = map.get("ToUserName");
        NewsMessage newsMessage = new NewsMessage();
        newsMessage.setFromUserName(toUserName);
        newsMessage.setToUserName(fromUserName);
        newsMessage.setMsgType(MessageTypeConstant.NEWS);
        newsMessage.setCreateTime(System.currentTimeMillis());
        NewsItem item = new NewsItem();
        item.setTitle("国家破产之日影评");
        item.setDescription("《国家破产之日》将镜头对准了1997年的亚洲金融风暴。讲述国家破产前的一周时间内，想要阻止危机的人和追逐利益的人身上发生的故事。金慧秀在片中饰演最早预见破产并开始寻找对策的韩国银行通货政策小组组长韩诗贤，面对复杂的体系和权利关系，她面前的道路可谓困难重重.");
        item.setPicUrl("http://9b84382e.ngrok.io/images/11.jpg");
        item.setUrl("http://www.baidu.com");
        list = new ArrayList<>();
        list.add(item);
        newsMessage.setArticles(list);
        newsMessage.setArticleCount(list.size());
        return MessageUtil.newsMessageToXml(newsMessage);

    }


}
