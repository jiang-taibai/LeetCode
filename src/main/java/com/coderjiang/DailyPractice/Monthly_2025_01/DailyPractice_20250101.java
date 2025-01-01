package com.coderjiang.DailyPractice.Monthly_2025_01;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-01-01 09:27:56</p>
 */
public class DailyPractice_20250101 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public String convertDateToBinary(String date) {
            String[] nums = date.split("-");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nums.length; i++) {
                sb.append(Integer.toBinaryString(Integer.parseInt(nums[i])));
                if (i != nums.length - 1) sb.append('-');
            }
            return sb.toString();
        }
    }

}
