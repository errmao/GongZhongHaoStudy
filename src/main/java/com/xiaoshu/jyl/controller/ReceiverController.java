package com.xiaoshu.jyl.controller;

import com.xiaoshu.jyl.constant.MessageTypeConstant;
import com.xiaoshu.jyl.entity.TextMessage;
import com.xiaoshu.jyl.utils.MessageUtil;
import org.dom4j.DocumentException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * 微信普通消息接收回复
 *
 * @author xxddds
 * @date 2020/2/15 16:04
 */
@RestController
public class ReceiverController {

    @PostMapping("authFirst")
    public String reciverMessage(HttpServletRequest request) throws IOException, DocumentException {

        Map<String, String> map = MessageUtil.xmlToMap(request);
        String fromUserName = map.get("FromUserName");
        String toUserName = map.get("ToUserName");
        String messageType = map.get("MsgType");
        String content = map.get("Content");

        System.err.println("fromUserName:" + fromUserName);

        String message = null;
        // 文本消息
        if (MessageTypeConstant.TEXT.equals(messageType)) {
            TextMessage textMessage = new TextMessage();
            textMessage.setFromUserName(toUserName);
            textMessage.setToUserName(fromUserName);
            textMessage.setMsgType(MessageTypeConstant.TEXT);
            textMessage.setCreateTime(System.currentTimeMillis());
            textMessage.setContent("您发送的消息是：" + content);
            message = MessageUtil.textMessageToXml(textMessage);
        }
        return message;
    }
}