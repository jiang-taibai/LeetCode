package com.coderjiang.Offer;

import com.coderjiang.LeetCodeUtil.TreeNode;

/**
 * <p>Creation Time: 2021-12-09 22:30:30</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class Offer_26 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (A == null) return B == null;
            else {
                if (B == null) return true;
            }
            return dfs(A, B);
        }

        private boolean dfs(TreeNode root, TreeNode target) {
            if (root == null) return false;
            if (root.val == target.val && check(root, target)) return true;
            return dfs(root.left, target) || dfs(root.right, target);
        }

        private boolean check(TreeNode root, TreeNode target) {
            if (root.val != target.val) return false;
            if (root.left != null) {
                if (target.left != null && !check(root.left, target.left)) return false;
            } else {
                if (target.left != null) return false;
            }
            if (root.right != null) {
                if (target.right != null && !check(root.right, target.right)) return false;
            } else {
                if (target.right != null) return false;
            }
            return true;
        }
    }

}
