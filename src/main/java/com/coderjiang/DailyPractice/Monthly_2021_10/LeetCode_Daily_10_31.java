package com.coderjiang.DailyPractice.Monthly_2021_10;

import java.util.ArrayList;

/**
 * <p>Creation Time: 2021-10-31 10:05:17</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_10_31 {

    class Solution {
        public String[] findWords(String[] words) {
            ArrayList<String> res = new ArrayList<>();
            for (String word : words) {
                if(isValid(word)) res.add(word);
            }
            return res.toArray(new String[0]);
        }

        private boolean isValid(String word) {
            word = word.toLowerCase();
            int preLine = line(word.charAt(0));
            for (char c : word.toCharArray()) {
                if(preLine != line(c)) return false;
            }
            return true;
        }

        private int line(Character ch) {
            if("qwertyuiop".indexOf(ch) != -1) {
                return 1;
            } else if("asdfghjkl".indexOf(ch) != -1) {
                return 2;
            } else {
                return 3;
            }
        }

    }

}
