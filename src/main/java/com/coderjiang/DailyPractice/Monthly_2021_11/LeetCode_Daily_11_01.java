package com.coderjiang.DailyPractice.Monthly_2021_11;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>Creation Time: 2021-11-01 22:59:47</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_11_01 {

    class Solution {
        public int distributeCandies(int[] candyType) {
            Set<Integer> set = new HashSet<>();
            for (int type : candyType) {
                set.add(type);
            }
            return Math.min(candyType.length / 2, set.size());
        }
    }

}
