package com.coderjiang.DailyPractice.Monthly_2024_02;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * <p>Creation Time: 2024-02-01</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_02_01 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 4, 5, 1, 6, 7};
        int[] nums2 = {471, 626, 848, 957, 788, 138, 982, 721, 729, 956, 432, 1000, 478, 353, 586, 544, 304, 811, 359, 535, 992, 684, 606, 39, 384, 799, 120, 608, 540, 914, 19, 62, 410, 711, 449, 370, 263, 890, 124, 516, 861, 936, 729, 595, 768, 929, 649, 803, 65, 692, 548, 620, 871, 785, 15, 629, 251, 764, 973, 484, 172, 923, 859, 29, 297, 215, 436, 74, 762, 885, 272, 504, 307, 998, 83, 329, 520, 889, 584, 496, 443, 802, 180, 322, 640, 290, 292, 403, 11, 230, 743, 183, 600, 741, 558, 780, 970, 777, 288};
        System.out.println(Arrays.toString(solution.numsGame(nums2)));
    }

    static class Solution {
        public int[] numsGame(int[] nums) {
            final int MOD = 1000000007;
            int[] res = new int[nums.length];
            // lower, upper 存储 nums[0, i] 中的数字，并满足
            // 1. lower 是大顶堆，upper 是小顶堆
            // 1. lower 的数字都比 upper 小
            // 2. |lower.size()-upper.size()| < 1，如果相同，默认给 lower
            PriorityQueue<Integer> lower = new PriorityQueue<>((a, b) -> b - a);
            PriorityQueue<Integer> upper = new PriorityQueue<>((a, b) -> a - b);
            long lowerSum = 0, upperSum = 0;
            for (int i = 0; i < nums.length; i++) {
                // 预处理，使得 nums[i] 都是作为中位数的候选数字
                int num = nums[i] - i;
                if (lower.isEmpty() || lower.peek() >= num) {
                    lowerSum += num;
                    lower.offer(num);
                    if (lower.size() - 1 > upper.size()) {
                        lowerSum -= lower.peek();
                        upperSum += lower.peek();
                        upper.offer(lower.peek());
                        lower.poll();
                    }
                } else {
                    upperSum += num;
                    upper.offer(num);
                    if (lower.size() < upper.size()) {
                        upperSum -= upper.peek();
                        lowerSum += upper.peek();
                        lower.offer(upper.peek());
                        upper.poll();
                    }
                }

                if ((i + 1) % 2 == 0) {
                    res[i] = (int) ((upperSum - lowerSum) % MOD);
                } else {
                    res[i] = (int) ((upperSum - lowerSum + lower.peek()) % MOD);
                }
            }
            return res;
        }
    }

}
