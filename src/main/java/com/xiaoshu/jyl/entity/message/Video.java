package com.xiaoshu.jyl.entity.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * 视频信息
 *
 * @author zhaow.zhu
 * @date 2020/3/2 9:12
 */
@Data
public class Video {

    /**
     * 通过素材管理中的接口上传多媒体文件，得到的id
     */
    @XStreamAlias("MediaId")
    private String mediaId;

    /**
     * 视频消息的标题
     */
    @XStreamAlias("Title")
    private String title;

    /**
     * 视频消息的描述
     */
    @XStreamAlias("Description")
    private String description;

}