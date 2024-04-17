package com.coderjiang.DailyPractice.Monthly_2024_04;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>Creation Time: 2024/4/17</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_04_17 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        static class Component {
            private final int[] father;
            private final int[] size;
            private final int n;
            private int numOfComponents;

            public Component(int n) {
                this.n = n;
                this.father = new int[n];
                this.size = new int[n];
                this.numOfComponents = n;
                this.reset();
            }

            public void reset() {
                numOfComponents = this.n;
                for (int i = 0; i < this.n; i++) {
                    father[i] = i;
                    size[i] = 1;
                }
            }

            public int find(int son) {
                return father[son] == son ? son : (father[son] = find(father[son]));
            }

            public void merge(int son1, int son2) {
                int father1 = find(son1);
                int father2 = find(son2);
                if (father1 != father2) {
                    father[father2] = father1;
                    size[father1] += size[father2];
                    numOfComponents--;
                }
            }
        }

        public int minMalwareSpread(int[][] graph, int[] initial) {
            int n = graph.length;
            Component component = new Component(n);
            Arrays.sort(initial);
            int res = initial[0];
            int M = n;
            for (int infection : initial) {
                // 构建并查集
                for (int i = 0; i < n; i++) {
                    if (infection == i) continue;
                    for (int j = 0; j < i; j++) {
                        if (infection == j) continue;
                        if (graph[i][j] == 1) component.merge(i, j);
                    }
                }
                // 检查有多少个受感染的节点
                Set<Integer> fathers = new HashSet<>();
                for (int i : initial) {
                    fathers.add(component.find(i));
                }
                int localM = 0;
                for (Integer father : fathers) {
                    localM += component.size[father];
                }
                if(localM < M) {
                    M = localM;
                    res = infection;
                }
                // 恢复原始状态
                component.reset();
            }
            return res;
        }

    }

}
