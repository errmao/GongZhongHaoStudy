package com.xiaoshu.jyl.controller;

import com.xiaoshu.jyl.service.templatemessage.TemplateMessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 模板消息接口
 *
 * @author xxddds
 * @date 2020/3/8 13:12
 */
@RestController
public class TemplateMessageController {

    @Resource
    private TemplateMessageService templateMessageService;

    /**
     * 设置所属行业
     *
     * @return
     */
    @GetMapping("setIndustry")
    public String setIndustry() {
        return templateMessageService.setIndustry();
    }

    /**
     * 获取设置的行业信息
     *
     * @return
     */
    @GetMapping("getIndustry")
    public String getIndustry() {
        return templateMessageService.getIndustry();
    }

    /**
     * 获得模板ID
     *
     * @return
     */
    @GetMapping("getTemplateId")
    public String getTemplateId() {
        return templateMessageService.getTemplateId();
    }

    /**
     * 获得模板列表
     *
     * @return
     */
    @GetMapping("getTemplateList")
    public String getTemplateList() {
        return templateMessageService.getTemplateList();
    }

    /**
     * 发送模板消息
     *
     * @return
     */
    @GetMapping("sendTemplateMessage")
    public String sendTemplateMessage() {
        return templateMessageService.sendTemplateMessage();
    }
}
