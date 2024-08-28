package com.coderjiang.DailyPractice.Monthly_2024_08;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-08-28 10:36:36</p>
 */
public class DailyPractice_20240828 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        int[] memo;

        public int minimumSubstringsInPartition(String s) {
            memo = new int[s.length() + 1];
            Arrays.fill(memo, -2);
            final List<List<Integer>> nextIndexes = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                nextIndexes.add(new ArrayList<>());
                int[] cnt = new int[26];
                for (int j = i; j < s.length(); j++) {
                    cnt[s.charAt(j) - 'a']++;
                    if (validStringCount(cnt)) nextIndexes.get(i).add(j);
                }
            }
//            for (List<Integer> nextIndex : nextIndexes) {
//                System.out.println(nextIndex.toString());
//            }
            return dfs(nextIndexes, 0, s.length());
        }

        private boolean validStringCount(int[] cnt) {
            int target = 0;
            for (int num : cnt) {
                if (num != 0) {
                    if (target == 0) target = num;
                    else if (num != target) return false;
                }
            }
            return true;
        }

        private int dfs(List<List<Integer>> nextIndexes, int index, int maxIndex) {
            int res = Integer.MAX_VALUE;
            if (index == maxIndex) return 0;
            if (memo[index] != -2) return memo[index];
            for (int i = 0; i < nextIndexes.get(index).size(); i++) {
                int subRes = dfs(nextIndexes, nextIndexes.get(index).get(i) + 1, maxIndex);
                if (subRes != -1) res = Math.min(res, subRes + 1);
            }
            return memo[index] = (res == Integer.MAX_VALUE ? -1 : res);
        }
    }

}
