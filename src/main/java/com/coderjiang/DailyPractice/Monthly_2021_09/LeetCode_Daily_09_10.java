package com.coderjiang.DailyPractice.Monthly_2021_09;

import java.util.Arrays;

/**
 * <p>Creation Time: 2021-09-10 20:50:31</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_09_10 {

    class Solution {
        public int chalkReplacer(int[] chalk, int k) {
            long sum = Arrays.stream(chalk).sum();
            for (int i = 0; i < chalk.length; ++i) {
                sum += chalk[i];
                if (sum < 0) break;
            }
            if (sum > 0)
                k -= (k / sum) * sum;
            for (int i = 0; i < chalk.length; ++i) {
                if (chalk[i] > k) return i;
                k -= chalk[i];
            }
            return 0;
        }
    }

}
