package com.coderjiang.DailyPractice.Monthly_2024_04;

import java.util.Arrays;

/**
 * <p>Creation Time: 2024/4/13</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_04_13 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int findChampion(int n, int[][] edges) {
            boolean[] root = new boolean[n];
            Arrays.fill(root, true);
            for (int[] edge : edges) {
                root[edge[1]] = false;
            }
            int res = -1;
            for (int i = 0; i < n; i++) {
                if (root[i]) {
                    if (res != -1) return -1;
                    else res = i;
                }
            }
            return res;
        }
    }

}
