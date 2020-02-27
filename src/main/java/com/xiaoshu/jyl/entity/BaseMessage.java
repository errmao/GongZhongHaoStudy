package com.xiaoshu.jyl.entity;

import lombok.Data;

/**
 * 基础消息字段
 *
 * @author zhaow.zhu
 * @date 2020/2/27 16:17
 */
@Data
public class BaseMessage {

    /**
     * 开发者微信号
     */
    private String ToUserName;
    /**
     * 发送方帐号（一个OpenID）
     */
    private String FromUserName;
    /**
     * 消息创建时间 （整型）
     */
    private Long CreateTime;
    /**
     * 消息类型，文本为text
     */
    private String MsgType;
}
