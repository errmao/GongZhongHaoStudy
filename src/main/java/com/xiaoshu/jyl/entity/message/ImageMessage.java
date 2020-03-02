package com.xiaoshu.jyl.entity.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.xiaoshu.jyl.constant.MessageTypeConstant;
import lombok.Data;

import java.util.Map;

/**
 * 图片消息
 *
 * @author zhaow.zhu
 * @date 2020/3/2 9:01
 */
@Data
@XStreamAlias("xml")
public class ImageMessage extends BaseMessage {

    /**
     * 通过素材管理中的接口上传多媒体文件，得到的id
     */
    @XStreamAlias("MediaId")
    private String mediaId;

    public ImageMessage() {
    }

    /**
     * 设置消息类型为图片
     * 设置创建时间为系统时间
     */
    public ImageMessage(Map<String, String> map) {
        this.setToUserName(map.get("FromUserName"));
        this.setFromUserName(map.get("ToUserName"));
        this.setMsgType(MessageTypeConstant.IMAGE);
        this.setCreateTime(System.currentTimeMillis());
    }
}
