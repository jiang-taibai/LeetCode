package com.coderjiang.DailyPractice.Monthly_2025_04;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-04-25 16:27:12</p>
 */
public class DailyPractice_20250425 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
            int n = nums.size();
            List<Integer> indexes = new ArrayList<>();
            for (int i = 0; i < nums.size(); ++i) if (nums.get(i) % modulo == k) indexes.add(i);

            // dp[i] 表示以 nums[indexes[i]] 开头的子数组有多少个是趣味子数组
            long[] dp = new long[indexes.size()];
            for (int i = indexes.size() - 1; i >= 0; --i) {
                int index = indexes.get(i);
                int j = i + (k - 1 + modulo) % modulo;
                if (j >= indexes.size()) {
                    dp[i] = 0;
                    continue;
                }
                int nextIndex = indexes.get(j);
                // 现在 index 和 nextIndex 之间（包括两端）有 k 个趣味值
                // 现在看 nextIndex 到下一个趣味值前有多少种组合
                long condition = 1;
                if (j == indexes.size() - 1) {
                    condition = n - nextIndex;
                } else {
                    condition = indexes.get(j + 1) - indexes.get(j);
                }
                dp[i] = condition;
                if (i + modulo < indexes.size()) dp[i] += dp[i + modulo];
            }
            // System.out.println(Arrays.toString(dp));

            int l = 0;
            long res = 0;
            for (int i = 0; i < indexes.size(); ++i) {
                long leftCondition = indexes.get(i) - l + 1;
                res += leftCondition * dp[i];
                l = indexes.get(i) + 1;
            }

            // 如果 k = 0，还要考虑由 nums[i]%modulo != k 组成的子数组个数
            // System.out.println(res);
            if (k == 0) {
                long gap = 0;
                int preIndex = -1;
                for (int i = 0; i < indexes.size(); ++i) {
                    gap = indexes.get(i) - preIndex - 1;
                    res += (gap + 1) * gap / 2;
                    preIndex = indexes.get(i);
                }
                gap = n - preIndex - 1;
                res += (gap + 1) * gap / 2;
            }
            // System.out.println(res);
            return res;
        }
    }

}
