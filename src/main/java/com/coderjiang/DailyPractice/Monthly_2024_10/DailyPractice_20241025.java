package com.coderjiang.DailyPractice.Monthly_2024_10;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-10-25 19:15:44</p>
 */
public class DailyPractice_20241025 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        public int maxTotalReward(int[] rewardValues) {
            int n = rewardValues.length;
            Arrays.sort(rewardValues);
            int maxValue = rewardValues[n - 1];
            boolean[] dp = new boolean[maxValue * 2];
            dp[0] = true;
            for (int rewardValue : rewardValues) {
                for (int k = 2 * rewardValue - 1; k >= rewardValue; --k) {
                    if (dp[k - rewardValue]) dp[k] = true;
                }
            }
            int res = 0;
            for (int i = 0; i < dp.length; i++) {
                if (dp[i]) res = i;
            }
            return res;
        }

    }

}
