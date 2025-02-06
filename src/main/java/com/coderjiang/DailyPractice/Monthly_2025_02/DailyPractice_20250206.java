package com.coderjiang.DailyPractice.Monthly_2025_02;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-02-06 08:16:02</p>
 */
public class DailyPractice_20250206 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> permuteUnique(int[] nums) {
            Arrays.sort(nums);
            solve(nums, new boolean[nums.length], 0);
            return res;
        }

        private void solve(int[] nums, boolean[] set, int put) {
            int n = nums.length;
            if (put == n) {
//                add(res, path);
                res.add(new ArrayList<>(path));
                return;
            }
            for (int i = 0; i < n; i++) {
                if (set[i] || (i > 0 && nums[i] == nums[i - 1] && !set[i - 1])) {
                    continue;
                }
                set[i] = true;
                path.add(nums[i]);
                solve(nums, set, put + 1);
                set[i] = false;
                path.remove(path.size() - 1);
            }
        }

        private void add(List<List<Integer>> results, List<Integer> target) {
            for (List<Integer> result : results) {
                boolean exist = true;
                for (int i = 0; i < result.size(); i++) {
                    if (!Objects.equals(result.get(i), target.get(i))) {
                        exist = false;
                        break;
                    }
                }
                if (exist) return;
            }
            results.add(new ArrayList<>(target));
        }
    }

}
