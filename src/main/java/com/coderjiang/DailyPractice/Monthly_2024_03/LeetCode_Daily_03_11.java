package com.coderjiang.DailyPractice.Monthly_2024_03;

/**
 * <p>Creation Time: 2024/3/11</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_03_11 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public String capitalizeTitle(String title) {
            char[] chars = title.toCharArray();
            int n = chars.length;
            for (int i = 0; i < n; i++) {
                if (i == 0 || chars[i - 1] == ' ') {
                    if (i + 2 < n && chars[i + 1] != ' ' && chars[i + 2] != ' ') {
                        chars[i] = Character.toUpperCase(chars[i]);
                    } else {
                        chars[i] = Character.toLowerCase(chars[i]);
                    }

                } else {
                    chars[i] = Character.toLowerCase(chars[i]);
                }
            }
            return String.valueOf(chars);
        }
    }

}
