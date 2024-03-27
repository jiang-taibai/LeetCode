package com.coderjiang.DailyPractice.Monthly_2024_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Creation Time: 2024/3/27</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_03_27 {

    public static void main(String[] args) {
        int[][] ranges = new int[][]{{1, 3}, {10, 20}, {2, 5}, {4, 8}};
        Solution solution = new Solution();
        solution.countWays(ranges);
    }

    static class Solution {

        private static final long MOD = (long) (1e9 + 7);

        public int countWays(int[][] ranges) {
            int n = ranges.length;
            Arrays.sort(ranges, (a, b) -> {
                if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
                return Integer.compare(a[0], b[0]);
            });
            List<int[]> mergedArrays = new ArrayList<>();
            for (int i = 0; i < n - 1; i++) {
                int[] curRange = ranges[i];
                int[] nextRange = ranges[i + 1];
                if (curRange[1] >= nextRange[0]) {
                    // 有重叠
                    nextRange[0] = curRange[0];
                    nextRange[1] = Integer.max(curRange[1], nextRange[1]);
                } else {
                    mergedArrays.add(curRange);
                }
            }
            mergedArrays.add(ranges[n - 1]);
            return (int) powMod(2, mergedArrays.size(), MOD);
        }

        private long powMod(long a, long b, long mod) {
            long res = 1;
            for (int i = 0; i < b; i++) {
                res = (res * a) % mod;
            }
            return res;
        }
    }

}
/*
[[1,3],[10,20],[2,5],[4,8]]
[[1,3],[2,5],[4,8],[10,20]]
[[1,3],[1,5],[4,8],[10,20]]
[[1,3],[1,5],[1,8],[10,20]]

n个兔子跳2个坑，有几种排列组合方式？
2n

2 -> 4
[][AB]
[A][B]
[B][A]
[AB][]

3 -> 8
[][ABC]
[A][BC]
[B][AC]
[C][AB]
[BC][A]
[AC][B]
[AB][C]
[ABC][]
*2

 */