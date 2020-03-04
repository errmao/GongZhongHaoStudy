package com.xiaoshu.jyl.entity.menu;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 子按钮
 *
 * @author zhaow.zhu
 * @date 2020/3/4 15:46
 */
@Data
public class SubButton extends AbstractButton {

    private List<AbstractButton> sub_button = new ArrayList<>();

    public SubButton() {
    }

    public SubButton(String name) {
        super(name);
    }
}
