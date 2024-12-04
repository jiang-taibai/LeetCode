package com.coderjiang.DailyPractice.Monthly_2024_12;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-12-03 19:12:39</p>
 */
public class DailyPractice_20241203 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
            return (
                    (((coordinate1.charAt(0) - 'a') & 1) == ((coordinate1.charAt(1) - '1') & 1)) ==
                            (((coordinate2.charAt(0) - 'a') & 1) == ((coordinate2.charAt(1) - '1') & 1))
            );
        }
    }

}
