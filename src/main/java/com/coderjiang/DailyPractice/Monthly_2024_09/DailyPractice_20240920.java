package com.coderjiang.DailyPractice.Monthly_2024_09;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-09-20 11:08:34</p>
 */
public class DailyPractice_20240920 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        private final Map<Integer, Integer> memo = new HashMap<>();

        public int countSpecialNumbers(int n) {
            int[] digits = toDigits(n);
            return n - dfs(digits, new boolean[10], 0, false);
        }

        private int[] toDigits(int n) {
            char[] digitChars = Integer.toString(n).toCharArray();
            int[] digits = new int[digitChars.length];
            for (int i = 0; i < digits.length; i++) {
                digits[i] = digitChars[i] - '0';
            }
            return digits;
        }

        private int dfs(int[] digits, boolean[] set, int cur, boolean preLow) {
//            int checkResult = checkDebug(digits, cur, preLow);

            int key = 0;
            for (int digit : digits) {
                key *= 10;
                key += digit;
            }
            key = key * 100 + cur * 10 + (preLow ? 1 : 0);
            if (memo.containsKey(key)) {
                return memo.get(key);
            }

            int res = 0;
            int n = digits.length;
            if (cur >= n) return 0;
            int curDigit = digits[cur];

            boolean preIsAllZero = true;
            for (int j = 0; j < cur; j++) {
                if (digits[j] != 0) {
                    preIsAllZero = false;
                    break;
                }
            }

            if (preLow) {
                for (int i = 0; i < 10; i++) {
                    if (set[i]) {
                        // 如果之前设置过 i，那么当前位设置 i 的话，之后位无论设置什么都是不特殊的数字
                        // 因为 pewLow 了，所以后面位怎么设置都一定比原数字小
                        res += (int) Math.pow(10, n - cur - 1);
                        // 还需要考虑前面全 0 时，后面就不能全 0 了，因为特殊的数字大于 0 的

                        if (preIsAllZero) res -= 1;
                    } else {
                        // 如果没设置，那么就把当前位设置为 i，再递归考虑子情况
                        set[i] = i != 0 || !preIsAllZero;
                        digits[cur] = i;
                        res += dfs(digits, set, cur + 1, true);
                        digits[cur] = curDigit;
                        set[i] = false;
                    }
                }
            } else {
                if (set[curDigit]) {
                    // 特殊考虑，如果 curDigit 被设置过了，那么后面位需要保证比原数字小的情况下进行排列组合
                    int subRes = 0;
                    for (int i = cur + 1; i < n; i++) {
                        // 如果后面位为 1，实际上可以设置 [0, 1] 两种情况
                        subRes *= 10;
                        subRes += digits[i];
                    }
                    res += subRes + 1;
                } else {
                    set[curDigit] = true;
                    res += dfs(digits, set, cur + 1, false);
                    set[curDigit] = false;
                }

                for (int i = 0; i < curDigit; i++) {
                    if (set[i]) {
                        // 如果之前设置过 i，那么当前位设置 i 的话，之后位无论设置什么都是不特殊的数字
                        // 因为当前位比原来的小，后面位怎么设置都一定比原数字小
                        res += (int) Math.pow(10, n - cur - 1);
                    } else {
                        // 如果没设置，那么就把当前位设置为 i，再递归考虑子情况
                        set[i] = i != 0 || !preIsAllZero;
                        digits[cur] = i;
                        res += dfs(digits, set, cur + 1, true);
                        digits[cur] = curDigit;
                        set[i] = false;
                    }
                }
            }
//            if (res != checkResult) {
//                System.out.printf("(%s,%d): %d -> %d\n", Arrays.toString(digits), cur, res, checkResult);
//            } else {
//                System.out.printf("(%s,%d): %d\n", Arrays.toString(digits), cur, res);
//            }
            memo.put(key, res);
            return res;
        }

        private int checkDebug(int[] digits, int cur, boolean preLow) {
            int start = 0, end = 0;
            for (int i = 0; i < digits.length; i++) {
                end *= 10;
                end += i >= cur && preLow ? 9 : digits[i];
                start *= 10;
                start += i >= cur ? 0 : digits[i];
            }
            int res = 0;
            for (int i = start; i <= end; i++) {
                boolean[] set = new boolean[10];
                char[] digitChars = Integer.toString(i).toCharArray();
                boolean valid = true;
                for (char digitChar : digitChars) {
                    if (set[digitChar - '0']) {
                        valid = false;
                        break;
                    }
                    set[digitChar - '0'] = true;
                }
                if (valid) res++;
            }
            return end - start + 1 - res;
        }
    }

}
/*
([0, 1, 5],2): 2
([0, 2, 5],2): 2
([0, 3, 5],2): 2
([0, 4, 5],2): 2
([0, 5, 5],2): 2
([0, 6, 5],2): 2

不应该将前置0作为重复的数字
 */
