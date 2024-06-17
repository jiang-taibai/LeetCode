package com.coderjiang.DailyPractice.Monthly_2024_06;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-06-17 14:42:02</p>
 */
public class DailyPractice_20240617 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int findLUSlength(String[] strs) {
            Map<String, Integer> map = new HashMap<>();
            int maxLength = 0;
            for (String str : strs) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String str = entry.getKey();
                Integer count = entry.getValue();
                if (count == 1) {
                    boolean contained = false;
                    for (String s : map.keySet()) {
                        if (str.equals(s)) continue;
                        if (containThisSubsequence(s, str, 0, 0)) {
                            contained = true;
                            break;
                        }
                    }
                    if (!contained) {
                        maxLength = Math.max(maxLength, str.length());
                    }
                }
            }
            return maxLength;
        }

        private boolean containThisSubsequence(String str, String subsequence,
                                               int strIndex, int subsequenceIndex) {
            if (subsequenceIndex >= subsequence.length()) return true;
            if (strIndex >= str.length()) return false;
            boolean res = false;
            for (int i = strIndex; i < str.length(); i++) {
                if (str.charAt(i) == subsequence.charAt(subsequenceIndex)) {
                    res = res || containThisSubsequence(str, subsequence, i + 1, subsequenceIndex + 1);
                }
            }
            return res;
        }
    }

}
