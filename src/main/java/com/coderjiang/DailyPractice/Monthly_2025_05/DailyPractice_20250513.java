package com.coderjiang.DailyPractice.Monthly_2025_05;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-05-13 18:20:14</p>
 */
public class DailyPractice_20250513 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int lengthAfterTransformations(String s, int t) {
            int MOD = (int) (1e9 + 7);
            long[] cnt = new long[26];
            for (char ch : s.toCharArray()) cnt[ch - 'a']++;
            while (t > 0) {
                long[] nextCnt = new long[26];
                int step = Math.min(t, 25);
                t -= step;
                for (int i = 0; i < 26; ++i) {
                    if (cnt[i] == 0) continue;
                    if (i + step >= 26) {
                        nextCnt[(i + step) % 26] += cnt[i];
                        nextCnt[(i + step + 1) % 26] += cnt[i];
                        nextCnt[(i + step) % 26] %= MOD;
                        nextCnt[(i + step + 1) % 26] %= MOD;
                    } else {
                        nextCnt[i + step] += cnt[i];
                        nextCnt[i + step] %= MOD;
                    }
                }
                cnt = nextCnt;
            }
            long res = 0;
            for (int i = 0; i < 26; ++i) {
                res += cnt[i];
                res %= MOD;
            }
            return (int) res;
        }
    }

/*
a -> z -> ab
z
a  b    1
y  z    25
z  ab   26
ab bc   27

*/

}
