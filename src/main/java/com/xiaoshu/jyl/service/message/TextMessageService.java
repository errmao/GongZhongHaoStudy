package com.xiaoshu.jyl.service.message;

import java.util.Map;

/**
 * 文本消息回复接口
 *
 * @author zhaow.zhu
 * @date 2020/3/2 11:26
 */
public interface TextMessageService {

    /**
     * 接收文本消息并回复
     *
     * @param map 接收文本消息内容
     * @return 回复消息
     */
    String replyMessage(Map<String, String> map);
}