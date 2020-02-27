package com.xiaoshu.jyl.controller;

import com.xiaoshu.jyl.constant.MessageTypeConstant;
import com.xiaoshu.jyl.service.message.EventPushService;
import com.xiaoshu.jyl.service.message.GeneralNewsService;
import com.xiaoshu.jyl.utils.MessageUtil;
import org.dom4j.DocumentException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * 微信息接收回复接收分发控制器
 *
 * @author xxddds
 * @date 2020/2/15 16:04
 */
@RestController
public class ReceiverController {

    @Resource
    private GeneralNewsService generalNewsService;

    @Resource
    private EventPushService eventPushService;

    @PostMapping("authFirst")
    public String reciverMessage(HttpServletRequest request) throws IOException, DocumentException {

        Map<String, String> map = MessageUtil.xmlToMap(request);
        // 消息类型（参考常量MessageTypeConstant）
        String messageType = map.get("MsgType");

        // 返回值
        String message = null;
        // 根据消息类型做不同的分发
        if (MessageTypeConstant.TEXT.equals(messageType)) {
            // 文本消息
            message = generalNewsService.doTextMsg(map);
        } else if (MessageTypeConstant.IMAGE.equals(message)) {
            // 图片消息
            message = generalNewsService.doImageService(map);
        } else if (MessageTypeConstant.EVENT.equals(messageType)) {
            // 推送事件
            String eventType = map.get("Event");
            // 订阅
            if (MessageTypeConstant.SUBSCRIBE.equals(eventType)) {
                message = eventPushService.doSubscribeEvent(map);
            } else if (MessageTypeConstant.UNSUBSCRIBE.equals(eventType)) {
                // 取消订阅
                message = eventPushService.doUnsubscribeEvent(map);
            }
        }
        return message;
    }
}