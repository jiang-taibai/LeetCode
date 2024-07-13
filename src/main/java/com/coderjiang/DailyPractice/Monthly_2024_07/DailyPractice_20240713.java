package com.coderjiang.DailyPractice.Monthly_2024_07;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-07-13 12:27:04</p>
 */
public class DailyPractice_20240713 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public boolean canSortArray(int[] nums) {
            int curBitCount = 0;
            int lastGroupMax = 0;
            int curGroupMax = 0;
            // 关键：只需要维护每组的最大值，确保当前组的每个数字大于或等于前一组的最大值即可
            for (int num : nums) {
                int bitCount = Integer.bitCount(num);
                if (bitCount == curBitCount) {
                    curGroupMax = Math.max(curGroupMax, num);
                } else {
                    curBitCount = bitCount;
                    lastGroupMax = curGroupMax;
                    curGroupMax = num;
                }
                if (num < lastGroupMax) return false;
            }
            return true;
        }
    }

}
