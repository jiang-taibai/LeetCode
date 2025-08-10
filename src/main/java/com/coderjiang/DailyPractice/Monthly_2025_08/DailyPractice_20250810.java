package com.coderjiang.DailyPractice.Monthly_2025_08;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-08-10 23:15:10</p>
 */
public class DailyPractice_20250810 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public boolean reorderedPowerOf2(int n) {
            Set<String> set = new HashSet<>();
            int num = 1;
            while(num < (1 << 30)) {
                set.add(sortedInt(num));
                num <<= 1;
            }
            return set.contains(sortedInt(n));
        }

        private String sortedInt(int n) {
            int[] cnt = new int[10];
            while(n != 0) {
                cnt[n % 10]++;
                n /= 10;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 10; ++i) {
                for(int j = 0; j < cnt[i]; ++j) {
                    sb.append((char)('0' + i));
                }
            }
            return sb.toString();
        }
    }

}
