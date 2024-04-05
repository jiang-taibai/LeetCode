package com.coderjiang.DailyPractice.Monthly_2024_04;


import com.coderjiang.LeetCodeUtil.TreeNode;

/**
 * <p>Creation Time: 2024/4/13</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_04_05 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        private int res = 0;

        public int maxAncestorDiff(TreeNode root) {
            dfs(root);
            return res;
        }

        private int[] dfs(TreeNode root) {
            if (root == null) return new int[]{-1, -1};
            int[] lhs = dfs(root.left);
            int[] rhs = dfs(root.right);
            lhs[0] = min(lhs[0], rhs[0]);
            lhs[1] = max(lhs[1], rhs[1]);
            int maxDiff = 0;
            if (lhs[0] != -1) maxDiff = Integer.max(maxDiff, Math.abs(root.val - lhs[0]));
            if (lhs[1] != -1) maxDiff = Integer.max(maxDiff, Math.abs(root.val - lhs[1]));
            if (maxDiff > res) res = maxDiff;
            lhs[0] = min(root.val, lhs[0]);
            lhs[1] = max(root.val, lhs[1]);
            return lhs;
        }

        private int min(int a, int b) {
            if (a == -1) return b;
            if (b == -1) return a;
            return Integer.min(a, b);
        }

        private int max(int a, int b) {
            if (a == -1) return b;
            if (b == -1) return a;
            return Integer.max(a, b);
        }
    }

}
