package com.xiaoshu.jyl.utils;

import com.thoughtworks.xstream.XStream;
import com.xiaoshu.jyl.entity.TextMessage;
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
     * @param textMessage
     * @return
     */
    public static String textMessageToXml(TextMessage textMessage) {
        XStream xStream = new XStream();
        xStream.alias("xml", textMessage.getClass());
        return xStream.toXML(textMessage);
    }
}
