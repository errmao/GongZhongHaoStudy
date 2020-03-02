package com.xiaoshu.jyl.entity.token;

import lombok.Data;

/**
 * 公众号access token对象
 *
 * @author zhaow.zhu
 * @date 2020/3/2 15:26
 */
@Data
public class AccessToken {

    /**
     * access token
     */
    private String accessToken;

    /**
     * 过期时间
     */
    private Long expireTime;

    public AccessToken() {
    }

    /**
     * @param accessToken token
     * @param expireIn    过期时长
     */
    public AccessToken(String accessToken, String expireIn) {
        super();
        this.accessToken = accessToken;
        this.expireTime = System.currentTimeMillis() + Integer.parseInt(expireIn) * 1000;
    }

    /**
     * 判断token是否过期
     *
     * @return
     */
    public boolean isExpired() {
        return System.currentTimeMillis() > expireTime;
    }
}
