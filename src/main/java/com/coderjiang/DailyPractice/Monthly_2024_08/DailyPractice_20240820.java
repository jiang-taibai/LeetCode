package com.coderjiang.DailyPractice.Monthly_2024_08;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-08-20 00:56:47</p>
 */
public class DailyPractice_20240820 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        final Map<String, Integer> memo = new HashMap<>();

        public int waysToReachStair(int k) {
            return dfs(1, 0, false, k);
        }

        private int dfs(int i, int jump, boolean isDowned, int k) {
            if (i - 1 > k) return 0;
            String key = String.format("%d,%d,%d", i, jump, isDowned ? 1 : 0);
            if (memo.containsKey(key)) return memo.get(key);
            int res = i == k ? 1 : 0;
            if (!isDowned && i != 0) res += dfs(i - 1, jump, true, k);
            if (i + (1 << jump) - 1 <= k) res += dfs(i + (1 << jump), jump + 1, false, k);
            memo.put(key, res);
            return res;
        }
    }

}
