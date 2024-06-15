package com.coderjiang.DailyPractice.Monthly_2024_06;

import java.util.Arrays;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-06-15 19:06:19</p>
 */
public class DailyPractice_20240615 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution排序二分 {
        public int maximumBeauty(int[] nums, int k) {
            Arrays.sort(nums);
            // 例如 1,2,4,6
            // 如果选 1 为起点，那么最大可以选择 1+k+k 的数字
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                res = Math.max(res, maxLowerThan(nums, nums[i] + k + k) - i + 1);
            }
            return res;
        }

        private int maxLowerThan(int[] nums, int target) {
            int n = nums.length;
            int l = 0, r = n;
            while (l + 1 < r) {
                int mid = (l + r) / 2;
                if (nums[mid] < target) {
                    l = mid;
                } else if (nums[mid] > target) {
                    r = mid;
                } else {
                    l = mid;
                }
            }
            return l;
        }
    }

    static class Solution {
        public int maximumBeauty(int[] nums, int k) {
            // 差分数组法
            int maxNum = Arrays.stream(nums).max().getAsInt();
            int[] diff = new int[maxNum + k + 2];
            for (int num : nums) {
                diff[Math.max(num - k, 0)]++;
                diff[num + k + 1]--;
            }
            int res = 0, count = 0;
            for (int i : diff) {
                count += i;
                res = Math.max(res, count);
            }
            return res;
        }
    }

}
