package com.coderjiang.DailyPractice.Monthly_2024_04;

import com.coderjiang.LeetCodeUtil.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-04-24 16:39:36</p>
 */
public class DailyPractice_20240424 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        private final Map<Integer, TreeNode> father = new HashMap<>();
        private int start;
        private TreeNode startNode = null;
        private static final int MAX_VAL = (int) 1e5;

        public int amountOfTime(TreeNode root, int start) {
            this.start = start;
            father.put(root.val, null);
            buildFatherMap(root);
            boolean[] vis = new boolean[MAX_VAL + 10];
            vis[start] = true;
            return maxDepth(startNode, vis) - 1;
        }

        private void buildFatherMap(TreeNode root) {
            if (root == null) return;
            if (root.val == start) startNode = root;
            if (root.left != null) father.put(root.left.val, root);
            if (root.right != null) father.put(root.right.val, root);
            buildFatherMap(root.left);
            buildFatherMap(root.right);
        }

        private int maxDepth(TreeNode root, boolean[] vis) {
            int localMaxDepth = 0;
            if (root.left != null && !vis[root.left.val]) {
                vis[root.left.val] = true;
                localMaxDepth = Integer.max(localMaxDepth, maxDepth(root.left, vis));
            }
            if (root.right != null && !vis[root.right.val]) {
                vis[root.right.val] = true;
                localMaxDepth = Integer.max(localMaxDepth, maxDepth(root.right, vis));
            }
            TreeNode fatherNode = father.get(root.val);
            if (fatherNode != null && !vis[fatherNode.val]) {
                vis[fatherNode.val] = true;
                localMaxDepth = Integer.max(localMaxDepth, maxDepth(fatherNode, vis));
            }
            return localMaxDepth + 1;
        }
    }

}
