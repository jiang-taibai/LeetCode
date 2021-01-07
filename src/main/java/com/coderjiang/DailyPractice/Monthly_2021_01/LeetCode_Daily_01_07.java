package com.coderjiang.DailyPractice.Monthly_2021_01;

/**
 * @author 刘江
 * @modifyTime 2021/1/7 14:21
 * @description TODO
 */
public class LeetCode_Daily_01_07 {
    public static void main(String[] args) {

    }

    class Solution {
        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            UnionFind unionFind = new UnionFind(n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (isConnected[i][j] == 1) {
                        unionFind.union(i, j);
                    }
                }
            }
            return unionFind.getNumsOfSets();
        }

        class UnionFind {
            private final int[] arr;
            private Integer numsOfSets;

            public UnionFind(int size) {
                numsOfSets = size;
                arr = new int[size];
                for (int i = 0; i < size; ++i) {
                    arr[i] = i;
                }
            }

            // 查找并压缩路径
            public int find(int son) {
                int father = son;
                while (arr[father] != father) {
                    father = arr[father];
                }
                int next = son;
                while (arr[next] != father) {
                    next = arr[son];
                    arr[son] = father;
                }
                return father;
            }

            // 合并
            public void union(int son1, int son2) {
                int father1 = find(son1);
                int father2 = find(son2);
                if(father1 != father2) {
                    arr[find(son1)] = find(son2);
                    numsOfSets--;
                }
            }

            public int getNumsOfSets() {
                return numsOfSets;
            }
        }
    }
}
