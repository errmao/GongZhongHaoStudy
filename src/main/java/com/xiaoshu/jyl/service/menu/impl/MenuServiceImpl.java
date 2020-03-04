package com.xiaoshu.jyl.service.menu.impl;

import com.alibaba.fastjson.JSONObject;
import com.xiaoshu.jyl.entity.menu.*;
import com.xiaoshu.jyl.service.menu.MenuService;
import com.xiaoshu.jyl.utils.AccessTokenUtil;
import com.xiaoshu.jyl.utils.HttpUtils;
import org.springframework.stereotype.Service;

import javax.swing.text.View;

/**
 * 菜单相关事项
 *
 * @author zhaow.zhu
 * @date 2020/3/4 15:56
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {

    private static final String CREATE_MENU_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

    /**
     * 创建菜单
     */
    @Override
    public void createMenu() {
        // 菜单对象
        Button btn = new Button();
        // 第一个菜单
        btn.getButton().add(new ClickButton("1", "一级菜单"));
        // 第二个一级菜单
        btn.getButton().add(new ViewButton("一级菜单", "http://www.baidu.com"));
        // 第三个一级菜单
        SubButton subButton = new SubButton("有子菜单");
        // 为第三个一级菜单增加子菜单
        subButton.getSub_button().add(new PhotoOrAlbumButton("传图", "31"));
        subButton.getSub_button().add(new ClickButton("32", "点击"));
        subButton.getSub_button().add(new ViewButton("网易新闻", "http://news.163.com"));
        // 加入第三个一级菜单
        btn.getButton().add(subButton);
        // 转为json
        String jsonObject = JSONObject.toJSONString(btn);
        System.err.println(jsonObject);

        // 获取token
        String token = AccessTokenUtil.getAccessToken();
        // 发送post请求
        HttpUtils.doPost(CREATE_MENU_URL.replace("ACCESS_TOKEN", token), jsonObject);
    }
}