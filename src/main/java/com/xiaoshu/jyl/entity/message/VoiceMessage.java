package com.xiaoshu.jyl.entity.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.xiaoshu.jyl.constant.MessageTypeConstant;
import lombok.Data;

import java.util.Map;

/**
 * 回复语音消息
 *
 * @author zhaow.zhu
 * @date 2020/3/2 9:07
 */
@Data
@XStreamAlias("xml")
public class VoiceMessage extends BaseMessage {

    /**
     * 语音消息文件
     */
    @XStreamAlias("Voice")
    private Voice voice;

    public VoiceMessage() {
    }

    /**
     * 设置消息类型是 语音消息
     * 设置创建时间是当前时间
     */
    public VoiceMessage(Map<String, String> map) {
        this.setToUserName(map.get("FromUserName"));
        this.setFromUserName(map.get("ToUserName"));
        this.setMsgType(MessageTypeConstant.VOICE);
        this.setCreateTime(System.currentTimeMillis());
    }
}
