package com.xiaoshu.jyl.service.qrcode;

/**
 * 二维码
 *
 * @author zhaow.zhu
 * @date 2020/3/9 15:22
 */
public interface QRCodeService {

    /**
     * 创建临时二维码的ticket
     *
     * @return
     */
    String getTempTicket();


    /**
     * 根据ticket获取二维码图片
     *
     * @param ticket
     * @return
     */
    String getQRCodeImage(String ticket);
}
