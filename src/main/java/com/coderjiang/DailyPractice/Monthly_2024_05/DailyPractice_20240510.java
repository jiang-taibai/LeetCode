package com.coderjiang.DailyPractice.Monthly_2024_05;

import java.util.Arrays;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-05-10 18:56:03</p>
 */
public class DailyPractice_20240510 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int countTestedDevices(int[] batteryPercentages) {
            int n = batteryPercentages.length;
            int num = 0;
            for (int batteryPercentage : batteryPercentages) {
                if(batteryPercentage > num) {
                    num++;
                }
            }
            return num;
        }
    }

}
