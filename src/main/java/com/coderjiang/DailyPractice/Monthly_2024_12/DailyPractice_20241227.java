package com.coderjiang.DailyPractice.Monthly_2024_12;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-12-27 09:59:58</p>
 */
public class DailyPractice_20241227 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
            List<Integer> indexes = new ArrayList<>();
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] != x) continue;
                indexes.add(i);
            }
            for (int i = 0; i < queries.length; ++i) {
                if (indexes.size() < queries[i]) {
                    queries[i] = -1;
                } else {
                    queries[i] = indexes.get(queries[i] - 1);
                }
            }
            return queries;
        }
    }

}
