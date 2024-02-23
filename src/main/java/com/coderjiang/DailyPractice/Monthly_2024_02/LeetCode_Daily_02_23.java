package com.coderjiang.DailyPractice.Monthly_2024_02;


import com.coderjiang.LeetCodeUtil.TreeNode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <p>Creation Time: 2024-02-23</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_02_23 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public long kthLargestLevelSum(TreeNode root, int k) {
            if (root == null) return 0;
            Queue<Long> allSumOfLevel = new PriorityQueue<>(Comparator.reverseOrder());
            Queue<TreeNode> cur = new LinkedList<>();
            cur.offer(root);
            while (!cur.isEmpty()) {
                Queue<TreeNode> next = new LinkedList<>();
                long sum = 0;
                while (!cur.isEmpty()) {
                    TreeNode node = cur.poll();
                    sum += node.val;
                    if (node.left != null) next.offer(node.left);
                    if (node.right != null) next.offer(node.right);
                }
                allSumOfLevel.offer(sum);
                cur = next;
            }
            if (allSumOfLevel.size() < k) return -1;
            for (int i = 0; i < k - 1; i++) {
                allSumOfLevel.poll();
            }
            return allSumOfLevel.poll();
        }
    }

}
