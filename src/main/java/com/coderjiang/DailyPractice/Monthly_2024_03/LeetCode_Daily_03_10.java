package com.coderjiang.DailyPractice.Monthly_2024_03;

/**
 * <p>Creation Time: 2024/3/10</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_03_10 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public String getHint(String secret, String guess) {
            int[] countSecret = new int[10];
            int[] countGuess = new int[10];
            char[] secretChars = secret.toCharArray();
            char[] guessChars = guess.toCharArray();
            int n = secretChars.length;
            int bulls = 0, cows = 0;
            for (int i = 0; i < n; i++) {
                char secretChar = secretChars[i];
                char guessChar = guessChars[i];
                if (secretChar == guessChar) {
                    bulls++;
                } else {
                    countSecret[secretChar - '0']++;
                    countGuess[guessChar - '0']++;
                }
            }
            for (int i = 0; i < 10; i++) {
                cows += Math.min(countSecret[i], countGuess[i]);
            }
            return String.format("%dA%dB", bulls, cows);
        }
    }

}
