package com.coderjiang.DailyPractice.Monthly_2024_02;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * <p>Creation Time: 2024-02-04</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_02_04 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 1; i < 100; i++) {
            System.out.println(i + ": " + solution.canWinNim(i));
        }
    }

    static class Solution {
        public boolean canWinNim(int n) {
//            boolean dp0 = false, dp1 = true, dp2 = true, dp3 = true;
//            if (n <= 3) return true;
//            for (int i = 3; i <= n; i++) {
//                dp3 = !(dp0 && dp1 && dp2);
//                dp0 = dp1;
//                dp1 = dp2;
//                dp2 = dp3;
//            }
//            return dp3;
            return n % 4 != 0;
        }
    }

}
