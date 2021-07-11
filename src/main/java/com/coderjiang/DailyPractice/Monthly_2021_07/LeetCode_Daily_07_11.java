package com.coderjiang.DailyPractice.Monthly_2021_07;

import java.util.*;

/**
 * <p>Creation Time: 2021-07-10 11:01:30</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_07_11 {

    class Solution {
        public int hIndex(int[] citations) {
            int n = citations.length;
            Arrays.sort(citations);
            int max = citations[0];
            for (int i = n - 1; i >= 0; i--) {
                // 多少篇 > 引用的次数
                if (n - i <= citations[i]) {
                    max = n - i;
                }
            }
            return max;
        }
    }

}
