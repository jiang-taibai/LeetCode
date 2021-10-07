package com.coderjiang.DailyPractice.Monthly_2021_10;

/**
 * <p>Creation Time: 2021-10-09 09:11:07</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_10_07 {

    class Solution {
        public int countSegments(String s) {
            s = s.trim();
            if (s.equals("")) return 0;
            return s.split("\\s+").length;
        }
    }

}
