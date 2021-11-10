package com.coderjiang.DailyPractice.Monthly_2021_11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Creation Time: 2021-11-10 14:41:47</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_11_10 {

    class Solution {
        public String getHint(String secret, String guess) {
            int bulls = 0;
            int cows = 0;
            Map<Character, ArrayList<Integer>> map = new HashMap<>();
            char[] secretChars = secret.toCharArray();
            char[] guessChars = guess.toCharArray();
            for (int i = 0; i < guess.length(); ++i) {
                if (i < secret.length() && guessChars[i] == secretChars[i]) {
                    bulls++;
                    secretChars[i] = guessChars[i] = '*';
                }
            }
            return bulls + "A" + cows + "B";
        }
    }

}