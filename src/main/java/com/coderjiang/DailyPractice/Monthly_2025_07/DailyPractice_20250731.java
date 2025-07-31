package com.coderjiang.DailyPractice.Monthly_2025_07;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-07-31 20:00:51</p>
 */
public class DailyPractice_20250731 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public boolean doesValidArrayExist(int[] derived) {
            return check(derived, 0) || check(derived, 1);
        }

        private boolean check(int[] derived, int start) {
            int curr = start;
            int n = derived.length;
            for (int i = 0; i < n - 1; ++i) {
                if (derived[i] == 1) {
                    curr = curr == 1 ? 0 : 1;
                } else {
                    curr = curr;
                }
            }
            if (derived[n - 1] == 1) {
                return curr != start;
            } else {
                return curr == start;
            }
        }
    }

}
