package com.coderjiang.RegularPractice;

import java.util.List;

/**
 * <p>Creation Time: 2023-03-14 02:49:15</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class T120_三角形最小路径和 {
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            int n = triangle.size();
            int[] dp = new int[1];
            dp[0] = triangle.get(0).get(0);
            for (int i = 1; i < n; ++i) {
                int[] dp2 = new int[i + 1];
                for (int j = 0; j <= i; ++j) {
                    if (j == 0) dp2[j] = dp[j] + triangle.get(i).get(j);
                    else if (j == i) dp2[j] = dp[j - 1] + triangle.get(i).get(j);
                    else dp2[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j);
                }
                dp = dp2;
            }

            int res = Integer.MAX_VALUE;
            for (int i = 0; i < n; ++i) {
                if (dp[i] < res) res = dp[i];
            }
            return res;
        }
    }
}
