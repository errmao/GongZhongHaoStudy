package com.xiaoshu.jyl.entity.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.xiaoshu.jyl.constant.MessageTypeConstant;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 回复图文消息
 *
 * @author zhaow.zhu
 * @date 2020/3/2 9:21
 */
@Data
@XStreamAlias("xml")
public class ArticlesMessge extends BaseMessage {

    /**
     * 图文消息集合
     */
    @XStreamAlias("Articles")
    private List<Articles> articlesList;

    /**
     * 图文消息个数；当用户发送文本、图片、视频、图文、地理位置这五种消息时，开发者只能回复1条图文消息；其余场景最多可回复8条图文消息
     */
    @XStreamAlias("ArticleCount")
    private Integer articleCount;

    public ArticlesMessge() {
    }

    /**
     * 设置消息类型是图文消息
     * 设置创建时间是系统时间
     */
    public ArticlesMessge(Map<String, String> map) {
        this.setToUserName(map.get("FromUserName"));
        this.setFromUserName(map.get("ToUserName"));
        this.setMsgType(MessageTypeConstant.NEWS);
        this.setCreateTime(System.currentTimeMillis());
    }
}
