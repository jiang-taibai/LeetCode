package com.coderjiang.DailyPractice.Monthly_2021_04;

/**
 * <p>创建时间：2021/4/28 16:03</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_04_28 {

    class Solution {
        public boolean judgeSquareSum(int c) {
            for (int a = 0; a * a <= c; ++a) {
                int sub = c - a * a;
                int b = (int) Math.sqrt(sub);
                if (sub == b * b) return true;
            }
            return false;
        }
    }

}
