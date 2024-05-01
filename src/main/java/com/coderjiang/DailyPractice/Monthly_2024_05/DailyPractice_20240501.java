package com.coderjiang.DailyPractice.Monthly_2024_05;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-05-01 09:43:23</p>
 */
public class DailyPractice_20240501 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public long totalCost(int[] costs, int k, int candidates) {
            PriorityQueue<Integer> left = new PriorityQueue<>(), right = new PriorityQueue<>();
            int lhs = candidates, rhs = costs.length - 1 - candidates;
            if (costs.length < candidates * 2) {
                Arrays.sort(costs);
                return Arrays.stream(costs).limit(k).sum();
            } else {
                long res = 0;
                for (int i = 0; i < candidates; i++) {
                    left.add(costs[i]);
                }
                for (int i = costs.length - candidates; i < costs.length; i++) {
                    right.add(costs[i]);
                }
                int turns;
                for (turns = 0; turns < k && lhs <= rhs; turns++) {
                    int leftMin = left.peek();
                    int rightMin = right.peek();
                    if (leftMin <= rightMin) {
                        res += leftMin;
                        left.poll();
                        left.offer(costs[lhs++]);
                    } else {
                        res += rightMin;
                        right.poll();
                        right.offer(costs[rhs--]);
                    }
                }
                while (turns < k && (!left.isEmpty() && !right.isEmpty())) {
                    int leftMin = left.peek();
                    int rightMin = right.peek();
                    if (leftMin < rightMin) {
                        res += leftMin;
                        left.poll();
                    } else {
                        res += rightMin;
                        right.poll();
                    }
                    turns++;
                }
                while (turns < k && !left.isEmpty()) {
                    res += left.poll();
                    turns++;
                }
                while (turns < k && !right.isEmpty()) {
                    res += right.poll();
                    turns++;
                }
                return res;
            }
        }
    }

}
