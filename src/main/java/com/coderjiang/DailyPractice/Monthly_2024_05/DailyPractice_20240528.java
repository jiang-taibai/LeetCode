package com.coderjiang.DailyPractice.Monthly_2024_05;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-05-28 13:44:19</p>
 */
public class DailyPractice_20240528 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public List<Integer> findPeaks(int[] mountain) {
            List<Integer> res = new ArrayList<>();
            for (int i = 1; i < mountain.length - 1; ++i) {
                if (mountain[i - 1] < mountain[i] && mountain[i] > mountain[i + 1]) res.add(i);
            }
            return res;
        }
    }

}
