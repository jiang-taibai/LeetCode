package com.coderjiang.DailyPractice.Monthly_2024_11;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-11-27 15:06:48</p>
 */
public class DailyPractice_20241127 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int numberOfAlternatingGroups(int[] colors, int k) {
            List<Integer> lens = new ArrayList<>();
            int n = colors.length;
            int currentLen = 1;
            for (int i = 1; i < n; i++) {
                if (colors[i] != colors[i - 1]) {
                    currentLen++;
                } else {
                    lens.add(currentLen);
                    currentLen = 1;
                }
            }
            lens.add(currentLen);
            if (lens.size() == 1 && colors[n - 1] != colors[0]) {
                return n;
            }
            if (lens.size() != 1 && colors[n - 1] != colors[0]) {
                lens.set(0, lens.get(0) + lens.get(lens.size() - 1));
                lens.remove(lens.size() - 1);
            }
            int res = 0;
            for (Integer len : lens) {
                if (len >= k) {
                    res += len - k + 1;
                }
            }
            return res;
        }
    }

}
