package com.coderjiang.DailyPractice.Monthly_2024_10;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-11-05 08:49:54</p>
 */
public class DailyPractice_20241105 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public String losingPlayer(int x, int y) {
            y = y / 4;
            int temp = Math.min(x, y) & 1;
            return temp == 1 ? "Alice" : "Bob";
        }
    }

}
