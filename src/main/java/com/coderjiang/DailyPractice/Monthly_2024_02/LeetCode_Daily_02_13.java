package com.coderjiang.DailyPractice.Monthly_2024_02;


import com.coderjiang.LeetCodeUtil.TreeNode;

import java.util.*;

/**
 * <p>Creation Time: 2024-02-13</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_02_13 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        private final Map<Integer, List<Integer>> nodes = new HashMap<>();

        public List<List<Integer>> verticalTraversal(TreeNode root) {
            dfs(root, 0, 0);
            List<List<Integer>> res = new ArrayList<>();
            for (int col = -999; col <= 999; col++) {
                List<Integer> nodesInColumn = new ArrayList<>();
                for (int row = 0; row <= 999; row++) {
                    int hashcode = getNodeIndexHashcode(row, col);
                    if (nodes.containsKey(hashcode)) {
                        List<Integer> nodesInThisPlace = nodes.get(hashcode);
                        if (nodesInThisPlace.size() > 1) {
                            Collections.sort(nodesInThisPlace);
                        }
                        nodesInColumn.addAll(nodesInThisPlace);
                    }
                }
                if (!nodesInColumn.isEmpty()) {
                    res.add(nodesInColumn);
                }
            }
            return res;
        }

        private void dfs(TreeNode root, int row, int col) {
            if (root == null) return;
            int hashcode = getNodeIndexHashcode(row, col);
            nodes.computeIfAbsent(hashcode, k -> new ArrayList<>()).add(root.val);
            dfs(root.left, row + 1, col - 1);
            dfs(root.right, row + 1, col + 1);
        }

        private int getOffsetCol(int col) {
            return col + 999;
        }

        private int getNodeIndexHashcode(int row, int col) {
            return getOffsetCol(col) * 1000 + row;
        }
    }

    static class Solution2 {

        private final List<int[]> nodes = new ArrayList<>();

        public List<List<Integer>> verticalTraversal(TreeNode root) {
            dfs(root, 0, 0);
            // 问：为什么要先比较是不是不同列，再比较不同行？而不是先比较行再比较列？
            // 答：这反映了排序规则，是先按列排序，再按行排序，最后按值排序
            nodes.sort((lhs, rhs) -> {
                if (lhs[1] != rhs[1]) {
                    return lhs[1] - rhs[1];
                } else if (lhs[0] != rhs[0]) {
                    return lhs[0] - rhs[0];
                } else {
                    return lhs[2] - rhs[2];
                }
            });
            List<List<Integer>> res = new ArrayList<>();
            int currentColIndex = nodes.get(0)[1];
            List<Integer> nodeInCurrentCol = new ArrayList<>();
            for (int[] node : nodes) {
                if (node[1] != currentColIndex) {
                    res.add(nodeInCurrentCol);
                    currentColIndex = node[1];
                    nodeInCurrentCol = new ArrayList<>();
                }
                nodeInCurrentCol.add(node[2]);
            }
            res.add(nodeInCurrentCol);
            return res;
        }

        private void dfs(TreeNode root, int row, int col) {
            if (root == null) return;
            nodes.add(new int[]{row, col, root.val});
            dfs(root.left, row + 1, col - 1);
            dfs(root.right, row + 1, col + 1);
        }
    }


}
