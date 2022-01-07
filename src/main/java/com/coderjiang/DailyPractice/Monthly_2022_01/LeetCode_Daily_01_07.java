package com.coderjiang.DailyPractice.Monthly_2022_01;

/**
 * <p>Creation Time: 2022-02-02 16:43:23</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_01_07 {

    class Solution {
        public int maxDepth(String s) {
            int cnt = 0;
            int maxCnt = 0;
            for (char c : s.toCharArray()) {
                switch (c) {
                    case '(':
                        maxCnt = Math.max(maxCnt, ++cnt);
                        break;
                    case ')':
                        cnt--;
                        break;
                }
            }
            return maxCnt;
        }
    }

}
