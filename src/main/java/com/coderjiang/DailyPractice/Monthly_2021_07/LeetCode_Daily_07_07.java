package com.coderjiang.DailyPractice.Monthly_2021_07;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Creation Time: 2021-07-07 22:13:04</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_07_07 {

    class Solution {

        private final static int MOD = 1000000000 + 7;

        public int countPairs(int[] deliciousness) {
            Map<Long, Integer> map = new HashMap<>();
            long[] powers = new long[41];
            powers[0] = 1;
            for (int i = 1; i <= 40; i++) {
                powers[i] = powers[i - 1] * 2;
            }
            for (long item : deliciousness) {
                map.put(item, map.getOrDefault(item, 0) + 1);
            }
            int res = 0;
            for (Map.Entry<Long, Integer> entry : map.entrySet()) {
                long lhs = entry.getKey();
                int lhsq = entry.getValue();
                for (long power : powers) {
                    long rhs = power - lhs;
                    if (rhs >= 0 && rhs >= lhs) {
                        int rhsq = map.getOrDefault(rhs, 0);
                        if (rhsq == 0) continue;
                        if (lhs == rhs) {
                            rhsq -= 1;
                            res += lhsq * rhsq / 2;
                        } else {
                            res += lhsq * rhsq;
                        }
                        res %= MOD;
                    }
                }
            }
            return res;
        }
    }

}
