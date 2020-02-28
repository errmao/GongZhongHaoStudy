package com.xiaoshu.jyl.service.message.impl;

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
            // 返回本公众号的介绍
            return MessageTemplateUtils.getGzhIntroduction();
        } else if ("2".equals(receiverContent)) {
            // 返回作者介绍
            returnContent = MessageTemplateUtils.getGzhAuthorIntroduction();
        } else if ("?".equals(receiverContent) || "？".equals(receiverContent)) {
            // 调出菜单导航
            return MessageTemplateUtils.getGzhNavigationMenu();
        } else if ("3".equals(receiverContent)) {
            // 返回图文消息
            return MessageUtil.returnNewsMessage(map, null);
        } else {
            // 其他内容
            return "您发送的内容是：" + receiverContent;
        }
        return null;
    }
}