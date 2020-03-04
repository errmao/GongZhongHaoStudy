package com.xiaoshu.jyl.entity.menu;

import lombok.Data;

/**
 * 发送位置按钮
 *
 * @author zhaow.zhu
 * @date 2020/3/4 16:48
 */
@Data
public class LocationSelectButton extends AbstractButton {

    private String type = "location_select";
    private String key;

    public LocationSelectButton() {
    }

    public LocationSelectButton(String name, String key) {
        super(name);
        this.key = key;
    }
}
