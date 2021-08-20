package com.coderjiang.DailyPractice.Monthly_2021_08;

/**
 * <p>Creation Time: 2021-08-20 22:54:36</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_08_20 {

    class Solution {
        public String reverseStr(String s, int k) {
            char[] str = s.toCharArray();
            for (int i = 0; i < str.length; i += k) {
                reverse(str, i, i + k);
            }
            return String.valueOf(str);
        }

        private void reverse(char[] str, int from, int to) {
            if (to >= str.length) {
                to = str.length - 1;
            }
            while (from < to) {
                char temp = str[from];
                str[from] = str[to];
                str[to] = temp;
                from++;
                to--;
            }
        }
    }

}
