package com.xiaoshu.jyl.controller;

import com.xiaoshu.jyl.utils.CheckUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author xxddds
 * @date 2020/2/15 15:12
 */
@RestController
public class AuthController {

    /**
     * 微信公众号接入校验
     *
     * @param request
     * @throws IOException
     */
    @GetMapping("authFirst")
    public void authFirst(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");

        PrintWriter pw = response.getWriter();
        // 校验成功就返回随机字符串
        if (CheckUtils.checkSignature(signature, timestamp, nonce)) {
            pw.print(echostr);
        }
        pw.close();
    }
}
