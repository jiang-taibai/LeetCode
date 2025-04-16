package com.coderjiang.DailyPractice.Monthly_2025_04;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-04-16 22:03:22</p>
 */
public class DailyPractice_20250416 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public long countGood(int[] nums, int k) {
            int l = 0, r = -1;
            int n = nums.length;
            Map<Integer, Integer> map = new HashMap<>();
            long res = 0;
            while (r < n - 1) {
                ++r;
                // 添加 right 后，能够凑齐多少种组合
                int countOfRight = map.getOrDefault(nums[r], 0);
                if (countOfRight > 0) {
                    k -= countOfRight;
                }
                map.put(nums[r], countOfRight + 1);
                // 如果还不够，就继续右扩
                // System.out.printf("%d,%d,%d,%d\n", l, r, res, k);
                if (k > 0) continue;
                // 如果够了，就加上从 [l, r] 开始的所有连续子数组数
                // 即 [l, r], [l, r + 1], ..., [l, n - 1]
                res += n - r;
                // 然后缩小左边界，直到 k > 0
                while (k <= 0 && l < r) {
                    int countOfLeft = map.getOrDefault(nums[l], 0);
                    if (countOfLeft > 0) {
                        k += countOfLeft - 1;
                    }
                    map.put(nums[l], countOfLeft - 1);
                    if (k <= 0) res += n - r;
                    // System.out.printf("%d,%d,%d,%d\n", l, r, res, k);
                    ++l;
                }
            }
            return res;
        }
    }

}
