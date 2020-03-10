package com.xiaoshu.jyl.controller;

import com.xiaoshu.jyl.entity.user.UserInfo;
import com.xiaoshu.jyl.service.user.UserManagerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户管理控制器
 *
 * @author zhaow.zhu
 * @date 2020/3/10 11:30
 */
@RestController
public class UserManagerController {

    @Resource
    private UserManagerService userManagerService;

    /**
     * 获取用户信息
     *
     * @param opneId
     * @return
     */
    @GetMapping("getUserInfo")
    public UserInfo getUserInfo(String opneId) {
        opneId = "oIzSpw7VW9TJd1cuTR7LxrydDqZE";
        return userManagerService.getUserInfo(opneId);
    }

    /**
     * 批量获取用户信息
     *
     * @return
     */
    @GetMapping("getUserInfoBatch")
    public String getUserInfoBatch() {
        return userManagerService.getUserInfoBatch();
    }

    /**
     * 获取用户列表
     *
     * @return
     */
    @GetMapping("getUserList")
    public String getUserList() {
        return userManagerService.getUserList();
    }
}
