package com.coderjiang.DailyPractice.Monthly_2024_02;


import com.coderjiang.LeetCodeUtil.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <p>Creation Time: 2024-02-07</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_02_07 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        public TreeNode replaceValueInTree(TreeNode root) {
            Queue<TreeNode> cur = new ArrayDeque<>();
            cur.offer(root);
            while (!cur.isEmpty()) {
                Queue<TreeNode> next = new ArrayDeque<>();
                // 孩子层的和
                int sumOfLevel = 0;
                for (TreeNode node : cur) {
                    if (node.left != null) {
                        next.offer(node.left);
                        sumOfLevel += node.left.val;
                    }
                    if (node.right != null) {
                        next.offer(node.right);
                        sumOfLevel += node.right.val;
                    }
                }
                for (TreeNode node : cur) {
                    int sumOfSon = (node.left == null ? 0 : node.left.val) + (node.right == null ? 0 : node.right.val);
                    if (node.left != null) node.left.val = sumOfLevel - sumOfSon;
                    if (node.right != null) node.right.val = sumOfLevel - sumOfSon;
                }
                cur = next;
            }
            root.val = 0;
            return root;
        }

    }

}
