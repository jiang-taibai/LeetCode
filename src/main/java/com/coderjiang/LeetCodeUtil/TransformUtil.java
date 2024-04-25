package com.coderjiang.LeetCodeUtil;

/**
 * @author 0194161刘江
 * @modifyTime 2020/12/17 8:09
 * @description: 针对字符串转数组的
 * @rule:
 *  1. 字符串应当以[开始，以]结束，例如 [1, 2, 3] 就是一个数组
 */
public class TransformUtil {


    public static int[] toNumberArray(String str) {
        if(str.startsWith("[")) {
            str = str.substring(1);
        }
        if(str.endsWith("]")) {
            str = str.substring(0, str.length() - 1);
        }
        String[] strs = str.split(",");
        int[] result = new int[strs.length];
        int i = 0;
        for(String s : strs) {
            result[i++] = Integer.parseInt(s);
        }
        return result;
    }
}
