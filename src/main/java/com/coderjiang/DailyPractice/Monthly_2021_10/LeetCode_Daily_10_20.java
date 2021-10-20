package com.coderjiang.DailyPractice.Monthly_2021_10;

import java.util.Arrays;

/**
 * <p>Creation Time: 2021-10-20 10:18:23</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_10_20 {

    class Solution {
        public int minMoves(int[] nums) {
            int min = Arrays.stream(nums).min().getAsInt(), cnt = 0;
            for (int num : nums) cnt += num - min;
            return cnt;
        }
    }

}
