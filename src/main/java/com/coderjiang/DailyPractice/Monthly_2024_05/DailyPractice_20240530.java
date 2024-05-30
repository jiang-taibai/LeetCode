package com.coderjiang.DailyPractice.Monthly_2024_05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-05-30 14:51:07</p>
 */
public class DailyPractice_20240530 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aaaabbbbbbbbbbbbbcc";
        System.out.println(solution.maximumLength(s));
    }

    static class Solution {
        public int maximumLength(String s) {
            List<List<Integer>> seq = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                seq.add(new ArrayList<>());
            }
            char pre = s.charAt(0);
            int len = 0;
            for (char c : s.toCharArray()) {
                if (c != pre) {
                    seq.get(pre - 'a').add(len);
                    len = 1;
                    pre = c;
                } else {
                    len++;
                }
            }
            seq.get(pre - 'a').add(len);
            int res = -1;
            for (List<Integer> lens : seq) {
                res = Math.max(res, maximumCharLength(lens));
            }
            return res;
        }

        private int maximumCharLength(List<Integer> lens) {
            lens.sort(Collections.reverseOrder());
            int res = -1;
            if (lens.isEmpty()) return -1;
            if (lens.get(0) >= 3) res = Math.max(res, lens.get(0) - 2);
            if (lens.size() >= 3) {
                if (lens.get(0).equals(lens.get(1)) && lens.get(0).equals(lens.get(2))) {
                    res = Math.max(res, lens.get(0));
                }
            }
            if (lens.size() >= 2) {
                if (lens.get(0).equals(lens.get(1))) {
                    res = Math.max(res, lens.get(0) - 1);
                } else {
                    res = Math.max(res, lens.get(1));
                }
            }
            return res > 0 ? res : -1;
        }
    }

}
