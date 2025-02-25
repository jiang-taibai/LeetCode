package com.coderjiang.DailyPractice.Monthly_2025_01;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-01-28 08:34:52</p>
 */
public class DailyPractice_20250128 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public List<Integer> getRow(int rowIndex) {
            int[] curLine = new int[rowIndex + 1];
            for (int i = 0; i <= rowIndex; i++) {
                int[] nextLine = new int[rowIndex + 1];
                for (int j = 0; j < i + 1; j++) {
                    if (j == 0 || j == i) nextLine[j] = 1;
                    else nextLine[j] = curLine[j - 1] + curLine[j];
                }
                curLine = nextLine;
            }
            return Arrays.stream(curLine).boxed().collect(Collectors.toList());
        }
    }

}
