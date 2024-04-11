package com.coderjiang.DailyPractice.Monthly_2024_04;

import com.coderjiang.LeetCodeUtil.TreeNode;

import java.util.*;

/**
 * <p>Creation Time: 2024/4/11</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_04_11 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        static class TreeNode {
            public int idx;
            public int val;
            public List<TreeNode> children = new ArrayList<>();
            public TreeNode la;
            public int level;

            public TreeNode() {
            }

            public TreeNode(int val, int idx) {
                this.val = val;
                this.idx = idx;
            }

            @Override
            public String toString() {
                return "TreeNode{" +
                        "idx=" + idx +
                        ", val=" + val +
                        ", level=" + level +
                        '}';
            }
        }

        public int[] getCoprimes(int[] nums, int[][] edges) {
            int n = nums.length;
            List<TreeNode> nodes = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                nodes.add(new TreeNode(nums[i], i));
            }
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1];
                nodes.get(u).children.add(nodes.get(v));
                nodes.get(v).children.add(nodes.get(u));
            }
            bfs(nodes.get(0), n);
            for (TreeNode node : nodes) {
                System.out.println(node);
            }
            List<LinkedList<TreeNode>> prevNodes = new ArrayList<>();
            for (int i = 0; i <= 50; i++) {
                prevNodes.add(new LinkedList<>());
            }
            boolean[] vis = new boolean[n];
            dfs(nodes.get(0), prevNodes, vis);
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                TreeNode node = nodes.get(i);
                res[i] = node.la == null ? -1 : node.la.idx;
            }
            return res;
        }

        private void bfs(TreeNode root, int n) {
            boolean[] vis = new boolean[n];
            Deque<TreeNode> cur = new LinkedList<>();
            cur.add(root);
            vis[root.idx] = true;
            int level = 1;
            while (!cur.isEmpty()) {
                Deque<TreeNode> next = new LinkedList<>();
                while (!cur.isEmpty()) {
                    TreeNode node = cur.poll();
                    node.level = level;
                    for (TreeNode child : node.children) {
                        if (!vis[child.idx]) {
                            vis[child.idx] = true;
                            next.add(child);
                        }
                    }
                }
                cur = next;
                level++;
            }
        }

        private void dfs(TreeNode root, List<LinkedList<TreeNode>> prevNodes, boolean[] vis) {
            if (vis[root.idx]) return;
            int maxLevel = -1;
            TreeNode maxLevelNode = null;
            for (int i = 1; i < prevNodes.size(); i++) {
                if (gcd(root.val, i) == 1) {
                    for (TreeNode prevNode : prevNodes.get(i)) {
                        if (prevNode.level > maxLevel) {
                            maxLevelNode = prevNode;
                            maxLevel = prevNode.level;
                        }
                    }
                }
            }
            root.la = maxLevelNode;
            prevNodes.get(root.val).add(root);
            vis[root.idx] = true;
            for (TreeNode child : root.children) {
                dfs(child, prevNodes, vis);
            }
            prevNodes.get(root.val).removeLast();
            vis[root.idx] = false;
        }

        private int gcd(int a, int b) {
            for (int i = Math.min(a, b); i >= 1; i--) {
                if (a % i == 0 && b % i == 0) return i;
            }
            return 1;
        }
    }

}

/*
ABC三数
路径
5, 6, 2, 4
-1, 0, 0, 0
 */