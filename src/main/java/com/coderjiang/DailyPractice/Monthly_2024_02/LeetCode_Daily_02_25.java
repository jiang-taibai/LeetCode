package com.coderjiang.DailyPractice.Monthly_2024_02;


import com.coderjiang.LeetCodeUtil.TreeNode;

import java.util.*;

/**
 * <p>Creation Time: 2024-02-25</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_02_25 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return null;
            long rsp = root.val - p.val;
            long rsq = root.val - q.val;
            if (rsp * rsq == 0) return rsp == 0 ? p : q;
            else if (rsp * rsq < 0) {
                return root;
            } else {
                return rsp < 0 ? lowestCommonAncestor(root.right, p, q) : lowestCommonAncestor(root.left, p, q);
            }
        }

    }

}
