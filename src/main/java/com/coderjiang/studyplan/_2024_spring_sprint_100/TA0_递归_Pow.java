package com.coderjiang.StudyPlan._2024_spring_sprint_100;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-06-29 08:28:15</p>
 */
public class TA0_递归_Pow {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        Map<Long, Double> memo = new HashMap<>();

        public double myPow(double x, int n) {
            if (n < 0) {
                return 1 / _pow(x, -n);
            }
            return _pow(x, n);
        }

        private double _pow(double x, long n) {
            if (n == 0) return 1;
            if (n == 1) return x;
            if (memo.containsKey(n)) return memo.get(n);
            memo.put(n, _pow(x, n / 2) * _pow(x, n - n / 2));
            return memo.get(n);
        }
    }

}
