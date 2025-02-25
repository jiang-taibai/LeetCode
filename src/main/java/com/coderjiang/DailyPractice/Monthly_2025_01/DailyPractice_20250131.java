package com.coderjiang.DailyPractice.Monthly_2025_01;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-01-31 08:51:56</p>
 */
public class DailyPractice_20250131 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public String reverseStr(String s, int k) {
            int index = 0;
            int n = s.length();
            StringBuilder res = new StringBuilder();
            StringBuilder sb = new StringBuilder();
            while(index < n) {
                for (int i = 0; i < k && index < n; i++) {
                    sb.append(s.charAt(index++));
                }
                res.append(sb.reverse());
                sb.setLength(0);
                for (int i = 0; i < k && index < n; i++) {
                    sb.append(s.charAt(index++));
                }
                res.append(sb);
                sb.setLength(0);
            }
            return res.toString();
        }
    }

}
