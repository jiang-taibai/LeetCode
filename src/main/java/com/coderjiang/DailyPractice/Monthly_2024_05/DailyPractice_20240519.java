package com.coderjiang.DailyPractice.Monthly_2024_05;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-05-19 12:15:52</p>
 */
public class DailyPractice_20240519 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int getWinner(int[] arr, int k) {
            Queue<Integer> queue = new LinkedList<>();
            if (k >= arr.length) {
                return Arrays.stream(arr).max().getAsInt();
            }
            int winner = arr[0];
            for (int i = 1; i < arr.length; i++) {
                queue.add(arr[i]);
            }
            int times = 0;
            while (times < k) {
                int candidate = queue.poll();
                if (winner > candidate) {
                    times++;
                    queue.offer(candidate);
                } else {
                    times = 1;
                    queue.offer(winner);
                    winner = candidate;
                }
            }
            return winner;
        }
    }

}
