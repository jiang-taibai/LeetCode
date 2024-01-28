package com.coderjiang.DailyPractice.Monthly_2024_01;

import java.util.HashMap;
import java.util.HashSet;

/**
 * <p>Creation Time: 2024-01-28</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_01_28 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean result = solution.canMeasureWater(3, 5, 4);
        System.out.println(result);
    }

    static class Solution {

        private final HashMap<Integer, HashSet<Integer>> memo = new HashMap<>();
        private int jug1Capacity;
        private int jug2Capacity;
        private int targetCapacity;

        public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
            this.jug1Capacity = jug1Capacity;
            this.jug2Capacity = jug2Capacity;
            this.targetCapacity = targetCapacity;
            return dfs(jug1Capacity, jug2Capacity);
        }

        private boolean exist(int jug1, int jug2) {
            return memo.containsKey(jug1) && memo.get(jug1).contains(jug2);
        }

        private void mark(int jug1, int jug2) {
            HashSet<Integer> set = memo.getOrDefault(jug1, new HashSet<>());
            set.add(jug2);
            memo.put(jug1, set);
        }

        private boolean dfs(int jug1, int jug2) {
            // 状态：jug1、jug2
            if (exist(jug1, jug2)) return false;
            mark(jug1, jug2);
            if (jug1 + jug2 == targetCapacity) {
                return true;
            }

            // clean jug1
            boolean condition1 = dfs(0, jug2);
            // clean jug2
            boolean condition2 = dfs(jug1, 0);

            // fill jug1
            boolean condition3 = dfs(jug1Capacity, jug2);
            // fill jug2
            boolean condition4 = dfs(jug1, jug2Capacity);

            // jug2 to jug1
            boolean condition5;
            if (jug1 + jug2 > jug1Capacity) {
                condition5 = dfs(jug1Capacity, jug1 + jug2 - jug1Capacity);
            } else {
                condition5 = dfs(jug1 + jug2, 0);
            }
            // jug1 to jug2
            boolean condition6;
            if (jug1 + jug2 > jug2Capacity) {
                condition6 = dfs(jug1 + jug2 - jug2Capacity, jug2Capacity);
            } else {
                condition6 = dfs(0, jug1 + jug2);
            }

            return condition1 || condition2 || condition3 || condition4 || condition5 || condition6;
        }

    }

}
