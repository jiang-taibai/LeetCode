package com.coderjiang.DailyPractice.Monthly_2024_12;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-12-19 08:49:01</p>
 */
public class DailyPractice_20241219 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public List<Integer> stableMountains(int[] height, int threshold) {
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < height.length - 1; i++) {
                if (height[i] > threshold) res.add(i + 1);
            }
            return res;
        }
    }

}
