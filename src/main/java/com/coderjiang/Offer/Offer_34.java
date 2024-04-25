package com.coderjiang.Offer;

import com.coderjiang.LeetCodeUtil.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <p>Creation Time: 2021-12-17 20:19:33</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class Offer_34 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {

        private List<List<Integer>> results = new ArrayList<>();
        private Stack<Integer> curPath = new Stack<>();

        public List<List<Integer>> pathSum(TreeNode root, int target) {
            dfs(root, target, 0);
            return results;
        }

        private void dfs(TreeNode root, int target, int curSum) {
            if(root == null || root.val + curSum > target) return;
            curPath.push(root.val);
            if(root.val + curSum == target && root.left == null && root.right == null)
                results.add(new ArrayList<>(curPath));
            dfs(root.left, target, curSum + root.val);
            dfs(root.right, target, curSum + root.val);
            curPath.pop();
        }

    }

}
