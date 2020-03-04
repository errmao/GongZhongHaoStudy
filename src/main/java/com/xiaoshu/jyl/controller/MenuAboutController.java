package com.xiaoshu.jyl.controller;

import com.xiaoshu.jyl.service.menu.MenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 菜单相关
 *
 * @author zhaow.zhu
 * @date 2020/3/4 15:55
 */
@RestController
public class MenuAboutController {

    @Resource
    private MenuService menuService;

    /**
     * 创建微信公众号菜单
     */
    @GetMapping("createMenu")
    private String createMenu() {
        menuService.createMenu();
        return "公众号菜单创建成功";
    }

}