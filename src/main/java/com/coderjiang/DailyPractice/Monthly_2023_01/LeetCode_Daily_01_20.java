package com.coderjiang.DailyPractice.Monthly_2023_01;

import java.util.HashMap;
import java.util.HashSet;

/**
 * <p>Creation Time: 2023-01-20 10:32:57</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_01_20 {

    class Solution {
        public int[] findingUsersActiveMinutes(int[][] logs, int k) {
            int[] ans = new int[k];
            HashMap<Integer, HashSet<Integer>> sets = new HashMap<>();
            for (int[] log : logs) {
                HashSet<Integer> set = sets.getOrDefault(log[0], new HashSet<>());
                boolean success = set.add(log[1]);
                int newSize = set.size();
                if (success) {
                    if (newSize != 1) ans[newSize - 2]--;
                    ans[newSize - 1]++;
                    sets.put(log[0], set);
                }
            }
            return ans;
        }
    }

}
