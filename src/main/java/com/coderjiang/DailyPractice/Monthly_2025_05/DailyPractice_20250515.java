package com.coderjiang.DailyPractice.Monthly_2025_05;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-05-15 10:15:36</p>
 */
public class DailyPractice_20250515 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public List<String> getLongestSubsequence(String[] words, int[] groups) {
            int firstIndexOfOne = -1, firstIndexOfZero = -1;
            for (int i = 0; i < groups.length; ++i) {
                if (firstIndexOfOne == -1 && groups[i] == 1) {
                    firstIndexOfOne = i;
                } else if (firstIndexOfZero == -1 && groups[i] == 0) {
                    firstIndexOfZero = i;
                } else if (firstIndexOfOne != -1 && firstIndexOfZero != -1) {
                    break;
                }
            }
            List<String> startWithOne = startWith(words, groups, firstIndexOfOne);
            List<String> startWithZero = startWith(words, groups, firstIndexOfZero);
            return startWithOne.size() > startWithZero.size() ? startWithOne : startWithZero;
        }

        private List<String> startWith(String[] words, int[] groups, int index) {
            List<String> res = new ArrayList<>();
            if (index == -1) return res;
            int bit = groups[index];
            res.add(words[index]);
            for (int i = index + 1; i < groups.length; ++i) {
                if (groups[i] != bit) {
                    res.add(words[i]);
                    bit = groups[i];
                }
            }
            return res;
        }
    }

}
