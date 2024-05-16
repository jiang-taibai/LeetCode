package com.coderjiang.DailyPractice.Monthly_2024_05;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-05-16 17:38:07</p>
 */
public class DailyPractice_20240516 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public long numberOfWeeks(int[] milestones) {
            long maxOfMilestone = milestones[0];
            long resOfMilestone = 0;
            for (int milestone : milestones) {
                maxOfMilestone = Long.max(maxOfMilestone, milestone);
                resOfMilestone += milestone;
            }
            resOfMilestone -= maxOfMilestone;
            if (maxOfMilestone > resOfMilestone + 1) {
                return resOfMilestone * 2 + 1;
            } else {
                return maxOfMilestone + resOfMilestone;
            }
        }
    }

}
/*
5,2,1
5+2 -> 5252 四周 -> 3,1
3+1 -> 31   二周 -> 2

2,2,3 ->
4,4 -> 8
4,5 -> 9
4,6 -> 9

3,2,1
3,2 -> 3232  四周 -> 1,1
1,1   -> 1,1 二周
 */
