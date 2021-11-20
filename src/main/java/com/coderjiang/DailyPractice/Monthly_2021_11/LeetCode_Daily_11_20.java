package com.coderjiang.DailyPractice.Monthly_2021_11;

import java.util.Arrays;

/**
 * <p>Creation Time: 2021-12-03 13:03:52</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_11_20 {

    class Solution {
        public int findLHS(int[] nums) {
            Arrays.sort(nums);
            int preLength = 0;
            int preNumber = (int) 1e9 + 10;
            int curLength = 0;
            int maxLength = 0;
            for (int i = 1; i < nums.length; ++i) {
                if (nums[i] == nums[i - 1]) curLength++;
                else {
                    if (preLength != 0 && nums[i] - preNumber == 1) {
                        maxLength = Math.max(maxLength, preLength + curLength);
                    }
                    preNumber = nums[i];
                    preLength = curLength;
                    curLength = 1;
                }
            }
            if (preLength != 0 && nums[nums.length - 1] - preNumber == 1) {
                maxLength = Math.max(maxLength, preLength + curLength);
            }
            return maxLength;
        }
    }

}
