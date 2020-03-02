package com.xiaoshu.jyl.service.message.impl;

import com.xiaoshu.jyl.constant.MessageTypeConstant;
import com.xiaoshu.jyl.service.message.MessageService;
import com.xiaoshu.jyl.service.message.TextMessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 消息分发总线
 *
 * @author zhaow.zhu
 * @date 2020/3/2 11:15
 */
@Service("messageService")
public class MessageServiceImpl implements MessageService {

    @Resource
    private TextMessageService textMessageService;

    /**
     * 微信消息分发路由
     *
     * @param map 输入参数map
     */
    @Override
    public String wxMessageRouter(Map<String, String> map) {

        // 消息类型（参考常量MessageTypeConstant）
        String messageType = map.get("MsgType");

        // 根据消息类型做不同的分发
        if (MessageTypeConstant.TEXT.equals(messageType)) {
            // 文本消息
            return textMessageService.replyMessage(map);
        } else if (MessageTypeConstant.EVENT.equals(messageType)) {
           /* // 推送事件
            String eventType = map.get("Event");
            // 订阅
            if (MessageTypeConstant.SUBSCRIBE.equals(eventType)) {
                message = eventPushService.doSubscribeEvent(map);
            } else if (MessageTypeConstant.UNSUBSCRIBE.equals(eventType)) {
                // 取消订阅
                message = eventPushService.doUnsubscribeEvent(map);
            }*/
        }

        return null;
    }
}