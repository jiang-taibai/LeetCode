package com.coderjiang.DailyPractice.Monthly_2025_07;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-07-29 21:44:17</p>
 */
public class DailyPractice_20250729 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int[] smallestSubarrays(int[] nums) {
            int n = nums.length;
            int[] maxNum = new int[n + 1];
            for (int i = n - 1; i >= 0; --i) {
                maxNum[i] = maxNum[i + 1] | nums[i];
            }
            int[] res = new int[n];
            int[] count = new int[32];
            int l = 0, r = 0;
            while (l < n) {
                // 添加右边界
                add(count, nums[r]);
                ++r;
                while (l < r && equals(count, maxNum[l])) {
                    res[l] = r - l;
                    remove(count, nums[l]);
                    ++l;
                }
            }
            return res;
        }

        private void add(int[] count, int num) {
            int index = 0;
            while (num != 0) {
                count[index++] += num & 1;
                num >>= 1;
            }
        }

        private void remove(int[] count, int num) {
            int index = 0;
            while (num != 0) {
                count[index++] -= num & 1;
                num >>= 1;
            }
        }

        private boolean equals(int[] count, int targetNum) {
            int num = 0;
            for (int i = count.length - 1; i >= 0; --i) {
                num <<= 1;
                num += count[i] > 0 ? 1 : 0;
            }
            return num == targetNum;
        }
    }

}
