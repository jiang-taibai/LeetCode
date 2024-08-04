package com.coderjiang.DailyPractice.Monthly_2024_08;

import com.coderjiang.LeetCodeUtil.TreeNode;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-08-04 17:02:59</p>
 */
public class DailyPractice_20240804 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            return solve(root, subRoot, false);
        }

        private boolean solve(TreeNode root, TreeNode subRoot, boolean continuous) {
            if (root == null && subRoot == null) return true;
            if (root == null || subRoot == null) return false;
            return (root.val == subRoot.val && solve(root.left, subRoot.left, true) && solve(root.right, subRoot.right, true))
                    || (!continuous && solve(root.left, subRoot, false))
                    || (!continuous && solve(root.right, subRoot, false));
        }
    }

}
