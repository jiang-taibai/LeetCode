package com.coderjiang.DailyPractice.Monthly_2024_05;

import java.util.Arrays;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-05-17 08:33:21</p>
 */
public class DailyPractice_20240517 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
            int n = difficulty.length;
            int[][] works = new int[n][2];
            for (int i = 0; i < n; i++) {
                works[i][0] = difficulty[i];
                works[i][1] = profit[i];
            }
            Arrays.sort(works, (a, b) -> {
                if (a[0] == b[0]) return b[1] - a[1];
                return a[0] - b[0];
            });
            Arrays.sort(worker);
            int workIndex = 0;
            int maxProfit = 0;
            int res = 0;
            for (int perWorker : worker) {
                if (perWorker < works[0][0]) continue;
                while (workIndex < n && works[workIndex][0] <= perWorker) {
                    maxProfit = Integer.max(maxProfit, works[workIndex][1]);
                    workIndex++;
                }
                res += maxProfit;
            }
            return res;
        }
    }

}
