package com.xiaoshu.jyl.entity.menu;

import lombok.Data;

/**
 * 具体菜单
 *
 * @author zhaow.zhu
 * @date 2020/3/4 15:38
 */
@Data
public abstract class AbstractButton {

    private String name;

    public AbstractButton() {
    }

    public AbstractButton(String name) {
        this.name = name;
    }

}