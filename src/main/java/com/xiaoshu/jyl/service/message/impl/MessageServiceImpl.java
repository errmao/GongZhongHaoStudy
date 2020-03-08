package com.xiaoshu.jyl.service.message.impl;

import com.xiaoshu.jyl.constant.MessageTypeConstant;
import com.xiaoshu.jyl.service.message.EventPushService;
import com.xiaoshu.jyl.service.message.ImageService;
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

    @Resource
    private EventPushService eventPushService;

    @Resource
    private ImageService imageService;

    /**
     * 微信消息分发路由
     *
     * @param map 输入参数map
     */
    @Override
    public String wxMessageRouter(Map<String, String> map) {

        // 消息类型（参考常量MessageTypeConstant）
        String messageType = map.get("MsgType");

        if (MessageTypeConstant.TEXT.equals(messageType)) {
            // 文本
            return textMessageService.replyMessage(map);

        } else if (MessageTypeConstant.EVENT.equals(messageType)) {
            // 事件
            return doEvent(map);

        } else if (MessageTypeConstant.IMAGE.equals(messageType)) {
            // 图片
            return imageService.dealImage(map);
        }
        return null;
    }

    /**
     * 接收事件推送处理总线
     *
     * @param map 接收消息
     * @return
     */
    @Override
    public String doEvent(Map<String, String> map) {
        // 推送事件, 获取子信息
        String eventType = map.get("Event");
        switch (eventType) {
            // 订阅
            case MessageTypeConstant.SUBSCRIBE:
                return eventPushService.doSubscribeEvent(map);
            // 取消订阅
            case MessageTypeConstant.UNSUBSCRIBE:
                return eventPushService.doUnsubscribeEvent(map);
            // click菜单
            case MessageTypeConstant.CLICK:
                return eventPushService.clickEvent(map);
            default:
        }
        return null;
    }
}