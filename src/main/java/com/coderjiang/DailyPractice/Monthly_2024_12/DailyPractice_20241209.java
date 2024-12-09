package com.coderjiang.DailyPractice.Monthly_2024_12;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-12-09 08:52:04</p>
 */
public class DailyPractice_20241209 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public boolean squareIsWhite(String coordinates) {
            int a = coordinates.charAt(0) - 'a';
            int b = coordinates.charAt(1) - '1';
            return (a & 1) != (b & 1);
        }
    }

}
