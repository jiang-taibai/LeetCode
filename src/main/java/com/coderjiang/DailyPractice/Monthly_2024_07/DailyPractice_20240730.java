package com.coderjiang.DailyPractice.Monthly_2024_07;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-07-30 00:43:24</p>
 */
public class DailyPractice_20240730 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        private final Map<Long, Integer> memo = new HashMap<>();

        public List<Integer> getGoodIndices(int[][] variables, int target) {
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < variables.length; ++i) {
                int[] variable = variables[i];
                int a = variable[0], b = variable[1], c = variable[2], m = variable[3];
                if (pow(pow(a, b, 10), c, m) == target) res.add(i);
            }
            return res;
        }

        private int pow(int a, int b, int mod) {
            if (b == 0) return 1;
            else if (b == 1) return a % mod;
            long key = (((a - 1) * 1000L + (b - 1)) * 1000) + (mod - 1);
            if (memo.containsKey(key)) return memo.get(key);
            int res = (pow(a, b / 2, mod) % mod * pow(a, b - b / 2, mod) % mod) % mod;
            memo.put(key, res);
            return res;
        }
    }

}
