package com.coderjiang.DailyPractice.Monthly_2021_12;


import com.coderjiang.LeetCodeUtil.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>Creation Time: 2021-12-25 22:33:16</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_12_25 {

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
        public boolean isEvenOddTree(TreeNode root) {
            Queue<TreeNode> que = new LinkedList<>();
            que.add(root);
            int curLevel = 0;
            while (!que.isEmpty()) {
                Queue<TreeNode> next = new LinkedList<>();
                int pre = -1;
                if ((curLevel & 1) == 1) pre = Integer.MAX_VALUE;
                while (!que.isEmpty()) {
                    TreeNode node = que.poll();
                    if ((curLevel & 1) == 0) {
                        if (node.val <= pre || (node.val & 1) == 1) return false;
                    } else {
                        if (node.val >= pre || (node.val & 1) == 0) return false;
                    }
                    pre = node.val;
                    if (node.left != null) next.add(node.left);
                    if (node.right != null) next.add(node.right);
                }
                que = next;
                curLevel++;
            }
            return true;
        }
    }

}
