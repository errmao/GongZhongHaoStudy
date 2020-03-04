package com.xiaoshu.jyl.entity.menu;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 微信菜单按钮
 *
 * @author zhaow.zhu
 * @date 2020/3/4 15:37
 */
@Data
public class Button {

    private List<AbstractButton> button = new ArrayList<>();
}
