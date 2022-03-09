package com.sgxy.utils;

/**
 * @BelongsProject: workspace11
 * @Package com.sgxy.book.utils
 * @Author: 鱼头哥哥
 * @WeChat:15919651285
 * @CreateTime: 2022/3/3 15:43
 */
public class WebUtils {

    public static Integer judgeNum(Integer num, Integer defaultValue) {
        return num == null ? defaultValue : num;
    }
}
