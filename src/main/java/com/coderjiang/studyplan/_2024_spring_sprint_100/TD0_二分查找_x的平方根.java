package com.coderjiang.StudyPlan._2024_spring_sprint_100;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-07-04 11:20:29</p>
 */
public class TD0_二分查找_x的平方根 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int mySqrt(int x) {
            long l = 0, r = 1 << 16;
            long res = 0;
            while (l <= r) {
                long mid = l + (r - l) / 2;
                if (mid * mid < x) {
                    res = mid;
                    l = mid + 1;
                } else if (mid * mid > x) {
                    r = mid - 1;
                } else {
                    return (int) mid;
                }
            }
            return (int) res;
        }
    }

}
