package com.coderjiang.Offer;

import com.coderjiang.LeetCodeUtil.TreeNode;

/**
 * <p>Creation Time: 2021-12-10 00:25:31</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class Offer_28Better {

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
        public boolean isSymmetric(TreeNode root) {
            return root == null || dfs(root.left, root.right);
        }

        public boolean dfs(TreeNode l, TreeNode r) {
            if (l == null && r == null) return true;
            if (l == null || r == null || l.val != r.val) return false;
            return dfs(l.left, r.right) && dfs(l.right, r.left);
        }
    }

}
