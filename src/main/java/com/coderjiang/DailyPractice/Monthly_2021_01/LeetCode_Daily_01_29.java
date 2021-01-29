package com.coderjiang.DailyPractice.Monthly_2021_01;

import java.util.PriorityQueue;

/**
 * <p>创建时间：2021/1/29 11:20</p>
 * <p>主要功能：你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
 * 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
 * 请你返回从左上角走到右下角的最小 体力消耗值 。</p>
 *
 * @author 刘江
 */
public class LeetCode_Daily_01_29 {
    public static void main(String[] args) {

    }

    /**
     * 给老子并查集！！！！！
     */
    class Solution {
        public int minimumEffortPath(int[][] heights) {
            int rows = heights.length;
            int cols = heights[0].length;
            PriorityQueue<Edge> edges = new PriorityQueue<Edge>();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int fromIndex = getIndex(i, j, cols);
                    int downIndex = getIndex(i + 1, j, cols);
                    int rightIndex = getIndex(i, j + 1, cols);
                    if (i + 1 < rows) {
                        edges.add(new Edge(fromIndex, downIndex,
                                Math.abs(heights[i][j] - heights[i + 1][j])));
                    }
                    if (j + 1 < cols) {
                        edges.add(new Edge(fromIndex, rightIndex,
                                Math.abs(heights[i][j] - heights[i][j + 1])));
                    }
                }
            }
            int beginIndex = 0;
            int endIndex = rows * cols - 1;
            if (beginIndex == endIndex) return 0;
            UnionFind uf = new UnionFind(rows * cols);
            while (!edges.isEmpty()) {
                Edge edge = edges.poll();
                if (!uf.isFamily(edge.from, edge.to)) {
                    uf.union(edge.from, edge.to);
                    if (uf.isFamily(beginIndex, endIndex)) {
                        return edge.weight;
                    }
                }
            }
            return -1;
        }

        private int getIndex(int i, int j, int cols) {
            return i * cols + j;
        }

        class Edge implements Comparable<Edge> {
            public int from;
            public int to;
            public int weight;

            Edge(int from, int to, int weight) {
                this.from = from;
                this.to = to;
                this.weight = weight;
            }

            @Override
            public int compareTo(Edge o) {
                return weight - o.weight;
            }
        }

        class UnionFind {
            private int[] arr;

            public UnionFind(int size) {
                arr = new int[size];
                for (int i = 0; i < size; i++) {
                    arr[i] = i;
                }
            }

            public int find(int son) {
                int father = arr[son];
                while (father != arr[father]) father = arr[father];
                while (father != arr[son]) {
                    int next = arr[son];
                    arr[son] = father;
                    son = next;
                }
                return father;
            }

            public int union(int son1, int son2) {
                return arr[find(son1)] = find(son2);
            }

            public boolean isFamily(int son1, int son2) {
                return find(son1) == find(son2);
            }
        }
    }
}
