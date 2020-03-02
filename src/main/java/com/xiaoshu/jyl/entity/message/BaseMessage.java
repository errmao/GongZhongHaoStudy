package com.xiaoshu.jyl.entity.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
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
    @XStreamAlias("ToUserName")
    private String toUserName;
    /**
     * 发送方帐号（一个OpenID）
     */
    @XStreamAlias("FromUserName")
    private String fromUserName;
    /**
     * 消息创建时间 （整型）
     */
    @XStreamAlias("CreateTime")
    private Long createTime;
    /**
     * 消息类型，文本为text
     */
    @XStreamAlias("MsgType")
    private String msgType;
}
