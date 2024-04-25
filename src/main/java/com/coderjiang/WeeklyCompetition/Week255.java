package com.coderjiang.WeeklyCompetition;

import java.util.Arrays;

/**
 * <p>Creation Time: 2021-08-22 10:30:01</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class Week255 {

    class Solution {
        public int findGCD(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            return gcd(nums[0], nums[n - 1]);
        }

        private int gcd(int a, int b) {
            return a == 0 ? b : gcd(b % a, a);
        }
    }

    static class Solution2 {
        public String findDifferentBinaryString(String[] nums) {
            boolean[] vis = new boolean[65536 + 10];
            for (String num : nums) {
                vis[Integer.valueOf(num, 2)] = true;
            }

            for (int i = 0; i < 65536; ++i) {
                if (!vis[i]) return itos(i, nums.length);
            }
            return "";
        }

        private String itos(int num, int n) {
            StringBuilder sb = new StringBuilder();
            for (int i = n - 1; i >= 0; --i) {
                if ((num & (1 << i)) != 0) {
                    sb.append('1');
                } else {
                    sb.append('0');
                }
            }
            return sb.toString();
        }

    }

    static class Solution3 {

        private int[][] memo;

        public int minimizeTheDifference(int[][] mat, int target) {
            memo = new int[mat.length + 10][target * 2 + 10];
            return dfs(mat, 0, 0, target);
        }

        private int dfs(int[][] mat, int level, int curSum, int target) {
            if (memo[level][curSum] != 0) return memo[level][curSum];
            int n = mat.length;
            if (level == n) return Math.abs(curSum - target);
            int res = target;
            for (int i = 0; i < mat[level].length; ++i) {
                if (curSum + mat[level][i] <= target * 2) {
                    res = Math.min(res, dfs(mat, level + 1, curSum + mat[level][i], target));
                }
            }
            memo[level][curSum] = res;
            return res;
        }
    }

    static class Solution3_1 {

        public int minimizeTheDifference(int[][] mat, int target) {
            int n = mat.length;
            int m = mat[0].length;
            // dp[i][j]表示前i行中挑出一个是否能组成和为j的子集
            boolean[][] dp = new boolean[n + 1][5000];
            for (int i = 0; i < m; ++i) {
                dp[0][mat[0][i]] = true;
            }
            for (int i = 1; i < n; ++i) {
                for (int sum = 0; sum <= 4900; ++sum) {
                    for (int j = 0; j < m; ++j) {
                        if (sum - mat[i][j] >= 0 && dp[i - 1][sum - mat[i][j]]) {
                            dp[i][sum] = true;
                        }
                    }
                }
            }
            int res = target;
            for (int i = 0; i <= 4900; ++i) {
                if (dp[n - 1][i])
                    res = Math.min(res, Math.abs(i - target));
            }
            return res;
        }

    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.findDifferentBinaryString(new String[]{"00", "01"}));
    }

}
