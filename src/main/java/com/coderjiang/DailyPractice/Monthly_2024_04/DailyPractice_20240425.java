package com.coderjiang.DailyPractice.Monthly_2024_04;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-04-25 09:53:34</p>
 */
public class DailyPractice_20240425 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int distanceTraveled(int mainTank, int additionalTank) {
            return (mainTank +
                    Integer.min(
                            mainTank / 4 - 1 + (mainTank % 4 == 0 ? 0 : 1),
                            additionalTank
                    )
            ) * 10;
        }
    }

}
