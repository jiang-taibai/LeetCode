package com.coderjiang.DailyPractice.Monthly_2022_01;

/**
 * <p>Creation Time: 2022-01-22 14:41:45</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_01_22 {

    class Solution {
        public int removePalindromeSub(String s) {
            return isPalindromeString(s) ? 1 : 2;
        }

        private boolean isPalindromeString(String s) {
            StringBuilder sb = new StringBuilder(s);
            return sb.reverse().toString().equals(s);
        }
    }

}
