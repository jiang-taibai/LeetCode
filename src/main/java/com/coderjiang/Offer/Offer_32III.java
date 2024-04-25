package com.coderjiang.Offer;

import com.coderjiang.LeetCodeUtil.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>Creation Time: 2021-12-09 22:12:02</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class Offer_32III {

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
        public List<List<Integer>> levelOrder(TreeNode root) {
            Queue<TreeNode> que = new LinkedList<>();
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            que.add(root);
            boolean isReverse = false;
            while (que.size() != 0) {
                Queue<TreeNode> next = new LinkedList<>();
                List<Integer> level = new ArrayList<>();
                while (que.size() != 0) {
                    TreeNode node = que.poll();
                    if (isReverse)
                        level.add(0, node.val);
                    else level.add(node.val);
                    if (node.left != null) {
                        next.add(node.left);
                    }
                    if (node.right != null) {
                        next.add(node.right);
                    }
                }
                que = next;
                res.add(level);
                isReverse = !isReverse;
            }
            return res;
        }
    }

}
