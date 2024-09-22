package com.coderjiang.DailyPractice.Monthly_2024_09;

import java.util.Arrays;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-09-22 11:26:45</p>
 */
public class DailyPractice_20240922 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int findJudge(int n, int[][] trust) {
            boolean[] isJudge = new boolean[n + 1];
            Arrays.fill(isJudge, true);
            int[] cnt = new int[n + 1];
            for (int[] t : trust) {
                isJudge[t[0]] = false;
                cnt[t[1]]++;
            }
            for (int i = 1; i <= n; i++) {
                if (isJudge[i] && cnt[i] == n - 1) return i;
            }
            return -1;
        }
    }

}
