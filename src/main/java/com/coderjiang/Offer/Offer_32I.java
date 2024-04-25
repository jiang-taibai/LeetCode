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
public class Offer_32I {

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
        public int[] levelOrder(TreeNode root) {
            Queue<TreeNode> que = new LinkedList<>();
            List<Integer> res = new ArrayList<>();
            que.add(root);
            while (que.size() != 0) {
                TreeNode node = que.poll();
                res.add(node.val);
                if (node.left != null) {
                    que.add(node.left);
                }
                if (node.right != null) {
                    que.add(node.right);
                }
            }
            int[] ans = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                ans[i] = res.get(i);
            }
            return ans;
        }
    }

}
