package com.coderjiang.DailyPractice.Monthly_2021_11;


import com.coderjiang.LeetCodeUtil.TreeNode;

/**
 * <p>Creation Time: 2021-11-18 01:45:10</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_11_18 {

    class Solution {

        private int res = 0;

        public int findTilt(TreeNode root) {
            dfs(root);
            return res;
        }

        private void dfs(TreeNode root) {
            if (root == null) return;
            dfs(root.left);
            dfs(root.right);
            if (root.left != null || root.right != null) {
                res += Math.abs((root.left != null ? root.left.val : 0) - (root.right != null ? root.right.val : 0));
            }
            root.val += (root.left != null ? root.left.val : 0);
            root.val += (root.right != null ? root.right.val : 0);
        }
    }

}
