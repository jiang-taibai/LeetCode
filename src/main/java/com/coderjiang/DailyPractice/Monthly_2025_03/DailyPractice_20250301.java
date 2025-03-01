package com.coderjiang.DailyPractice.Monthly_2025_03;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-03-01 16:59:45</p>
 */
public class DailyPractice_20250301 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> results = dfs(s.toCharArray(), 0);
            List<List<String>> res = new ArrayList<>();
            for (List<String> result : results) {
                List<String> temp = new ArrayList<>();
                for (int i = result.size() - 1; i >= 1; --i) {
                    temp.add(result.get(i));
                }
                res.add(temp);
            }
            return res;
        }

        private List<List<String>> dfs(char[] chars, int start) {
            int n = chars.length;
            List<List<String>> result = new ArrayList<>();
            if (start == n) {
                List<String> emptyResult = new ArrayList<>();
                emptyResult.add("#");
                result.add(emptyResult);
                return result;
            }
            for (int i = start; i < n; ++i) {
                if (isPalindrome(chars, start, i)) {
                    List<List<String>> subResult = dfs(chars, i + 1);
                    if (subResult != null) {
                        String subString = toSubString(chars, start, i);
                        for (List<String> subResultList : subResult) {
                            subResultList.add(subString);
                        }
                        result.addAll(subResult);
                    }
                }
            }
            if (result.size() == 0) return null;
            return result;
        }

        private boolean isPalindrome(char[] chars, int l, int r) {
            while (l < r) {
                if (chars[l] != chars[r]) return false;
                l++;
                r--;
            }
            return true;
        }

        private String toSubString(char[] chars, int l, int r) {
            StringBuilder sb = new StringBuilder();
            for (int i = l; i <= r; ++i) {
                sb.append(chars[i]);
            }
            return sb.toString();
        }
    }

}
