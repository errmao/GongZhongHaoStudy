package com.xiaoshu.jyl.utils;

import com.thoughtworks.xstream.XStream;
import com.xiaoshu.jyl.entity.message.*;
import jdk.internal.jline.internal.Log;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 微信消息转换工具类
 *
 * @author xxddds
 * @date 2020/2/15 16:05
 */
@Slf4j
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
        log.info("========  接收信息 开始 ========");
        log.info(map.toString());
        log.info("========  接收信息 结束 ========");
        return map;
    }

    /**
     * 消息对象转xml
     *
     * @param msg
     * @return
     */
    public static String messageBeanToXml(BaseMessage msg) {
        XStream xStream = new XStream();
        xStream.processAnnotations(new Class[]{
                BaseMessage.class, TextMessage.class,
                VoiceMessage.class, VideoMessage.class, MusicMessage.class,
                ImageMessage.class, ArticlesMessge.class});
        log.info("========== 返回信息开始 =================");
        log.info(xStream.toXML(msg));
        log.info("========== 返回信息结束 =================");
        return xStream.toXML(msg);
    }

    /**
     * 获取公众号导航菜单信息
     *
     * @return 导航信息
     */
    public static String getGzhNavigationMenu(Map<String, String> map) {
        StringBuffer sb = new StringBuffer();
        sb.append("欢迎您的关注，请按照提示操作：\n");
        sb.append("1. 本期作家推荐\n");
        sb.append("2. 本期图片推荐\n");
        sb.append("3. 获取最新推荐的语音\n");
        sb.append("4. 获取最新推荐的视频\n");
        sb.append("5. 获取最新推荐的音乐\n");
        sb.append("6. 获取最新推荐的电影推荐\n");
        sb.append("回复\"0\"获取导航菜单");
        String msg = sb.toString();
        TextMessage textMessage = new TextMessage(map);
        textMessage.setContent(msg);
        return MessageUtil.messageBeanToXml(textMessage);
    }

    /**
     * 回复文本消息
     *
     * @param map     接收消息
     * @param content 回复的文本内容
     * @return
     */
    public static String replayTextMessage(Map<String, String> map, String content) {
        TextMessage textMessage = new TextMessage(map);
        textMessage.setContent(content);
        return MessageUtil.messageBeanToXml(textMessage);
    }

}