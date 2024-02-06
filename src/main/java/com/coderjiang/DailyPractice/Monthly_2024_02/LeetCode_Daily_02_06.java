package com.coderjiang.DailyPractice.Monthly_2024_02;


import java.util.PriorityQueue;

/**
 * <p>Creation Time: 2024-02-14</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_02_06 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int magicTower(int[] nums) {
            long bloodVolume = 1;
            long accumulatedDamage = 0;
            int res = 0;
            PriorityQueue<Integer> receivedDamage = new PriorityQueue<>((a, b) -> a - b);
            for (int num : nums) {
                bloodVolume += num;
                if(num < 0) {
                    receivedDamage.offer(num);
                    if (bloodVolume <= 0) {
                        res++;
                        int damage = receivedDamage.poll();
                        bloodVolume -= damage;
                        accumulatedDamage += damage;
                    }
                }
            }
            if (bloodVolume + accumulatedDamage <= 0) return -1;
            return res;
        }
    }

}
