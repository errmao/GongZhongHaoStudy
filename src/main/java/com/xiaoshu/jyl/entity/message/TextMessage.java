package com.xiaoshu.jyl.entity.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.xiaoshu.jyl.constant.MessageTypeConstant;
import lombok.Data;

import java.util.Map;

/**
 * 文本消息对象
 *
 * @author xxddds
 * @date 2020/2/15 16:15
 */
@Data
@XStreamAlias("xml")
public class TextMessage extends BaseMessage {

    /**
     * 文本消息内容
     */
    @XStreamAlias("Content")
    private String content;

    public TextMessage() {
    }

    /**
     * 设置消息类型是文本消息
     * 设置创建时间是系统时间
     */
    public TextMessage(Map<String, String> map) {
        this.setToUserName(map.get("FromUserName"));
        this.setFromUserName(map.get("ToUserName"));
        this.setMsgType(MessageTypeConstant.TEXT);
        this.setCreateTime(System.currentTimeMillis());
    }
}
