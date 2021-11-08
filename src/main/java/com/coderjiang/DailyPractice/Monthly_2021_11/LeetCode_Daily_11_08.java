package com.coderjiang.DailyPractice.Monthly_2021_11;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Creation Time: 2021-12-03 13:22:17</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_11_08 {

    class Solution {
        public String getHint(String secret, String guess) {
            int bulls = 0;
            int cows = 0;
            char[] c_secret = secret.toCharArray();
            char[] c_guess = guess.toCharArray();
            int n = c_guess.length;
            for (int i = 0; i < n; ++i) {
                if (c_secret[i] == c_guess[i]) {
                    bulls++;
                    c_secret[i] = c_guess[i] = '#';
                }
            }
            Map<Character, Integer> map_secret = new HashMap<>();
            for (char ch : c_secret) {
                if (ch == '#') continue;
                map_secret.put(ch, map_secret.getOrDefault(ch, 0) + 1);
            }
            Map<Character, Integer> map_guess = new HashMap<>();
            for (char ch : c_guess) {
                if (ch == '#') continue;
                map_guess.put(ch, map_guess.getOrDefault(ch, 0) + 1);
            }
            for (char ch : c_guess) {
                if (ch == '#') continue;
                if (map_secret.containsKey(ch)) {
                    cows += Math.min(map_secret.get(ch), map_guess.get(ch));
                    map_secret.remove(ch);
                    map_guess.remove(ch);
                }
            }
            return bulls + "A" + cows + "B";
        }
    }

}
