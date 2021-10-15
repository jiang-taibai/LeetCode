package com.coderjiang.DailyPractice.Monthly_2021_10;

/**
 * <p>Creation Time: 2021-10-15 12:23:38</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_10_15 {

    class Solution {
        public String countAndSay(int n) {
            String s = "1";
            for (int i = 1; i < n; ++i) {
                s = cal(s);
            }
            return s;
        }

        private String cal(String s) {
            StringBuilder sb = new StringBuilder();
            int cnt = 1;
            char[] chars = s.toCharArray();
            for (int i = 1; i < chars.length; ++i) {
                if (chars[i] != chars[i - 1]) {
                    sb.append(cnt);
                    sb.append(chars[i - 1]);
                    cnt = 1;
                } else {
                    cnt++;
                }
            }
            sb.append(cnt);
            sb.append(chars[chars.length - 1]);
            return sb.toString();
        }

    }

}
