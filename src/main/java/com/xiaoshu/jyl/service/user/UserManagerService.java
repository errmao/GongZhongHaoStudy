package com.xiaoshu.jyl.service.user;

import com.xiaoshu.jyl.entity.user.UserInfo;

/**
 * 用户管理
 *
 * @author zhaow.zhu
 * @date 2020/3/10 11:00
 */
public interface UserManagerService {

    /**
     * 获取用户基本信息(UnionID机制)
     *
     * @param openId 普通用户的标识，对当前公众号唯一
     * @return
     */
    UserInfo getUserInfo(String openId);

    /**
     * 批量获取用户基本信息
     *
     * @return
     */
    String getUserInfoBatch();

    /**
     * 获取用户列表
     *
     * @return
     */
    String getUserList();
}