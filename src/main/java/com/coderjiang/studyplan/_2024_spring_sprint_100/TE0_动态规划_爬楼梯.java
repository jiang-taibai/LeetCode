package com.coderjiang.StudyPlan._2024_spring_sprint_100;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-07-05 15:01:40</p>
 */
public class TE0_动态规划_爬楼梯 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int climbStairs(int n) {
            int[] dp = new int[n + 1];
            dp[0] = dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }

}
