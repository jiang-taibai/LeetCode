package com.coderjiang.DailyPractice.Monthly_2025_01;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-01-26 19:17:02</p>
 */
public class DailyPractice_20250126 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        private final LinkedList<Integer> path = new LinkedList<>();

        private final List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            int[] numbers = new int[51];
            for (int candidate : candidates) {
                numbers[candidate]++;
            }
            dfs(numbers, target, 0, 0);
            return result;
        }

        private void dfs(int[] numbers, int target, int number, int sum) {
            if (sum > target) return;
            if (sum == target) {
                result.add(new ArrayList<>(path));
                return;
            }
            if (number >= numbers.length) return;
            dfs(numbers, target, number + 1, sum);
            int len = path.size();
            for (int i = 1; i <= numbers[number]; i++) {
                path.offerLast(number);
                sum += number;
                if (sum > target) break;
                dfs(numbers, target, number + 1, sum);
            }
            while (path.size() > len) {
                path.pollLast();
            }
        }
    }

}
