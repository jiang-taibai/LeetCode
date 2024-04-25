package com.coderjiang.RegularPractice;

/**
 * <p>Creation Time: 2023-03-13 15:16:03</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class T96_不同的二叉搜索树 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numTrees(3));
    }

    static class Solution_DFS {

        // private int n;
        private int[][] memo;

        public int numTrees(int n) {
            // this.n = n;
            this.memo = new int[n + 1][n + 1];
            return dfs(1, n);
        }

        private int dfs(int l, int r) {
            if (r < l) return 0;
            if (r == l) return 1;
            if (memo[l][r] != 0) return memo[l][r];
            int res = 0;
            for (int i = l; i <= r; ++i) {
                // 选取i为根节点
                if (i == l) res += dfs(i + 1, r);
                else if (i == r) res += dfs(l, i - 1);
                else res += dfs(l, i - 1) * dfs(i + 1, r);
            }
            // System.out.printf("%d,%d: %d\n", l, r, res);
            return memo[l][r] = res;
        }
    }

    static class Solution {
        public int numTrees(int n) {
            int[] dp = new int[n + 1];
            dp[0] = dp[1] = 1;
            for (int i = 2; i <= n; ++i) {
                for (int j = 1; j <= i; ++j) {
                    dp[i] += dp[j - 1] * dp[i - j];
                }
            }
            return dp[n];
        }
    }
}


