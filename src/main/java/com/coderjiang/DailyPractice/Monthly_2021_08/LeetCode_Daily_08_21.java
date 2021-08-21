package com.coderjiang.DailyPractice.Monthly_2021_08;

/**
 * <p>Creation Time: 2021-08-21 11:45:03</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_08_21 {

    class Solution {
        public int compress(char[] s) {
            int l = 0, r = 0;
            int n = s.length;
            while (r < n) {
                int count = 1;
                while (r + 1 < n && s[r] == s[r + 1]) {
                    r++;
                    count++;
                }
                if (count >= 2) {
                    if (count / 1000 != 0) {
                        s[++l] = (char) ('0' + count / 1000);
                        count %= 1000;
                    }
                    if (count / 100 != 0) {
                        s[++l] = (char) ('0' + count / 100);
                        count %= 100;
                    }
                    if (count / 10 != 0) {
                        s[++l] = (char) ('0' + count / 10);
                        count %= 10;
                    }
                    s[++l] = (char) ('0' + count);
                }
                ++l;
                ++r;
            }
            return l - 1;
        }
    }

}
