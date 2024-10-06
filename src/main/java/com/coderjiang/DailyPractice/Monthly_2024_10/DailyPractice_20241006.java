package com.coderjiang.DailyPractice.Monthly_2024_10;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-10-06 08:55:20</p>
 */
public class DailyPractice_20241006 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        public int canCompleteCircuit(int[] gas, int[] cost) {
            int n = gas.length;
            for (int i = 0; i < n; i++) {
                gas[i] -= cost[i];
            }
            int sum = 0;
            int res = -1;
            for (int i = 0; i < 2 * n; i++) {
                int p = i % n;
                sum += gas[p];
                if (sum < 0) {
                    sum = 0;
                    res = (p + 1) % n;
                }
            }
            if (res == -1) res = 0;
            sum = 0;
            for (int i = res; i < res + n; ++i) {
                sum += gas[i % n];
                if (sum < 0) return -1;
            }
            return res;
        }

    }

}
/*
gas = [1,2,3,4,5], cost = [3,4,5,1,2]
gas = [-2, -2, 2, 3, 3]
 */
