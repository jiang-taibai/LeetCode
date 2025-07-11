package com.coderjiang.DailyPractice.Monthly_2025_07;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-07-11 23:33:18</p>
 */
public class DailyPractice_20250711 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int countDays(int days, int[][] meetings) {
            Arrays.sort(meetings, (lhs, rhs) -> {
                if (lhs[0] != rhs[0]) return lhs[0] - rhs[0];
                return lhs[1] - rhs[1];
            });
            int n = meetings.length;
            int preEnding = 1;
            int noWorkingDays = 0;
            for (int i = 0; i < n; ++i) {
                if (meetings[i][0] > preEnding) noWorkingDays += meetings[i][0] - preEnding;
                preEnding = Math.max(preEnding, meetings[i][1] + 1);
            }
            if (days >= preEnding) noWorkingDays += days - preEnding + 1;
            return noWorkingDays;
        }
    }

/*
[3,4],[4,8],[2,5],[3,8]
2,5
3,4
3,8
4,8
*/

}
