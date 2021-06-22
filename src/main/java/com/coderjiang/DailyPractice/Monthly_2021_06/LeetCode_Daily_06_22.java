package com.coderjiang.DailyPractice.Monthly_2021_06;

import java.util.*;

public class LeetCode_Daily_06_22 {

    static class Solution {

        private Set<String> set = new HashSet<>();

        private void swap(char[] chars, int l, int r) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
        }

        private void dfs(int index, char[] chars) {
            if (index == chars.length) {
                set.add(String.valueOf(chars));
            }
            for (int i = index; i < chars.length; i++) {
                swap(chars, i, index);
                dfs(index + 1, chars.clone());
                swap(chars, i, index);
            }
        }

        public String[] permutation(String s) {
            dfs(0, s.toCharArray());
            String[] res = new String[set.size()];
            Object[] arr = set.toArray();
            for (int i = 0; i < set.size(); i++) {
                res[i] = (String) arr[i];
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.permutation("abc")));
    }

}