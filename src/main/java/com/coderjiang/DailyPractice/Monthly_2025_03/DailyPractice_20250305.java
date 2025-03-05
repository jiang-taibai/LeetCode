package com.coderjiang.DailyPractice.Monthly_2025_03;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-03-05 15:51:34</p>
 */
public class DailyPractice_20250305 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public String breakPalindrome(String palindrome) {
            int n = palindrome.length();
            for (int i = 0; i < n / 2; ++i) {
                if (palindrome.charAt(i) != 'a') {
                    return palindrome.substring(0, i) + "a" + palindrome.substring(i + 1);
                }
            }
            // 全为 a 的字符串，并且长度大于 1，就将最后一个字符设置为 'b'，
            if (n > 1) {
                return palindrome.substring(0, n - 1) + "b";
            }
            return "";
        }
    }

}
