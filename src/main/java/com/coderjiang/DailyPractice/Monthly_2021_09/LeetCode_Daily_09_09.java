package com.coderjiang.DailyPractice.Monthly_2021_09;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Creation Time: 2021-09-09 13:22:26</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_09_09 {

    class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            int n = words.length;
            int from = 0, end = pickWordRange(words, maxWidth, from);
            List<String> list = new ArrayList<>();
            while (true) {
                if (end == n - 1) {
                    list.add(getLastLine(words, maxWidth, from, end));
                } else {
                    list.add(getLine(words, maxWidth, from, end));
                }
                from = end + 1;
                if (from >= n) break;
                end = pickWordRange(words, maxWidth, from);
            }
            return list;
        }

        private int pickWordRange(String[] words, int maxWidth, int from) {
            int curLength = words[from].length();
            for (int i = from + 1; i < words.length; ++i) {
                curLength += 1;
                curLength += words[i].length();
                if (curLength > maxWidth) return i - 1;
            }
            return words.length - 1;
        }

        // pick the words range of [from, end],
        // and return a sequent one line string comprise by them
        private String getLine(String[] words, int maxWidth, int from, int end) {
            StringBuilder sb = new StringBuilder();
            int totalWordLength = 0;
            for (int i = from; i <= end; ++i) {
                totalWordLength += words[i].length();
            }
            int internal = maxWidth - totalWordLength;
            if (from == end) {
                sb.append(words[from]);
                while (sb.length() < maxWidth) sb.append(' ');
                return sb.toString();
            }

            int avgInterval = internal / (end - from);  // 但是不是真实平均的
            int[] perInterval = new int[end - from];
            for (int i = 0; i < end - from; ++i) {
                perInterval[i] = avgInterval;
                if (i < internal % (end - from)) perInterval[i]++;
            }
            for (int i = from; i <= end; ++i) {
                sb.append(words[i]);
                if (i != end)
                    appendInterval(sb, perInterval[i - from]);
            }
            return sb.toString().intern();
        }

        private String getLastLine(String[] words, int maxWidth, int from, int end) {
            StringBuilder sb = new StringBuilder();
            for (int i = from; i <= end; ++i) {
                sb.append(words[i]);
                if (i != end) sb.append(' ');
            }
            while (sb.length() < maxWidth) sb.append(' ');
            return sb.toString().intern();
        }

        private void appendInterval(StringBuilder sb, int cnt) {
            for (int i = 0; i < cnt; ++i) {
                sb.append(' ');
            }
        }
    }

}
