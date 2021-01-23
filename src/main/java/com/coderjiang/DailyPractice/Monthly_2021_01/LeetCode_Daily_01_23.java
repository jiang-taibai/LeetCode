package com.coderjiang.DailyPractice.Monthly_2021_01;

/**
 * <p>创建时间：2021/1/23 19:52</p>
 * <p>主要功能：TODO</p>
 *
 * @author 刘江
 */
public class LeetCode_Daily_01_23 {
    public static void main(String[] args) {

    }

    class Solution {
        // 统计题：
        // 1. 多了x根网线？
        // 2. 有y个主机独立？
        // 3. 分情况讨论
        // 3.1 x>=y return y;
        // 3.2 x<y return -1;
        public int makeConnected(int n, int[][] connections) {
            UnionFind uf = new UnionFind(n);
            int restCables = 0; //多余的线缆
            int independentHosts = 0;   //独立的主机, 我们也可将大的计算机集群看做是一个主机
            for (int[] connection : connections) {
                int host1 = connection[0];
                int host2 = connection[1];
                if (uf.isFamily(host1, host2)) {
                    restCables++;
                } else {
                    uf.union(host1, host2);
                }
            }
            independentHosts = uf.countFamily() - 1;
            if (restCables >= independentHosts) return independentHosts;
            return -1;
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

            public int countFamily() {
                int count = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (i == find(i)) count++;
                }
                return count;
            }
        }
    }
}
