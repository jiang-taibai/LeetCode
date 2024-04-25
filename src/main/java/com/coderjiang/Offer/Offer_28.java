package com.coderjiang.Offer;

import com.coderjiang.LeetCodeUtil.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>Creation Time: 2021-12-10 00:02:19</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class Offer_28 {

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
            Queue<TreeNode> que = new LinkedList<>();
            que.add(root);
            while (!que.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                Queue<TreeNode> next = new LinkedList<>();
                while (!que.isEmpty()) {
                    TreeNode node = que.poll();
                    if (node.left != null) {
                        list.add(node.left.val);
                        next.add(node.left);
                    } else {
                        list.add(null);
                    }
                    if (node.right != null) {
                        list.add(node.right.val);
                        next.add(node.right);
                    } else {
                        list.add(null);
                    }
                }
                if (!check(list)) return false;
                que = next;
            }
            return true;
        }

        private boolean check(List<Integer> list) {
            int i = 0, j = list.size() - 1;
            while (i < j) {
                if (list.get(i) == null) {
                    if (list.get(j) != null) return false;
                } else if (!list.get(i).equals(list.get(j))) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    }

}
