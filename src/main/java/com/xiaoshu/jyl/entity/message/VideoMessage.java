package com.xiaoshu.jyl.entity.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.xiaoshu.jyl.constant.MessageTypeConstant;
import lombok.Data;

import java.util.Map;

/**
 * 回复视频消息
 *
 * @author zhaow.zhu
 * @date 2020/3/2 9:11
 */
@Data
public class VideoMessage extends BaseMessage {

    /**
     * 视频资料信息
     */
    @XStreamAlias("Video")
    private Video video;

    public VideoMessage() {
    }

    /**
     * 设置消息类型是视频消息
     * 设置创建时间是当前时间
     */
    public VideoMessage(Map<String, String> map) {
        this.setToUserName(map.get("FromUserName"));
        this.setFromUserName(map.get("ToUserName"));
        this.setMsgType(MessageTypeConstant.VIDEO);
        this.setCreateTime(System.currentTimeMillis());
    }
}