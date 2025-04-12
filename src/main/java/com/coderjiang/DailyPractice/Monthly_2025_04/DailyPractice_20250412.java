package com.coderjiang.DailyPractice.Monthly_2025_04;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-04-12 20:50:57</p>
 */
public class DailyPractice_20250412 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        private Set<Long> set = new HashSet<>();
        private long[] factorial;

        public long countGoodIntegers(int n, int k) {
            factorial = new long[n + 1];
            factorial[0] = 1;
            for (int i = 1; i <= n; i++) {
                factorial[i] = factorial[i - 1] * i;
            }
            int[] nums = new int[n];
            dfs(nums, 0, n, k);
            long res = 0;
            for (long hash : set) {
                int[] cnt = dehashCode(hash, n);
                res += calCombination(cnt, n);
            }
            return res;
        }

        private void dfs(int[] nums, int index, int n, int k) {
            // 0 1 2 3
            // 0 1 2 3 4
            if (index == (n + 1) / 2) {
                if (valid(nums, k)) {
                    // System.out.println(Arrays.toString(nums));
                    set.add(hashCode(nums));
                }
            } else {
                for (int i = (index == 0 ? 1 : 0); i <= 9; ++i) {
                    nums[index] = nums[n - index - 1] = i;
                    dfs(nums, index + 1, n, k);
                }
            }
        }

        private boolean valid(int[] nums, int k) {
            long num = 0;
            for (int i = 0; i < nums.length; ++i) {
                num = num * 10 + nums[i];
            }
            return num % k == 0;
        }

        private long hashCode(int[] nums) {
            // System.out.println(Arrays.toString(nums));
            int[] cnt = new int[10];
            boolean distinctNum = false;
            for (int i = 0; i < nums.length; ++i) {
                cnt[nums[i]]++;
                if (!distinctNum && nums[i] != nums[0]) distinctNum = true;
            }
            if (!distinctNum) {
                // System.out.println("hashCode: " + -nums[0]);
                return -nums[0];
            } else {
                long hash = 1;
                for (int i = 0; i < 10; ++i) {
                    hash = hash * 10 + cnt[i];
                }
                // System.out.println("hashCode: " + hash);
                return hash;
            }
        }

        private int[] dehashCode(long hashCode, int n) {
            int[] cnt = new int[10];
            if (hashCode < 0) {
                cnt[(int) (-hashCode)] = n;
            } else {
                for (int i = 9; i >= 0; --i) {
                    cnt[i] = (int) (hashCode % 10L);
                    hashCode /= 10L;
                }
            }
            return cnt;
        }

        private long calCombination(int[] cnt, int n) {
            // System.out.println(Arrays.toString(cnt));
            long res = (n - cnt[0]) * factorial[n - 1];
            for (int i = 0; i <= 9; ++i) {
                res /= factorial[cnt[i]];
            }
            // System.out.println("res: " + res);
            return res;
        }
    }

}
