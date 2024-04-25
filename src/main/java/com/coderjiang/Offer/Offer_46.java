package com.coderjiang.Offer;

/**
 * <p>Creation Time: 2021-12-12 12:48:26</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class Offer_46 {

    class Solution {
        public int translateNum(int num) {
            char[] s = String.valueOf(num).toCharArray();
            int[] dp = new int[s.length + 1];
            dp[1] = 1;
            dp[0] = 1;
            for (int i = 1; i < s.length; i++) {
                int num1 = (s[i] - '0');
                int num2 = (s[i - 1] - '0') * 10 + (s[i] - '0');
                if (num2 >= 10 && num2 <= 25) {
                    dp[i + 1] += dp[i - 1];
                }
                dp[i + 1] += dp[i];

            }
            return dp[s.length];
        }
    }

}
