package com.xiaoshu.jyl.service.message.impl;

import com.xiaoshu.jyl.constant.MessageTypeConstant;
import com.xiaoshu.jyl.entity.TextMessage;
import com.xiaoshu.jyl.service.message.GeneralNewsService;
import com.xiaoshu.jyl.utils.MessageTemplateUtils;
import com.xiaoshu.jyl.utils.MessageUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 接收普通消息处理服务
 *
 * @author zhaow.zhu
 * @date 2020/2/27 15:08
 */
@Service("generalNewsService")
public class GeneralNewsServiceImpl implements GeneralNewsService {

    /**
     * 接收文本消息，并设置返回的消息内容
     *
     * @param map 接收消息
     * @return
     */
    @Override
    public String doTextMsg(Map<String, String> map) {
        String receiverContent = map.get("Content");
        String returnContent = "";
        if ("1".equals(receiverContent)) {
            // 本公众号的介绍
            returnContent = MessageTemplateUtils.getGzhIntroduction();
        } else if ("2".equals(receiverContent)) {
            // 作者介绍
            returnContent = MessageTemplateUtils.getGzhAuthorIntroduction();
        } else if ("?".equals(receiverContent) || "？".equals(receiverContent)) {
            // 调出菜单导航
            returnContent = MessageTemplateUtils.getGzhNavigationMenu();
        } else if ("3".equals(receiverContent)) {
            return MessageUtil.returnNewsMessage(map, null);
        } else {
            // 其他内容
            returnContent = "您发送的内容是：" + receiverContent;
        }
        return MessageUtil.returnTextMessage(map, returnContent);
    }

    /**
     * 图片消息处理并回复
     *
     * @param map 接收消息
     * @return
     */
    @Override
    public String doImageService(Map<String, String> map) {
        return "";
    }
}