package com.xiaoshu.jyl.entity;

import lombok.Data;

/**
 * 图文消息项
 *
 * @author zhaow.zhu
 * @date 2020/2/27 16:19
 */
@Data
public class NewsItem {

    /**
     * 图文消息标题
     */
    private String Title;

    /**
     * 图文消息描述
     */
    private String Description;

    /**
     * 图片链接
     */
    private String PicUrl;

    /**
     * 点击图文消息跳转链接
     */
    private String Url;
}
