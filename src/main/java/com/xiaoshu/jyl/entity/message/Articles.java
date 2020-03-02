package com.xiaoshu.jyl.entity.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * 图文内容
 *
 * @author zhaow.zhu
 * @date 2020/3/2 9:24
 */
@XStreamAlias("item")
@Data
public class Articles {

    /**
     * 图文消息标题
     */
    @XStreamAlias("Title")
    private String title;

    /**
     * 图文消息描述
     */
    @XStreamAlias("Description")
    private String description;

    /**
     * 图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
     */
    @XStreamAlias("PicUrl")
    private String picUrl;

    /**
     * 点击图文消息跳转链接
     */
    @XStreamAlias("Url")
    private String url;
}
