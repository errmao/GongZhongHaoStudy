package com.xiaoshu.jyl.service.material.impl;

import com.xiaoshu.jyl.service.material.MaterialService;
import com.xiaoshu.jyl.utils.AccessTokenUtil;
import com.xiaoshu.jyl.utils.HttpsUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.jsoup.Connection.Response;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * 素材管理实现
 *
 * @author zhaow.zhu
 * @date 2020/3/9 13:37
 */
@Service("materialService")
@Slf4j
public class MaterialServiceImpl implements MaterialService {

    /**
     * 上传临时素材
     *
     * @param type    上传文件类型
     * @param fileUrl 上传文件路径
     * @return
     */
    @Override
    public void uploadTemplateMaterial(String fileUrl, String type) {
        String url = "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE";
        url = url.replace("ACCESS_TOKEN", AccessTokenUtil.getAccessToken()).replace("TYPE", type);
        String flieUrl1 = "C:\\Users\\Administrator.DESKTOP-1MMLQ5P\\Desktop\\wdyz\\1.jpg";

        File file = new File(flieUrl1);
        HashMap<String, File> map = new HashMap<>();
        map.put("1", file);
        try {
            Response response = HttpsUtil.post(url, null, map);
            if (response.statusCode() == HttpStatus.SC_OK) {
                String result = response.body();
                log.info("返回数据：" + result);
            } else {
                log.info("请求失败");
            }
        } catch (IOException e) {
            log.error("上传临时附件失败，错误信息：{}", e);
        }
    }

    /**
     * 获取临时素材
     *
     * @param mediaId 上传时返回的编号
     */
    @Override
    public void getTempMaterialFile(String mediaId) {
        String url = "https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";
        url = url.replace("ACCESS_TOKEN", AccessTokenUtil.getAccessToken()).replace("MEDIA_ID", mediaId);
        log.info("发送请求地址：{}", url);
        try {
            Response response = HttpsUtil.get(url);
            if (response.statusCode() == HttpStatus.SC_OK) {
                String result = response.body();
                // log.info("返回数据：" + result);
            } else {
                log.info("请求失败");
            }
        } catch (IOException e) {
            log.error("获取临时附件失败，错误信息：{}", e);
        }

    }

    public static void main(String[] args) {
        MaterialServiceImpl t1 = new MaterialServiceImpl();
        // t1.uploadTemplateMaterial("", MaterialTypeConstant.MATERIAL_IMAGE);
        t1.getTempMaterialFile("1g4ycGFOFtlpxFJN6CVesQmFp9kxdQtWC4EL82T4B8W-MUC-8JBrmJqxglD-F8EP");
    }
}