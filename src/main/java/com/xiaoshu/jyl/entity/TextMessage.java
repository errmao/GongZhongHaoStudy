package com.xiaoshu.jyl.entity;

import lombok.Data;

/**
 * 微信文本消息对象
 *
 * @author xxddds
 * @date 2020/2/15 16:15
 */
@Data
public class TextMessage extends BaseMessage {

    /**
     * 文本消息内容
     */
    private String Content;

}
