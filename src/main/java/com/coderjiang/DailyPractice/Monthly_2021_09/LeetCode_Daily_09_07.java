package com.coderjiang.DailyPractice.Monthly_2021_09;

/**
 * <p>Creation Time: 2021-09-07 16:26:38</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_09_07 {

    class Solution {
        public int balancedStringSplit(String s) {
            int cnt = 0;
            int res = 0;
            for (char ch : s.toCharArray()) {
                if (cnt == 0) res++;
                if (ch == 'L') cnt--;
                else cnt++;
            }
            return res;
        }
    }

}
