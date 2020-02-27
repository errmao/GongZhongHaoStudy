package com.xiaoshu.jyl.service.message;

import java.util.Map;

/**
 * 接收普通消息
 *
 * @author zhaow.zhu
 * @date 2020/2/27 15:07
 */
public interface GeneralNewsService {

    /**
     * 接收文本消息，并设置返回的消息内容
     *
     * @param map 接收消息
     * @return
     */
    String doTextMsg(Map<String, String> map);

    /**
     * 图片消息处理并回复
     *
     * @param map 接收消息
     * @return
     */
    String doImageService(Map<String, String> map);
}