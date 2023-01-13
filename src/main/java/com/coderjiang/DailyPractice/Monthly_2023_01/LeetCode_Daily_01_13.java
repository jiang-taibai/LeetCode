package com.coderjiang.DailyPractice.Monthly_2023_01;

/**
 * <p>Creation Time: 2023-01-13 13:58:54</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_01_13 {

    class Solution {
        public int rearrangeCharacters(String s, String target) {
            int[] count1 = new int[26];
            int[] count2 = new int[26];
            for (char ch : s.toCharArray()) count1[ch - 'a']++;
            for (char ch : target.toCharArray()) count2[ch - 'a']++;
            int res = Integer.MAX_VALUE;
            for (int i = 0; i < 26; ++i) {
                if (count2[i] != 0) {
                    res = Math.min(res, count1[i] / count2[i]);
                }
            }
            return res;
        }
    }

}
