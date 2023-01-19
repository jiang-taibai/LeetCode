package com.coderjiang.DailyPractice.Monthly_2023_01;

/**
 * <p>Creation Time: 2023-01-19 00:47:01</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_01_19 {

    class Solution {
        public boolean strongPasswordCheckerII(String password) {
            if (password.length() < 8) return false;
            boolean lowerChar = false;
            boolean upperChar = false;
            boolean number = false;
            boolean specialChar = false;
            boolean successiveSame = false;
            char pre = '\0';
            for (int i = 0; i < password.length(); ++i) {
                final char ch = password.charAt(i);
                if (Character.isLowerCase(ch)) {
                    lowerChar = true;
                } else if (Character.isUpperCase(ch)) {
                    upperChar = true;
                } else if (Character.isDigit(ch)) {
                    number = true;
                } else if (isSpecialChar(ch)) {
                    specialChar = true;
                }
                if (pre == ch) {
                    successiveSame = true;
                }
                pre = ch;
            }
            return lowerChar && upperChar && number && specialChar && !successiveSame;
        }

        // 使用Character静态方法比手撸慢，因为Character静态方法不仅考虑到了英文，还包括其他语言的大小写问题
        private boolean isLower(final char ch) {
            return 'a' <= ch && ch <= 'z';
        }

        private boolean isUpper(final char ch) {
            return 'A' <= ch && ch <= 'Z';
        }

        private boolean isNumber(final char ch) {
            return '0' <= ch && ch <= '9';
        }

        private boolean isSpecialChar(final char ch) {
            return ch == '!' || ch == '@' || ch == '#' || ch == '$' ||
                    ch == '%' || ch == '^' || ch == '&' || ch == '*' ||
                    ch == '(' || ch == ')' || ch == '-' || ch == '+';
        }

    }

}
