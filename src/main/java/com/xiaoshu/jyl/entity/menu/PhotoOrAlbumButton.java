package com.xiaoshu.jyl.entity.menu;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 拍照或者相册发图按钮
 *
 * @author zhaow.zhu
 * @date 2020/3/4 15:49
 */
@Data
public class PhotoOrAlbumButton extends AbstractButton {

    private String type = "pic_photo_or_album";
    private String key;
    private List<AbstractButton> sub_button = new ArrayList<>();

    public PhotoOrAlbumButton() {
    }

    public PhotoOrAlbumButton(String name, String key) {
        super(name);
        this.key = key;
    }
}
