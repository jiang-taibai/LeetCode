package com.coderjiang.DailyPractice.Monthly_2022_02;

/**
 * <p>Creation Time: 2022-02-02 16:38:32</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_02_02 {

    class Solution {
        public String reversePrefix(String word, char ch) {
            int index = word.indexOf(ch);
            if (index != -1) {
                word = new StringBuilder(word.substring(0, index + 1)).reverse().toString() + word.substring(index + 1);
            }
            return word;
        }
    }

}
