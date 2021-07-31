package com.coderjiang.DailyPractice.Monthly_2021_07;


import com.coderjiang.LeetCodeUtil.TreeNode;

import java.util.*;

/**
 * <p>Creation Time: 2021-07-31 14:57:58</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_07_31 {

    class Solution {

        private class CoordsNode implements Comparable<CoordsNode> {
            int row, col;
            TreeNode node;

            public CoordsNode(int row, int col, TreeNode node) {
                this.row = row;
                this.col = col;
                this.node = node;
            }

            @Override
            public int compareTo(CoordsNode o) {
                if (this.col != o.col) return this.col - o.col;
                if (this.row != o.row) return this.row - o.row;
                return this.node.val - o.node.val;
            }

            @Override
            public String toString() {
                return "CoordsNode{" +
                        "row=" + row +
                        ", col=" + col +
                        '}';
            }
        }

        private final List<CoordsNode> allNode = new ArrayList<>();

        public List<List<Integer>> verticalTraversal(TreeNode root) {
            bfs(root);
            Collections.sort(allNode);
//            allNode.forEach(System.out::println);
            List<List<Integer>> results = new ArrayList<>();
            int curCol = allNode.get(0).col - 1;
            for (CoordsNode coordsNode : allNode) {
                if (coordsNode.col > curCol) {
                    curCol = coordsNode.col;
                    results.add(new ArrayList<>());
                }
                results.get(results.size() - 1).add(coordsNode.node.val);
            }
            return results;
        }

        private void bfs(TreeNode root) {
            Queue<CoordsNode> que = new LinkedList<>();
            que.add(new CoordsNode(0, 0, root));
            while (!que.isEmpty()) {
                CoordsNode curCoordsNode = que.poll();
                allNode.add(curCoordsNode);
                TreeNode curTreeNode = curCoordsNode.node;
                int row = curCoordsNode.row;
                int col = curCoordsNode.col;
                if (curTreeNode.left != null) {
                    que.add(new CoordsNode(row + 1, col - 1, curTreeNode.left));
                }
                if (curTreeNode.right != null) {
                    que.add(new CoordsNode(row + 1, col + 1, curTreeNode.right));
                }
            }
        }

    }

}
