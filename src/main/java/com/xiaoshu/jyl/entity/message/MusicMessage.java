package com.xiaoshu.jyl.entity.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.xiaoshu.jyl.constant.MessageTypeConstant;
import lombok.Data;

import java.util.Map;

/**
 * 回复音乐消息
 *
 * @author zhaow.zhu
 * @date 2020/3/2 9:16
 */
@Data
@XStreamAlias("xml")
public class MusicMessage extends BaseMessage {

    /**
     * 音乐信息
     */
    @XStreamAlias("Music")
    private Music music;

    public MusicMessage() {
    }

    /**
     * 设置消息类型为音乐消息
     * 设置创建时间是系统时间
     */
    public MusicMessage(Map<String, String> map) {
        this.setToUserName(map.get("FromUserName"));
        this.setFromUserName(map.get("ToUserName"));
        this.setMsgType(MessageTypeConstant.MUSIC);
        this.setCreateTime(System.currentTimeMillis());
    }
}
