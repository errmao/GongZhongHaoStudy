package com.xiaoshu.jyl.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @author xxddds
 * @date 2020/2/15 15:40
 */
@Slf4j
public class CommonUtils {

    /**
     * @Comment SHA1实现
     * @Author Ron
     * @Date 2017年9月13日 下午3:30:36
     */
    public static String shaEncode(String inStr) {
        if (StringUtils.isEmpty(inStr)) {
            return null;
        } else {
            return DigestUtils.sha1Hex(inStr);
        }

    }
}
