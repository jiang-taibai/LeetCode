package com.coderjiang.DailyPractice.Monthly_2024_09;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-09-11 11:33:11</p>
 */
public class DailyPractice_20240911 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int maximizeWin(int[] prizePositions, int k) {
            int n = prizePositions.length;
            int[] dp = new int[n + 1];
            int left = 0, right = 0;
            int res = 0;
            while (right < n) {
                while (prizePositions[right] - prizePositions[left] > k) {
                    left++;
                }
                res = Math.max(res, right - left + 1 + dp[left]);
                dp[right + 1] = Math.max(dp[right], right - left + 1);
                right++;
            }
            return res;
        }
    }

}

/*
[1,1,2,2,3,3,5]


[0,2,2,2,0,1,0]
[0,1,2,3,4,5,6] k=2
[2,3,4,5,6,7,8]
1: [0, 1] - [1]
1: [0, 1, 2
 */
