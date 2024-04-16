package com.coderjiang.DailyPractice.Monthly_2024_04;

import java.util.Arrays;

/**
 * <p>Creation Time: 2024/4/16</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_04_16 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int minMalwareSpread(int[][] graph, int[] initial) {
            int n = graph.length;
            int[] father = new int[n], size = new int[n];
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
            Arrays.fill(size, 1);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if(graph[i][j]==1) merge(father, size, i, j);
                }
            }
            Arrays.sort(initial);
            int[] count = new int[n];
            for (int node : initial) {
                count[find(father, node)]++;
            }
            int maxNode = initial[0], maxSize = 0;
            for (int node : initial) {
                int fatherOfNode = find(father, node);
                if(count[fatherOfNode]==1) {
                    if(size[fatherOfNode]>maxSize) {
                        maxSize = size[fatherOfNode];
                        maxNode = node;
                    }
                }
            }
            System.out.println(Arrays.toString(father));
            System.out.println(Arrays.toString(size));
            System.out.println(Arrays.toString(count));
            return maxNode;
        }

        private int find(int[] father, int son) {
            return son == father[son] ? son : (father[son] = find(father, father[son]));
        }

        private void merge(int[] father, int[] size, int son1, int son2) {
            int father1 = find(father, son1);
            int father2 = find(father, son2);
            if (father1 != father2) {
                father[father2] = father1;
                size[father1] += size[father2];
            }
        }
    }

}
