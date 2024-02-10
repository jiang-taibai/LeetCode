package com.coderjiang.DailyPractice.Monthly_2024_02;


import com.coderjiang.LeetCodeUtil.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>Creation Time: 2024-02-10</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_02_10 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        private final List<Integer> path = new LinkedList<>();

        public List<Integer> inorderTraversal(TreeNode root) {
            dfs(root);
            return path;
        }

        public void dfs(TreeNode root) {
            if (root == null) return;
            dfs(root.left);
            path.add(root.val);
            dfs(root.right);
        }
    }

}
