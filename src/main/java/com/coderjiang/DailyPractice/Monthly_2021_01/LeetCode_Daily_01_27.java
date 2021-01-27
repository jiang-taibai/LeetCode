package com.coderjiang.DailyPractice.Monthly_2021_01;

/**
 * <p>创建时间：2021/1/27 10:52</p>
 * <p>主要功能：TODO</p>
 *
 * @author 刘江
 */
public class LeetCode_Daily_01_27 {
    public static void main(String[] args) {

    }

    class Solution {
        public int maxNumEdgesToRemove(int n, int[][] edges) {
            UnionFind aliceUF = new UnionFind(n);
            UnionFind bobUF = new UnionFind(n);
            int restAliceEdges = 0;
            int restBobEdges = 0;
            int restCommonEdges = 0;
            // 遍历公共边，有限考虑
            for (int[] edge : edges) {
                int type = edge[0];
                int p1 = edge[1] - 1;
                int p2 = edge[2] - 1;
                if (type == 3) {
                    if (aliceUF.isFamily(p1, p2)) restCommonEdges++;
                    else {
                        aliceUF.union(p1, p2);
                        bobUF.union(p1, p2);
                    }
                }
            }

            for (int[] edge : edges) {
                int type = edge[0];
                int p1 = edge[1] - 1;
                int p2 = edge[2] - 1;
                if (type == 1) {
                    if (aliceUF.isFamily(p1, p2)) restAliceEdges++;
                    else aliceUF.union(p1, p2);
                } else if (type == 2) {
                    if (bobUF.isFamily(p1, p2)) restBobEdges++;
                    else bobUF.union(p1, p2);
                }
            }

            if (aliceUF.getCategory() != 1 || bobUF.getCategory() != 1) {
                return -1;
            }
            return restBobEdges + restAliceEdges + restCommonEdges;
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

            public int getCategory() {
                int category = 0;
                for (int i = 0; i < arr.length; ++i) {
                    if (find(i) == i) category++;
                }
                return category;
            }
        }
    }
}
