package com.coderjiang.DailyPractice.Monthly_2025_02;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-02-18 21:16:36</p>
 */
public class DailyPractice_20250218 {

    public static void main(String[] args) {
    }

    static class RangeFreqQuery {

        private Map<Integer, List<Integer>> map = new HashMap<>();

        public RangeFreqQuery(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                List<Integer> indexes = map.getOrDefault(arr[i], new ArrayList<>());
                indexes.add(i);
                map.put(arr[i], indexes);
            }
        }

        public int query(int left, int right, int value) {
            List<Integer> indexes = map.get(value);
            if (indexes == null) return 0;
            int l = lowerBound(indexes, left);
            int r = upperBound(indexes, right);
            return r - l;
        }

        private int lowerBound(List<Integer> pos, int target) {
            int low = 0, high = pos.size() - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (pos.get(mid) < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return low;
        }

        private int upperBound(List<Integer> pos, int target) {
            int low = 0, high = pos.size() - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (pos.get(mid) <= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return low;
        }
    }

}
