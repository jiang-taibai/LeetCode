package com.coderjiang.DailyPractice.Monthly_2021_01;

/**
 * <p>创建时间：2021/1/13 16:19</p>
 * <p>主要功能：在本问题中, 树指的是一个连通且无环的无向图。
 * 输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
 * 结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。
 * 返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。</p>
 *
 * @author 刘江
 */
public class LeetCode_Daily_01_13 {
    public static void main(String[] args) {

    }

    class Solution {
        public int[] findRedundantConnection(int[][] edges) {
            int n = edges.length;
            UnionFind unionFind = new UnionFind(n);
            for (int i = 0; i < n; i++) {
                int a = edges[i][0]-1;
                int b = edges[i][1]-1;
                if (unionFind.isFamily(a, b)) {
                    return edges[i];
                }
                unionFind.union(a, b);
            }
            return edges[n-1];
        }

        class UnionFind {
            int[] arr;

            public UnionFind(int length) {
                arr = new int[length];
                for (int i = 0; i < length; i++) {
                    arr[i] = i;
                }
            }

            public int find(int son) {
                int father = son;
                while (arr[father] != father) {
                    father = arr[father];
                }

                int next = son;
                while (arr[next] != father) {
                    next = arr[next];
                    arr[son] = father;
                    son = next;
                }
                return father;
            }

            public int union(int son1, int son2) {
                int father1 = find(son1);
                int father2 = find(son2);
                arr[father1] = father2;
                return father2;
            }

            public boolean isFamily(int son1, int son2) {
                return find(son1) == find(son2);
            }
        }
    }
}
