package com.coderjiang.DailyPractice.Monthly_2021_09;


import com.coderjiang.LeetCodeUtil.TreeNode;

/**
 * <p>Creation Time: 2021-09-28 23:38:40</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_09_28 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {

        public int pathSum(TreeNode root, int targetSum) {
            if (root == null) return 0;
            return rootSum(root, 0, targetSum) +
                    pathSum(root.left, targetSum) +
                    pathSum(root.right, targetSum);
        }

        private int rootSum(TreeNode root, int curSum, final int targetSum) {
            if (root == null) return 0;
            return ((curSum += root.val) == targetSum ? 1 : 0) +
                    rootSum(root.left, curSum, targetSum) +
                    rootSum(root.right, curSum, targetSum);
        }
    }

}
