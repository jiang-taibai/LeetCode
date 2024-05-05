package com.coderjiang.DailyPractice.Monthly_2024_05;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-05-05 11:36:08</p>
 */
public class DailyPractice_20240505 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int[] decrypt(int[] code, int k) {
            int n = code.length;
            int[] res = new int[n];
            if (k == 0) return res;
            int lhs, rhs;
            int sum = 0;
            if (k < 0) {
                lhs = n - (-k);
                rhs = n - 1;
                for (int i = 1; i <= -k; i++) {
                    sum += code[n - i];
                }
            } else {
                lhs = 1;
                rhs = k % n;
                for (int i = 1; i <= k; i++) {
                    sum += code[i];
                }
            }
            for (int i = 0; i < n; i++) {
                res[i] = sum;
                sum = sum - code[lhs] + code[(rhs + 1) % n];
                lhs = (lhs + 1) % n;
                rhs = (rhs + 1) % n;
            }
            return res;
        }
    }

}
