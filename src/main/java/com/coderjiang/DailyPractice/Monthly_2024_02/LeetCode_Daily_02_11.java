package com.coderjiang.DailyPractice.Monthly_2024_02;


import com.coderjiang.LeetCodeUtil.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>Creation Time: 2024-02-11</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_02_11 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        private final List<Integer> res = new LinkedList<>();

        public List<Integer> preorderTraversal(TreeNode root) {
            dfs(root);
            return res;
        }

        private void dfs(TreeNode root) {
            if (root == null) return;
            res.add(root.val);
            dfs(root.left);
            dfs(root.right);
        }
    }

}
