package com.coderjiang.DailyPractice.Monthly_2024_05;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-05-23 03:58:50</p>
 */
public class DailyPractice_20240523 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> nums = Arrays.stream(new int[]{
                1, 1, 2, 3, 3, 2, 1, 1, 3, 3, 1, 2, 2, 2
        }).boxed().collect(Collectors.toList());
        int k = 2;
        System.out.println(solution.longestEqualSubarray(nums, k));
    }

    static class Solution {
        public int longestEqualSubarray(List<Integer> nums, int k) {
            // 变换结构解题
            // 将相同的数字的下标放到同一组，比如
            //      [1,2,1,3,1] => [[0, 2, 4], [1], [3]] = indexesOfNums
            // 如此得到了一个二维数组，indexesOfNums[i]=indexes，变换为子问题：
            // 求 indexes 子数组和不超过 k 的最大长度
            // 该问题很好求解，利用滑动窗口即可
            // -------------------------------------------------
//            @SuppressWarnings("unchecked")
//            List<Integer>[] indexesOfNums = new List[100000 + 10];
            Map<Integer, List<Integer>> indexesOfNums = new HashMap<>();
//            for (int i = 0; i < indexesOfNums.length; i++) {
//                indexesOfNums[i] = new ArrayList<>();
//            }
            for (int i = 0; i < nums.size(); i++) {
                indexesOfNums.computeIfAbsent(nums.get(i), f -> new ArrayList<>());
                indexesOfNums.get(nums.get(i)).add(i);
            }
            for (List<Integer> indexes : indexesOfNums.values()) {
                if (indexes.isEmpty()) continue;
                for (int j = indexes.size() - 1; j >= 1; j--) {
                    indexes.set(j, indexes.get(j) - indexes.get(j - 1) - 1);
                }
                indexes.set(0, 0);
            }
            int res = 0;
            for (List<Integer> indexes : indexesOfNums.values()) {
                if (indexes.isEmpty()) continue;
                res = Math.max(res, solve(indexes, k));
            }
            return res;
        }

        private int solve(List<Integer> indexes, int k) {
            int lhs = -1, rhs = 0;
            int sum = 0, maxLength = 0;
            int n = indexes.size();
            while (lhs < n - 1 && rhs < n) {
                if (sum + indexes.get(rhs) <= k) {
                    sum += indexes.get(rhs);
                    if (lhs == -1) {
                        maxLength = Math.max(maxLength, rhs + 1);
                    } else {
                        maxLength = Math.max(maxLength, rhs - lhs + 1);
                    }
//                    maxLength = Math.max(maxLength, rhs - Math.max(0, lhs) + 1);
                    rhs++;
                } else {
                    sum -= indexes.get(lhs + 1);
                    lhs++;
                }
            }
            return maxLength;
        }
    }

}
