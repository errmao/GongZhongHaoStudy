package com.xiaoshu.jyl.entity.menu;

import lombok.Data;

/**
 * click菜单
 *
 * @author zhaow.zhu
 * @date 2020/3/4 15:41
 */
@Data
public class ClickButton extends AbstractButton {

    private String type = "click";
    private String key;

    public ClickButton() {
    }

    public ClickButton(String key) {
        this.key = key;
    }

    public ClickButton(String key, String name) {
        super(name);
        this.key = key;
    }
}
