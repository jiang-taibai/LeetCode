package com.coderjiang.DailyPractice.Monthly_2022_01;

/**
 * <p>Creation Time: 2022-01-17 14:51:23</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_01_10 {

    static class Solution {
        public boolean isAdditiveNumber(String num) {
            int n = num.length();
            for (int i = 1; i <= n / 2; ++i) {
                for (int j = 1; j <= n / 2; ++j) {
                    if (i + j >= n) continue;
                    long a = Long.parseLong(num.substring(0, i));
                    long b = Long.parseLong(num.substring(i, i + j));
                    if (num.substring(i + j).startsWith(String.valueOf(a + b))) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(a);
                        sb.append(b);
                        while (sb.length() < num.length()) {
                            long sum = a + b;
                            sb.append(sum);
                            a = b;
                            b = sum;
                        }
                        if (sb.length() == num.length() && sb.toString().equals(num)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isAdditiveNumber("199100199"));
    }

}
