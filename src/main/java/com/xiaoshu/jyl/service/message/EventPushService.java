package com.xiaoshu.jyl.service.message;

import java.util.Map;

/**
 * 接收事件推送
 *
 * @author zhaow.zhu
 * @date 2020/2/27 15:03
 */
public interface EventPushService {

    /**
     * 订阅（关注）事件推送
     *
     * @param map 接收消息
     * @return
     */
    String doSubscribeEvent(Map<String, String> map);

    /**
     * 取消订阅（取消关注）事件推送
     *
     * @param map 接收消息
     * @return
     */
    String doUnsubscribeEvent(Map<String, String> map);

    /**
     * click事件处理
     *
     * @param map 接收消息
     * @return
     */
    String clickEvent(Map<String, String> map);

}
