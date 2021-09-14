package com.coderjiang.DailyPractice.Monthly_2021_09;

import java.util.List;

/**
 * <p>Creation Time: 2021-09-14 09:06:01</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_09_14 {

    class Solution {
        public String findLongestWord(String s, List<String> dictionary) {
            String ans = "";
            for (String word : dictionary) {
                if (isSequence(s, word)) {
                    if (word.length() > ans.length() || (word.length() == ans.length() && word.compareTo(ans) < 0)) {
                        ans = word;
                    }
                }
            }
            return ans;
        }

        private boolean isSequence(String s, String sequence) {
            int i = 0, j = 0;
            while (i < s.length() && j < sequence.length()) {
                if (s.charAt(i) == sequence.charAt(j)) j++;
                i++;
            }
            return j == sequence.length();
        }
    }

}
