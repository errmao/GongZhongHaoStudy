package com.xiaoshu.jyl.service.message.impl;

import com.xiaoshu.jyl.service.message.EventPushService;
import com.xiaoshu.jyl.utils.MessageUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 接收事件推送处理服务
 *
 * @author zhaow.zhu
 * @date 2020/2/27 15:10
 */
@Service("eventPushService")
public class EventPushServiceImpl implements EventPushService {

    /**
     * 订阅（关注）事件推送
     *
     * @param map 接收消息
     * @return
     */
    @Override
    public String doSubscribeEvent(Map<String, String> map) {
        return MessageUtil.getGzhNavigationMenu(map);
    }

    /**
     * 取消订阅（取消关注）事件推送
     *
     * @param map 接收消息
     * @return
     */
    @Override
    public String doUnsubscribeEvent(Map<String, String> map) {
        return MessageUtil.replayTextMessage(map, "感谢您曾经的关注，期待下次相遇。");
    }
}