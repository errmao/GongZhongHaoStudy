package com.xiaoshu.jyl.service.qrcode;

import com.alibaba.fastjson.JSONObject;
import com.xiaoshu.jyl.utils.AccessTokenUtil;
import com.xiaoshu.jyl.utils.HttpUtils;
import com.xiaoshu.jyl.utils.HttpsUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 二维码相关
 *
 * @author zhaow.zhu
 * @date 2020/3/9 15:22
 */
@Service("qRCodeService")
@Slf4j
public class QRCodeServiceImpl implements QRCodeService {

    /**
     * 创建临时二维码的ticket
     *
     * @return
     */
    @Override
    public String getTempTicket() {
        String url = "https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN";
        url = url.replace("TOKEN", AccessTokenUtil.getAccessToken());
        String data = "{\n" +
                      "  \"expire_seconds\": 604800,\n" +
                      "  \"action_name\": \"QR_STR_SCENE\",\n" +
                      "  \"action_info\": {\n" +
                      "    \"scene\": {\n" +
                      "      \"scene_str\": \"zzw\"\n" +
                      "    }\n" +
                      "  }\n" +
                      "}";

        String result = HttpUtils.doPost(url, data);
        JSONObject object = JSONObject.parseObject(result);
        String ticket = object.getString("ticket");
        log.info("ticket:{}", ticket);
        return ticket;
    }

    /**
     * 根据ticket获取二维码图片
     *
     * @param ticket
     * @return
     */
    @Override
    public String getQRCodeImage(String ticket) {
        String url = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";
        url = url.replace("TICKET", ticket);
        String result = HttpUtils.doGet(url, null);
        log.info("二维码数据：{}", result);
        return result;
    }

    public static void main(String[] args) {
        QRCodeServiceImpl t = new QRCodeServiceImpl();
        t.getQRCodeImage(t.getTempTicket());
    }
}
