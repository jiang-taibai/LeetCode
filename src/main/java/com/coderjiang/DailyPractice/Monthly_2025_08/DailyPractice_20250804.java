package com.coderjiang.DailyPractice.Monthly_2025_08;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-08-04 20:16:27</p>
 */
public class DailyPractice_20250804 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int totalFruit(int[] fruits) {
            int l = 0, r = 0, lastIndex = 0;
            int[] category = new int[]{fruits[0], -1};
            int[] categoryIndex = new int[]{0, -1};
            int n = fruits.length;
            int res = 0;
            while (r < n) {
                if (category[0] == fruits[r]) {
                    categoryIndex[0] = r;
                } else if (category[1] == fruits[r]) {
                    categoryIndex[1] = r;
                } else {
                    // 新的种类
                    res = Math.max(res, r - l);
                    if (category[0] == fruits[r - 1]) {
                        l = categoryIndex[1] + 1;
                        category[1] = fruits[r];
                        categoryIndex[1] = r;
                    } else {
                        l = categoryIndex[0] + 1;
                        category[0] = fruits[r];
                        categoryIndex[0] = r;
                    }
                }
                ++r;
            }
            res = Math.max(res, r - l);
            return res;
        }
    }

}
