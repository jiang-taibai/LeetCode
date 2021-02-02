package com.coderjiang.DailyPractice.Monthly_2021_02;

/**
 * <p>创建时间：2021/2/2 8:04</p>
 * <p>主要功能：TODO</p>
 *
 * @author 刘江
 */
public class LeetCode_Daily_02_02 {
    public static void main(String[] args) {

    }

    class Solution_Original {
        private int[] counts;

        public int characterReplacement(String s, int k) {
            counts = new int[26]; // 记录滑动窗口中字符出现次数
            int lhs = 0, rhs = 0, n = s.length();
            if (n <= 0) return n;
            add(s.charAt(0));
            int maxLen = 0;
            while (rhs < n) {
                int[] maxAndOther = findMaxAndOthers();
                int max = maxAndOther[0];
                int other = maxAndOther[1];
                if (other <= k) {
                    if (other + max > maxLen) maxLen = other + max;
                    rhs++;
                    if (rhs < n) add(s.charAt(rhs));
                } else {
                    sub(s.charAt(lhs));
                    lhs++;
                }
            }
            return maxLen;
        }

        private void add(char ch) {
            counts[ch - 'A']++;
        }

        private void sub(char ch) {
            counts[ch - 'A']--;
        }

        // 返回数组的第一个是当前滑动窗口出现次数最多的字符数，第二个是其他元素出现次数
        private int[] findMaxAndOthers() {
            int count = 0;
            int maxVal = 0;
            for (int i = 0; i < counts.length; i++) {
                count += counts[i];
                if (counts[i] > maxVal) maxVal = counts[i];
            }
            return new int[]{maxVal, count - maxVal};
        }
    }

    class Solution {
        public int characterReplacement(String s, int k) {
            int[] counts = new int[26];
            int n = s.length();
            int lhs = 0, rhs = 0;
            int maxn = 0;
            while (rhs < n) {
                maxn = Math.max(maxn, ++counts[s.charAt(rhs) - 'A']);
                if (rhs - lhs + 1 - maxn > k) {
                    counts[s.charAt(lhs) - 'A']--;
                    lhs++;
                }
                rhs++;
            }
            return rhs - lhs;
        }
    }
}
