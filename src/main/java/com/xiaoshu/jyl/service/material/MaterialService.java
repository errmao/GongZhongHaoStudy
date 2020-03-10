package com.xiaoshu.jyl.service.material;

/**
 * 素材管理接口
 *
 * @author zhaow.zhu
 * @date 2020/3/9 13:36
 */
public interface MaterialService {

    /**
     * 上传临时素材
     *
     * @param type 上传文件类型
     * @param url  上传文件路径
     * @return
     */
    void uploadTemplateMaterial(String url, String type);

    /**
     * 获取临时素材
     *
     * @param mediaId 上传时返回的编号
     */
    void getTempMaterialFile(String mediaId);
}