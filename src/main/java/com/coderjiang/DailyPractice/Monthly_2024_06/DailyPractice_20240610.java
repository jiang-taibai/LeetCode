package com.coderjiang.DailyPractice.Monthly_2024_06;

import java.util.Arrays;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-06-10 15:11:26</p>
 */
public class DailyPractice_20240610 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int numRescueBoats(int[] people, int limit) {
            Arrays.sort(people);
            int lhs = 0, rhs = people.length - 1;
            int res = 0;
            while (lhs < rhs) {
                if (people[lhs] + people[rhs] <= limit) {
                    lhs++;
                }
                rhs--;
                res++;
            }
            if (lhs == rhs) res++;
            return res;
        }
    }

}
