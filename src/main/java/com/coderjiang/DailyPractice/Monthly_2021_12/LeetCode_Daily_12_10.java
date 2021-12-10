package com.coderjiang.DailyPractice.Monthly_2021_12;

/**
 * <p>Creation Time: 2021-12-10 01:36:43</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_12_10 {

    class Solution {
        public String shortestCompletingWord(String licensePlate, String[] words) {
            int[] origin = count(licensePlate);
            String ans = null;
            for (String word : words) {
                if (isValid(origin, word)) {
                    if (ans == null || word.length() < ans.length()) ans = word;
                }
            }
            return ans;
        }

        private int[] count(String s) {
            int[] res = new int[26];
            s = s.toLowerCase();
            for (char ch : s.toCharArray()) {
                if(ch >= 'a' && ch <= 'z')
                    res[ch - 'a']++;
            }
            return res;
        }

        private boolean isValid(int[] origin, String s) {
            int[] test = count(s);
            for (int i = 0; i < 26; ++i) {
                if (test[i] < origin[i]) return false;
            }
            return true;
        }
    }

}
