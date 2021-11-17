package com.coderjiang.DailyPractice.Monthly_2021_11;

/**
 * <p>Creation Time: 2021-11-17 12:54:08</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_11_17 {

    class Solution {
        public int maxProduct(String[] words) {
            int max = 0;
            int[] codes = new int[words.length];
            for (int i = 0; i < codes.length; i++) {
                codes[i] = getCode(words[i]);
            }
            for (int i = 0; i < words.length; i++) {
                for (int j = i + 1; j < words.length; j++) {
                    if ((codes[i] & codes[j]) == 0) {
                        max = Math.max(max, words[i].length() * words[j].length());
                    }
                }
            }
            return max;
        }

        private int getCode(String word) {
            int code = 0;
            for (char c : word.toCharArray()) {
                if (((code >> (c - 'a')) & 1) == 0) {
                    code += 1 << (c - 'a');
                }
            }
            return code;
        }

    }

}
