package com.coderjiang.DailyPractice.Monthly_2025_05;

import java.util.ArrayList;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-05-13 18:20:14</p>
 */
public class DailyPractice_20250512 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int[] findEvenNumbers(int[] digits) {
            ArrayList<Integer> res = new ArrayList<>();
            int[] cnt = new int[10];
            for (int digit : digits) cnt[digit]++;
            for (int i = 1; i <= 9; ++i) {
                if (cnt[i] == 0) continue;
                cnt[i]--;
                for (int j = 0; j <= 9; ++j) {
                    if (cnt[j] == 0) continue;
                    cnt[j]--;
                    for (int k = 0; k <= 9; k += 2) {
                        if (cnt[k] == 0) continue;
                        res.add(i * 100 + j * 10 + k);
                    }
                    cnt[j]++;
                }
                cnt[i]++;
            }
            return res.stream().mapToInt(i -> i).toArray();
        }
    }

}
