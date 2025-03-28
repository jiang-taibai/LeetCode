package com.coderjiang.DailyPractice.Monthly_2025_03;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-03-28 20:56:20</p>
 */
public class DailyPractice_20250328 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int minimizedStringLength(String s) {
            boolean[] vis = new boolean[26];
            int res = 0;
            for (char ch : s.toCharArray()) {
                if (vis[ch - 'a']) continue;
                vis[ch - 'a'] = true;
                res++;
            }
            return res;
        }
    }

}
