package com.coderjiang.DailyPractice.Monthly_2024_11;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-11-24 13:42:15</p>
 */
public class DailyPractice_20241124 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int[] smallestRange(List<List<Integer>> nums) {
            int rangeLeft = 0, rangeRight = Integer.MAX_VALUE;
            int minRange = rangeRight - rangeLeft;
            int max = Integer.MIN_VALUE;
            int size = nums.size();
            int[] next = new int[size];
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(new Comparator<Integer>() {
                public int compare(Integer index1, Integer index2) {
                    return nums.get(index1).get(next[index1]) - nums.get(index2).get(next[index2]);
                }
            });
            for (int i = 0; i < size; i++) {
                priorityQueue.offer(i);
                max = Math.max(max, nums.get(i).get(0));
            }
            while (true) {
                int minIndex = priorityQueue.poll();
                int curRange = max - nums.get(minIndex).get(next[minIndex]);
                if (curRange < minRange) {
                    minRange = curRange;
                    rangeLeft = nums.get(minIndex).get(next[minIndex]);
                    rangeRight = max;
                }
                next[minIndex]++;
                if (next[minIndex] == nums.get(minIndex).size()) {
                    break;
                }
                priorityQueue.offer(minIndex);
                max = Math.max(max, nums.get(minIndex).get(next[minIndex]));
            }
            return new int[]{rangeLeft, rangeRight};
        }
    }

}
