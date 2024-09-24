package com.coderjiang.DailyPractice.Monthly_2024_09;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-09-24 10:40:16</p>
 */
public class DailyPractice_20240924 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public long maximumSubsequenceCount(String text, String pattern) {
            int n = text.length();
            int[] post = new int[n + 1];
            for (int i = n - 1; i >= 0; i--) {
                post[i] = post[i + 1];
                if (text.charAt(i) == pattern.charAt(1)) post[i]++;
            }
            long resOfInsert0 = post[0], resOfInsert1 = 0;
            for (int i = 0; i < n; i++) {
                if (text.charAt(i) == pattern.charAt(0)) {
                    resOfInsert0 += post[i + 1];
                    resOfInsert1 += post[i + 1] + 1;
                }
            }
            return Math.max(resOfInsert0, resOfInsert1);
        }
    }

}
