package com.coderjiang.DailyPractice.Monthly_2024_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>Creation Time: 2024/4/20</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_04_20 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        private int[] candidates;
        private int target;
        private final List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Arrays.sort(candidates);
            this.candidates = candidates;
            this.target = target;
            solve(0, 0, new LinkedList<>());
            return res;
        }

        private void solve(int idx, int sum, LinkedList<Integer> path) {
//            System.out.println(path);
            if (sum > target) return;
            if (sum == target) {
                res.add(new LinkedList<>(path));
                return;
            }
            for (int i = idx; i < candidates.length; i++) {
                path.add(candidates[i]);
                solve(i, sum + candidates[i], path);
                path.removeLast();
            }
        }
    }

}
