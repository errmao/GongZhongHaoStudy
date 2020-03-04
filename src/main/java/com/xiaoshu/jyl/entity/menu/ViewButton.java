package com.xiaoshu.jyl.entity.menu;

import lombok.Data;

/**
 * view按钮
 *
 * @author zhaow.zhu
 * @date 2020/3/4 15:43
 */
@Data
public class ViewButton extends AbstractButton {

    private String type = "view";
    private String url;

    public ViewButton() {
    }

    public ViewButton(String name, String url) {
        super(name);
        this.url = url;
    }
}
