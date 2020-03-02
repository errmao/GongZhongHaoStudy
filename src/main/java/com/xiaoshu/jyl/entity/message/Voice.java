package com.xiaoshu.jyl.entity.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * 语音媒体文件编号
 *
 * @author zhaow.zhu
 * @date 2020/3/2 9:07
 */
@Data
public class Voice {

    /**
     * 通过素材管理中的接口上传多媒体文件，得到的id
     */
    @XStreamAlias("MediaId")
    private String mediaId;
}
