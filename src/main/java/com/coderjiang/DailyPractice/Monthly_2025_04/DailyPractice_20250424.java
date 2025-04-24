package com.coderjiang.DailyPractice.Monthly_2025_04;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-04-24 10:32:48</p>
 */
public class DailyPractice_20250424 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        public static final int MAX_NUM = 2000 + 10;

        public int countCompleteSubarrays(int[] nums) {
            int n = nums.length;
            int l = 0, r = 0;
            int[] cnt = new int[MAX_NUM];
            int uniqueSize = 0;
            final int targetUniqueSize = (int) Arrays.stream(nums).distinct().count();
            int res = 0;
            while (r <= n && l < n) {
                while (r < n && uniqueSize < targetUniqueSize) {
                    int rightNum = nums[r];
                    if (cnt[rightNum] == 0) ++uniqueSize;
                    ++cnt[rightNum];
                    ++r;
                }
                if (uniqueSize == targetUniqueSize) res += n - r + 1;
                int leftNum = nums[l];
                if (cnt[leftNum] == 1) --uniqueSize;
                --cnt[leftNum];
                ++l;
            }
            return res;
        }
    }

}
