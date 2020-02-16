package com.xiaoshu.jyl.entity;

import lombok.Data;

/**
 * 微信文本消息对象
 *
 * @author xxddds
 * @date 2020/2/15 16:15
 */
@Data
public class TextMessage {

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
    /**
     * 文本消息内容
     */
    private String Content;
    /**
     * 消息id，64位整型
     */
    private String MsgId;
}
