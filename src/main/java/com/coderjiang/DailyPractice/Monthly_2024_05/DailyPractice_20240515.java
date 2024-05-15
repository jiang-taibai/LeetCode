package com.coderjiang.DailyPractice.Monthly_2024_05;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-05-15 22:33:30</p>
 */
public class DailyPractice_20240515 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        public static final int MAX_TIME = 2000;

        public int findMinimumTime(int[][] tasks) {
            Arrays.sort(tasks, Comparator.comparingInt(a -> a[1]));
            int[] run = new int[MAX_TIME + 10];
            int res = 0;
            for (int[] task : tasks) {
                int start = task[0], end = task[1], duration = task[2];
                for (int i = start; i <= end; i++) {
                    duration -= run[i];
                }
                res += Integer.max(duration, 0);
                for (int i = end; i >= start && duration > 0; i--) {
                    if (run[i] == 0) {
                        duration--;
                        run[i] = 1;
                    }
                }
            }
            return res;
        }
    }

}
/*
[[2,3,1],[4,5,1],[1,5,2]]
1 2 3 4 5
  1 1
      2 2
3 3 3 3 3
 */