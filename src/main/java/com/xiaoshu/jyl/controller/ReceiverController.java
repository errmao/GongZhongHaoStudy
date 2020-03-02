package com.xiaoshu.jyl.controller;

import com.xiaoshu.jyl.service.message.MessageService;
import com.xiaoshu.jyl.utils.MessageUtil;
import org.dom4j.DocumentException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * 微信息接收回复接收分发控制器
 *
 * @author xxddds
 * @date 2020/2/15 16:04
 */
@RestController
public class ReceiverController {

    @Resource
    private MessageService messageService;

    /**
     * 消息请求
     *
     * @param request
     * @return
     * @throws IOException
     * @throws DocumentException
     */
    @PostMapping("authFirst")
    public String receiveMessage(HttpServletRequest request) throws IOException, DocumentException {
        // 将xml的输入消息转化为map集合
        Map<String, String> map = MessageUtil.xmlToMap(request);
        return messageService.wxMessageRouter(map);
    }
}