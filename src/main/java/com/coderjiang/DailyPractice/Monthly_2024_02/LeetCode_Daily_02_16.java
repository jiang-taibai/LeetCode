package com.coderjiang.DailyPractice.Monthly_2024_02;


import com.coderjiang.LeetCodeUtil.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>Creation Time: 2024-02-16</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_02_16 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new LinkedList<>();
            if (root == null) return res;
            Queue<TreeNode> cur = new LinkedList<>();
            cur.offer(root);
            boolean reverse = false;
            while (!cur.isEmpty()) {
                List<Integer> row = new LinkedList<>();
                Queue<TreeNode> next = new LinkedList<>();
                while (!cur.isEmpty()) {
                    TreeNode node = cur.poll();
                    if (reverse) row.add(0, node.val);
                    else row.add(node.val);
                    if (node.left != null) next.offer(node.left);
                    if (node.right != null) next.offer(node.right);
                }
                reverse = !reverse;
                res.add(row);
                cur = next;
            }
            return res;
        }
    }

}
