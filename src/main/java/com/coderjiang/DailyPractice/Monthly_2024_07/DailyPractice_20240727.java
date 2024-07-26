package com.coderjiang.DailyPractice.Monthly_2024_07;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-07-27 01:36:52</p>
 */
public class DailyPractice_20240727 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 'a'; i <= 'z'; i++) {
            char c1 = (char) i;
            char c2 = solution.getMinCharWithDistance(c1, 1);
            System.out.printf("%c -> %c: %d\n", c1, c2, solution.getDistance(c1, c2));
            System.out.printf("%c -> %c: %d\n", c1, c2 - 1, solution.getDistance(c1, (char) (c2 - 1)));
            System.out.printf("%c -> %c: %d\n", c1, c2 + 1, solution.getDistance(c1, (char) (c2 + 1)));

        }
    }

    static class Solution {
        public String getSmallestString(String s, int k) {
            char[] chars = s.toCharArray();
            int n = chars.length;
            for (int i = 0; i < n && k > 0; i++) {
                int distance = getDistance(chars[i], 'a');
                if (k >= distance) {
                    chars[i] = 'a';
                    k -= distance;
                } else {
                    chars[i] = getMinCharWithDistance(chars[i], k);
                    k = 0;
                }
            }
            // k 可能还有盈余，那么此时字符串肯定是 aaaaa...a
            // 从最小位开始，尝试移动到最大步数的地方
//            for (int i = n - 1; i >= 0 && k > 0; i--) {
//                char origin = s.charAt(i);
//                k += getDistance(origin, chars[i]);
//                char target = getMinCharWithDistance(origin, Math.min(13, k));
//                k -= getDistance(origin, target);
//            }
            return String.valueOf(chars);
        }

        private int getDistance(char c1, char c2) {
            int dis = Math.abs((int) c1 - (int) c2);
            return Math.min(dis, 26 - dis);
        }

        private char getMinCharWithDistance(char c, int distance) {
            int c1 = (c - 'a' + distance) % 26;
            int c2 = (c - 'a' - distance + 26) % 26;
            return (char) (Math.min(c1, c2) + 'a');
        }
    }

}
