package com.coderjiang.DailyPractice.Monthly_2024_12;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-12-20 08:47:56</p>
 */
public class DailyPractice_20241220 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int minAnagramLength(String s) {
            int n = s.length();
            for (int i = 1; i < n; i++) {
                if (n % i != 0) continue;
                if (check(s, i)) return i;
            }
            return n;
        }

        private boolean check(String s, int len) {
            int[] cntOfT = new int[26];
            for (int i = 0; i < len; i++) {
                cntOfT[s.charAt(i) - 'a']++;
            }
            for (int i = len; i < s.length(); ) {
                int[] cnt = new int[26];
                for (int j = 0; j < len; j++) {
                    cnt[s.charAt(i + j) - 'a']++;
                }
                i += len;
                for (int j = 0; j < 26; j++) {
                    if (cntOfT[j] != cnt[j]) return false;
                }
            }
            return true;
        }
    }

}
/*
s 的长度一定是同位字符串 t 的长度的倍数，因此只需要遍历 s 的长度的所有因数，试试所有可能的字符串

 */