package com.coderjiang.DailyPractice.Monthly_2024_04;

/**
 * <p>Creation Time: 2024/4/18</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_04_18 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] changed = new int[]{1, 3, 4, 2, 6, 8};
        solution.findOriginalArray(changed);
    }

    static class Solution {

        public static final int MAX_N = (int) 1e5;

        public int[] findOriginalArray(int[] changed) {
            int n = changed.length;
            int[] countOriginal = new int[MAX_N + 1];
            int[] res = new int[n / 2];
            int idx = 0;
            if ((n & 1) == 1) return new int[0];
            for (int i : changed) {
                countOriginal[i]++;
            }
            if ((countOriginal[0] & 1) == 1) return new int[0];
            for (int i = 1; i <= MAX_N; i++) {
                if (countOriginal[i] > 0) {
                    if (i * 2 > MAX_N || countOriginal[i * 2] < countOriginal[i]) return new int[0];
                    countOriginal[i * 2] -= countOriginal[i];
                    for (int j = 0; j < countOriginal[i]; j++) {
                        res[idx++] = i;
                    }
                }
            }
            return res;
        }
    }

}
