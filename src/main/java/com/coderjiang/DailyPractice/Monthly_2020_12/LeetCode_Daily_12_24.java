package com.coderjiang.DailyPractice.Monthly_2020_12;

import java.util.Arrays;

/**
 *
 * <ul>
 *     <others.li>
 *         可用Arrays.fill(Arrays, value)快速填充数组里的值
 *     </others.li>
 *     <others.li>
 *         可将同时要求左右两边的问题化为 满足左右规则，以此来将问题变成两次遍历的问题
 *     </others.li>
 * </ul>
 * @author 刘江
 * @modifyTime 2020/12/24 17:27
 */
public class LeetCode_Daily_12_24 {
    public static void main(String[] args) {

    }

    static class Solution {
        public int candy(int[] ratings) {
            int n = ratings.length;
            if (n == 0) return 0;
            int[] left = new int[n];
            int[] right = new int[n];
            Arrays.fill(left, 1);
            Arrays.fill(right, 1);
            for (int i = 1; i < n; i++) {
                if (ratings[i] > ratings[i - 1]) {
                    left[i] = left[i - 1] + 1;
                }
            }
            int res = left[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    right[i] = right[i + 1] + 1;
                }
                res += Math.max(left[i], right[i]);
            }
            return res;
        }
    }
}
