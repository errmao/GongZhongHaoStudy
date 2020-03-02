package com.xiaoshu.jyl.service.message;

import java.util.Map;

/**
 * 消息服务路由
 *
 * @author zhaow.zhu
 * @date 2020/3/2 10:35
 */
public interface MessageService {

    /**
     * 微信消息分发路由
     *
     * @param map 输入参数map
     */
    String wxMessageRouter(Map<String, String> map);
}
