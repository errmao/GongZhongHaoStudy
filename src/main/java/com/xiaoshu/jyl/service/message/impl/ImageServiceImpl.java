package com.xiaoshu.jyl.service.message.impl;

import com.xiaoshu.jyl.service.message.ImageService;
import com.xiaoshu.jyl.utils.BaiduApiUtil;
import com.xiaoshu.jyl.utils.MessageUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 图片消息处理实现
 *
 * @author xxddds
 * @date 2020/3/7 18:31
 */
@Service("imageService")
public class ImageServiceImpl implements ImageService {

    /**
     * 识别图片中的文字并返回内容
     * @param map 接受消息
     * @return
     */
    @Override
    public String dealImage(Map<String, String> map) {
        String url = map.get("PicUrl");
        String words = BaiduApiUtil.recoginzedImage(url);
        return MessageUtil.replayTextMessage(map, "图片中的文字：" + words);
    }
}