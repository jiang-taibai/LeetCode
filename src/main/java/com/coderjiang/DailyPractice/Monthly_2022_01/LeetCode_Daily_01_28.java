package com.coderjiang.DailyPractice.Monthly_2022_01;

import java.util.Arrays;

/**
 * <p>Creation Time: 2022-01-28 10:22:01</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_01_28 {

    class Solution {
        public int numberOfWeakCharacters(int[][] properties) {
            Arrays.sort(properties, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
            int res = 0;
            int maxDef = 0;
            for (int[] property : properties) {
                if (property[1] < maxDef) res++;
                else maxDef = property[1];
            }
            return res;

        }
    }

}
