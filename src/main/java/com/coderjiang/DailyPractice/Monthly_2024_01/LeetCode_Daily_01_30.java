package com.coderjiang.DailyPractice.Monthly_2024_01;

import java.util.*;

/**
 * <p>Creation Time: 2024-01-30</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_01_30 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int minimumSeconds(List<Integer> nums) {
            Map<Integer, List<Integer>> numIndexes = new HashMap<>();
            for (int i = 0; i < nums.size(); i++) {
                int num = nums.get(i);

//                List<Integer> curNumIndexes = numIndexes.getOrDefault(num, new LinkedList<>());
//                curNumIndexes.add(i);
//                numIndexes.put(num, curNumIndexes);

                numIndexes.computeIfAbsent(num, k -> new ArrayList<>()).add(i);
            }
            int result = Integer.MAX_VALUE;
            for (Integer num : numIndexes.keySet()) {
                result = Math.min(calMinimumSeconds(numIndexes.get(num), nums.size()), result);
            }
            return result / 2;
        }

        private int calMinimumSeconds(List<Integer> numIndexes, int totalLength) {
            int maxDis = 0;
            for (int i = 0; i < numIndexes.size() - 1; i++) {
                int dis = Math.abs(numIndexes.get(i) - numIndexes.get(i + 1));
                maxDis = Math.max(maxDis, dis);
            }
            maxDis = Math.max(maxDis, (numIndexes.get(0) + totalLength) - numIndexes.get(numIndexes.size() - 1));
            return maxDis;
        }
    }

}
