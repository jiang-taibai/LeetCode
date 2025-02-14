package com.coderjiang.DailyPractice.Monthly_2025_02;

import java.util.Arrays;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-02-14 14:36:54</p>
 */
public class DailyPractice_20250214 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int maxDistance(int[] position, int m) {
            Arrays.sort(position);
            int l = 1, r = (int) 1e9;
            int res = 0;
            while (l <= r) {
                int mid = (l + r) / 2;
                if(valid(position, mid, m)) {
                    res = Math.max(res, mid);
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return res;
        }

        private boolean valid(int[] position, int dis, int m) {
            int set = 1;
            int preIndex = position[0];
            for (int i = 1; i < position.length; i++) {
                if (position[i] - preIndex >= dis) {
                    preIndex = position[i];
                    set++;
                }
            }
            return set >= m;
        }
    }

}
