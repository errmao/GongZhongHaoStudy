package com.xiaoshu.jyl.utils;

/**
 * 消息模块工具类
 *
 * @author zhaow.zhu
 * @date 2020/2/27 15:37
 */
public class MessageTemplateUtils {

    /**
     * 获取公众号导航菜单信息
     *
     * @return
     */
    public static String getGzhNavigationMenu() {
        StringBuffer sb = new StringBuffer();
        sb.append("欢迎您的关注，请按照提示操作：\n");
        sb.append("1. 公众号介绍\n");
        sb.append("2. 作者介绍\n");
        sb.append("3. 最新电影推荐\n");
        sb.append("回复\"?\"调出此菜单。");
        return sb.toString();
    }

    /**
     * 获取公众号介绍信息
     *
     * @return
     */
    public static String getGzhIntroduction() {
        String message = "公众号介绍：或许读书已经成为你的一种生活方式，在读书中也构建了一个属于自己的精神世界，但久而久之，陷入了自己的小世界不能自拔，看待问题、看待世界少了很多的「个人看法」，但是却多了很多自己以为的真相，世界在你个人的眼前呈现出来，但是却不再丰富。这种读书方法无关对错，你若喜欢，大可一直坚持，如若你想离开自己的世界，去碰触独立于你自身世界以外的世界，不妨一读下面的这篇文章，通过这种对读书方法的认知观来发现更丰富的世界。\n";
        return message;
    }

    /**
     * 获取公众号作者介绍信息
     *
     * @return
     */
    public static String getGzhAuthorIntroduction() {
        return "作者介绍：一个号称读了3000本书狂放不羁醉意江湖而穷困潦倒的李白先生。";
    }
}
