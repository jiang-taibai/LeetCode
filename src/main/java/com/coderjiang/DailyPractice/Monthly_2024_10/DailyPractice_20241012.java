package com.coderjiang.DailyPractice.Monthly_2024_10;

import java.util.Arrays;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-10-12 19:15:44</p>
 */
public class DailyPractice_20241012 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        public int duplicateNumbersXOR(int[] nums) {
            int[] cnt = new int[50+1];
            for (int num : nums) {
                cnt[num]++;
            }
            int res = 0;
            for (int i = 0; i < cnt.length; i++) {
                if(cnt[i]==2) res ^= i;
            }
            return res;
        }

    }

}
