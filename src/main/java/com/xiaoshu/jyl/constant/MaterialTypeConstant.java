package com.xiaoshu.jyl.constant;

/**
 * 素材类型常量
 *
 * @author zhaow.zhu
 * @date 2020/3/9 15:02
 */
public class MaterialTypeConstant {

    /**
     * 图片（image）: 2M，支持PNG\JPEG\JPG\GIF格式
     */
    public static final String MATERIAL_IMAGE = "image";

    /**
     * 语音（voice）：2M，播放长度不超过60s，支持AMR\MP3格式
     */
    public static final String MATERIAL_VOICE = "voice";

    /**
     * 视频（video）：10MB，支持MP4格式
     */
    public static final String MATERIAL_VIDEO = "video";

    /**
     * 缩略图（thumb）：64KB，支持JPG格式
     */
    public static final String MATERIAL_THUMB = "thumb";
}
