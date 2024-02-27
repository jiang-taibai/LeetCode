package com.coderjiang.DailyPractice.Monthly_2024_02;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Creation Time: 2024/2/27</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_02_27 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        static class TreeNode {
            public int val;
            public boolean prime;
            public TreeNode father;
            public long groupSize;
            public List<TreeNode> children;

            public TreeNode(int val) {
                children = new ArrayList<>();
                this.val = val;
                this.prime = true;
                this.father = this;
                this.groupSize = 1;
            }
        }

        public long countPaths(int n, int[][] edges) {
            // 一条路径
            // AB -> 1
            // ABA -> 3(+2)
            // ABAA -> 5(+2)
            // AA -> 0
            // AAB -> 2
            // AABA -> 5(+3)
            // AABAA -> 8(+3)
            // BAAB -> 2
            TreeNode[] nodes = buildTree(n, edges);
            long res = 0;
            for (int i = 1; i <= n; i++) {
                if (nodes[i].prime) {
                    res += calCountOfCombination(n, nodes[i]);
                }
            }
            return res;
        }

        private TreeNode[] buildTree(int n, int[][] edges) {
            TreeNode[] nodes = new TreeNode[n + 1];
            for (int i = 0; i <= n; i++) {
                nodes[i] = new TreeNode(i);
            }
            for (int i = 2; i <= n; i++) {
                if (!nodes[i].prime) continue;
                for (int j = i + i; j <= n; j += i) {
                    nodes[j].prime = false;
                }
            }
            nodes[1].prime = false;
            for (int[] edge : edges) {
                int u = edge[0], v = edge[1];
                if (!nodes[u].prime && !nodes[v].prime) {
                    combine(nodes[u], nodes[v]);
                }
                nodes[u].children.add(nodes[v]);
                nodes[v].children.add(nodes[u]);
            }
            return nodes;
        }

        private long calCountOfCombination(int n, TreeNode root) {
            long res = 0;
            List<Long> groups = new ArrayList<>();
            for (int i = 0; i < root.children.size(); i++) {
                TreeNode sub = root.children.get(i);
                if (sub.prime) continue;
                boolean[] vis = new boolean[n + 1];
                groups.add(find(sub).groupSize);
            }
            for (int i = 0; i < groups.size(); i++) {
                res += groups.get(i);
                for (int j = i + 1; j < groups.size(); j++) {
                    res += groups.get(i) * groups.get(j);
                }
            }
            return res;
        }

        private long getCompositeNumberGroupSize(TreeNode root, boolean[] vis) {
            if (vis[root.val]) return 0;
            else vis[root.val] = true;
            long res = 1;
            for (int i = 0; i < root.children.size(); i++) {
                TreeNode sub = root.children.get(i);
                if (sub.prime) continue;
                res += getCompositeNumberGroupSize(sub, vis);
            }
            return res;
        }

        private TreeNode find(TreeNode root) {
            return root.father == root ? root : (root.father = find(root.father));
        }

        private TreeNode combine(TreeNode a, TreeNode b) {
            TreeNode fa = find(a), fb = find(b);
            if (fa != fb) {
                fb.father = fa;
                fa.groupSize += fb.groupSize;
            }
            return fa;
        }

    }

}
