package com.coderjiang.DailyPractice.Monthly_2024_07;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-07-25 15:09:02</p>
 */
public class DailyPractice_20240725 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int minimumOperations(String num) {
            String[] validPostfixes = new String[]{
                    "00", "25", "50", "75",
            };
            int res = 0;
            for (char c : num.toCharArray()) if (c != '0') res++;
            for (String validPostfix : validPostfixes) {
                res = Math.min(res, minimumOperationsChangePostfix(num, validPostfix));
            }
            return res;
        }

        private int minimumOperationsChangePostfix(String num, String postfix) {
            int postfixIndex = postfix.length() - 1;
            for (int numIndex = num.length() - 1; numIndex >= 0; numIndex--) {
                if (num.charAt(numIndex) == postfix.charAt(postfixIndex)) {
                    if (postfixIndex == 0) {
                        return num.length() - numIndex - postfix.length();
                    }
                    postfixIndex--;
                }
            }
            return Integer.MAX_VALUE;
        }
    }

}
