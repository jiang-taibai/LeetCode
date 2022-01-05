package com.coderjiang.DailyPractice.Monthly_2022_01;

/**
 * <p>Creation Time: 2022-01-17 15:35:51</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_01_05 {

    class Solution {
        public String modifyString(String s) {
            char[] chars = s.toCharArray();
            int length = chars.length;
            for (int i = 0; i < length; ++i) {
                if (chars[i] == '?') {
                    boolean[] mark = new boolean[26];
                    if (i - 1 >= 0) mark[chars[i - 1] - 'a'] = true;
                    if (i + 1 < length && chars[i + 1] != '?') mark[chars[i + 1] - 'a'] = true;
                    for (int j = 0; j < 26; ++j) {
                        if (!mark[j]) {
                            chars[i] = (char) ('a' + j);
                            break;
                        }
                    }
                }
            }
            return String.valueOf(chars);
        }
    }

}
