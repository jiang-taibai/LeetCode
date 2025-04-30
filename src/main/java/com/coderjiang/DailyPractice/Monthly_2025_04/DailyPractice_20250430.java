package com.coderjiang.DailyPractice.Monthly_2025_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-04-29 20:41:27</p>
 */
public class DailyPractice_20250430 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int findNumbers(int[] nums) {
            int res = 0;
            for (int num : nums) {
                int count = 0;
                while (num != 0) {
                    ++count;
                    num /= 10;
                }
                if ((count & 1) == 0) ++res;
            }
            return res;
        }
    }

}
