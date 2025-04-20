package com.coderjiang.DailyPractice.Monthly_2025_04;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-04-20 21:47:23</p>
 */
public class DailyPractice_20250420 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int numRabbits(int[] answers) {
            // 如果有兔子回答 n - 1，那么就可以取 n 个 n - 1 为一类
            // 即出现 m 次 n - 1，归为 m/(n-1)(向上取整) 类
            Map<Integer, Integer> map = new HashMap<>();
            for (int answer : answers) {
                map.put(answer, map.getOrDefault(answer, 0) + 1);
            }
            int res = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int teams = 0;
                teams += entry.getValue() / (entry.getKey() + 1);
                if (entry.getValue() % (entry.getKey() + 1) != 0) ++teams;
                res += teams * (entry.getKey() + 1);
            }
            return res;
        }
    }

}
