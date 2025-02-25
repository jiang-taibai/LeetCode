package com.coderjiang.DailyPractice.Monthly_2025_02;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-02-19 21:03:45</p>
 */
public class DailyPractice_20250219 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int maxDistance(List<List<Integer>> arrays) {
            int preMin = arrays.get(0).get(0), preMax = arrays.get(0).get(arrays.get(0).size() - 1);
            int maxDistance = 0;
            for (int i = 1; i < arrays.size(); i++) {
                List<Integer> array = arrays.get(i);
                maxDistance = Math.max(maxDistance, Math.abs(preMin-array.get(array.size()-1)));
                maxDistance = Math.max(maxDistance, Math.abs(preMax-array.get(0)));
                preMin = Math.min(preMin, array.get(0));
                preMax = Math.max(preMax, array.get(array.size()-1));
            }
            return maxDistance;
        }
    }

}
