package com.xiaoshu.jyl.service.message;

import java.util.Map;

/**
 * 图片消息处理
 *
 * @author xxddds
 * @date 2020/3/7 18:30
 */
public interface ImageService {


    /**
     * 图片消息处理回复
     * @param map 接受消息
     * @return
     */
    String dealImage(Map<String, String> map);
}