package com.coderjiang.DailyPractice.Monthly_2021_01;

/**
 * <p>创建时间：2021/1/30 11:46</p>
 * <p>主要功能：TODO</p>
 *
 * @author 刘江
 */
public class LeetCode_Daily_01_30 {
    public static void main(String[] args) {

    }

    class Solution {
        public int swimInWater(int[][] grid) {
            int n = grid.length;
            UnionFind uf = new UnionFind(n * n);
            int startIndex = 0;
            int endIndex = n * n - 1;
            int currLevel = 0;
            while (!uf.isFamily(startIndex, endIndex)) {
                for (int[] row : grid) {
                    for (int i = 0; i < row.length; i++) {
                        row[i]++;
                    }
                }
                currLevel++;
                for (int i = 0; i < n; ++i) {
                    for (int j = 0; j < n; ++j) {
                        if (grid[i][j] < currLevel) continue;
                        if (i + 1 < n && grid[i + 1][j] < currLevel) {
                            uf.union(getIndex(i, j, n), getIndex(i + 1, j, n));
                        }
                        if (j + 1 < n && grid[i][j + 1] < currLevel) {
                            uf.union(getIndex(i, j, n), getIndex(i, j + 1, n));
                        }
                    }
                }
            }
            return currLevel;
        }

        private int getIndex(int i, int j, int n) {
            return i * n + j;
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
