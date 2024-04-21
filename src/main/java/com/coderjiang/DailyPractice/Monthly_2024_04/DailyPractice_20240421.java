package com.coderjiang.DailyPractice.Monthly_2024_04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-04-21 10:18:30</p>
 */
public class DailyPractice_20240421 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int k = 3;
        int n = 7;
        System.out.println(solution.combinationSum3(k, n));
    }

    static class Solution {

        private final List<List<Integer>> res = new ArrayList<>();
        private int k;
        private int n;

        public List<List<Integer>> combinationSum3(int k, int n) {
            this.k = k;
            this.n = n;
            dfs(0, new LinkedList<>(), 0);
            return res;
        }

        private void dfs(int num, LinkedList<Integer> path, int sum) {
//            System.out.println(path);
            if (num >= 10) return;
            if (path.size() > k) return;
            if (sum > n) return;
            if (path.size() == k && sum == n) {
                res.add(new ArrayList<>(path));
            }
            num++;
            while (num < 10) {
                path.add(num);
                dfs(num, path, sum + num);
                path.removeLast();
                num++;
            }
        }
    }

}
