package com.coderjiang.DailyPractice.Monthly_2025_05;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-05-14 22:04:57</p>
 */
public class DailyPractice_20250514 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        private static final int MOD = (int) 1e9 + 7;
        private static final int L = 26;

        private static class Mat {
            int[][] a = new int[L][L];

            Mat() {
            }

            Mat(Mat copyFrom) {
                for (int i = 0; i < L; i++) {
                    System.arraycopy(copyFrom.a[i], 0, this.a[i], 0, L);
                }
            }

            Mat mul(Mat other) {
                Mat result = new Mat();
                for (int i = 0; i < L; i++) {
                    for (int j = 0; j < L; j++) {
                        for (int k = 0; k < L; k++) {
                            result.a[i][j] = (int) ((result.a[i][j] + (long) this.a[i][k] * other.a[k][j]) % MOD);
                        }
                    }
                }
                return result;
            }
        }

        /* 单位矩阵 */
        private Mat I() {
            Mat m = new Mat();
            for (int i = 0; i < L; i++) {
                m.a[i][i] = 1;
            }
            return m;
        }

        /* 矩阵快速幂 */
        private Mat quickmul(Mat x, int y) {
            Mat ans = I();
            Mat cur = new Mat(x);
            while (y > 0) {
                if ((y & 1) == 1) {
                    ans = ans.mul(cur);
                }
                cur = cur.mul(cur);
                y >>= 1;
            }
            return ans;
        }

        public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
            Mat T = new Mat();
            for (int i = 0; i < L; i++) {
                for (int j = 1; j <= nums.get(i); j++) {
                    T.a[(i + j) % L][i] = 1;
                }
            }

            Mat res = quickmul(T, t);
            int[] f = new int[L];
            for (char ch : s.toCharArray()) {
                f[ch - 'a']++;
            }
            int ans = 0;
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < L; j++) {
                    ans = (int) ((ans + (long) res.a[i][j] * f[j]) % MOD);
                }
            }
            return ans;
        }
    }

}
