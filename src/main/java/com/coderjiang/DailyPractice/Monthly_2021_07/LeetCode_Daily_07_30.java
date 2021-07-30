package com.coderjiang.DailyPractice.Monthly_2021_07;

/**
 * <p>Creation Time: 2021-07-30 16:51:38</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_07_30 {

    class Solution {
        public int titleToNumber(String columnTitle) {
            long pow = 1;
            long res = 0;
            int n = columnTitle.length();
            for (int i = n - 1; i >= 0; --i) {
                res += pow * (int) (columnTitle.charAt(i) - 'A' + 1);
                pow *= 26;
            }
            return (int) res;
        }
    }

}
