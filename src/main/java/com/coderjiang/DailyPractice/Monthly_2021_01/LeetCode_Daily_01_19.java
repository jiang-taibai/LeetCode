package com.coderjiang.DailyPractice.Monthly_2021_01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <p>创建时间：2021/1/19 10:16</p>
 * <p>主要功能：给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
 * 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。
 * 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。</p>
 *
 * @author 刘江
 */
public class LeetCode_Daily_01_19 {
    public static void main(String[] args) {

    }

    class Solution {
        public int minCostConnectPoints(int[][] points) {
            int n = points.length;
            int[][] map = new int[n][n];
            PriorityQueue<List<Integer>> queue = new PriorityQueue<>(Comparator.comparing(l -> l.get(0)));
            for (int i = 0; i < n; ++i) {
                for (int j = i + 1; j < n; ++j) {
                    map[i][j] = map[j][i] = getDistance(points[i], points[j]);
                    List<Integer> list = new ArrayList<>();
                    list.add(map[i][j]);
                    list.add(i);
                    list.add(j);
                    queue.add(list);
                }
            }
            UnionFind unionFind = new UnionFind(n);
            int cost = 0;
            while (!queue.isEmpty()) {
                List<Integer> list = queue.poll();
                int distance = list.get(0);
                int p1 = list.get(1);
                int p2 = list.get(2);
                if (!unionFind.isConnect(p1, p2)) {
                    cost += distance;
                    unionFind.union(p1, p2);
                    // 这里加一个循环结束的判断
                }
            }
            return cost;
        }

        private int getDistance(int[] p1, int[] p2) {
            return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
        }

        class UnionFind {
            private int[] arr;

            public UnionFind(int size) {
                arr = new int[size];
                for (int i = 0; i < size; ++i) {
                    arr[i] = i;
                }
            }

            private int find(int son) {
                int father = arr[son];
                while (father != arr[father]) {
                    father = arr[father];
                }
                int next = son;
                while (arr[son] != father) {
                    next = arr[son];
                    arr[son] = father;
                    son = next;
                }
                return father;
            }

            private void union(int son1, int son2) {
                arr[find(son1)] = find(son2);
            }

            private boolean isConnect(int son1, int son2) {
                return find(son1) == find(son2);
            }
        }
    }
}
