package com.xiaoshu.jyl.service.templatemessage;

/**
 * 模板消息接口
 *
 * @author xxddds
 * @date 2020/3/8 13:14
 */
public interface TemplateMessageService {

    /**
     * 设置行业信息
     */
    String setIndustry();

    /**
     * 获取设置的行业信息
     *
     * @return
     */
    String getIndustry();

    /**
     * 获得模板ID
     *
     * @return
     */
    String getTemplateId();

    /**
     * 获取模板列表
     *
     * @return
     */
    String getTemplateList();

    /**
     * 发送模板消息
     *
     * @return
     */
    String sendTemplateMessage();
}
