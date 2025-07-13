package com.coderjiang.DailyPractice.Monthly_2025_07;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-07-13 09:05:42</p>
 */
public class DailyPractice_20250713 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int matchPlayersAndTrainers(int[] players, int[] trainers) {
            Arrays.sort(players);
            Arrays.sort(trainers);
            int i = 0, j = 0;
            int n = players.length, m = trainers.length;
            int count = 0;
            while (i < n && j < m) {
                if (players[i] <= trainers[j]) {
                    count++;
                    ++i;
                }
                ++j;
            }
            return count;
        }
    }

}
