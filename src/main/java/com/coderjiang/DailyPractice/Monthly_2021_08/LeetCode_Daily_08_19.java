package com.coderjiang.DailyPractice.Monthly_2021_08;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>Creation Time: 2021-08-19 19:37:56</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_08_19 {

    class Solution {
        public String reverseVowels(String s) {
            Deque<Integer> deque = new LinkedList<>();
            char[] chs = s.toCharArray();
            for (int i = 0; i < chs.length; ++i) {
                char ch = chs[i];
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                        ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                    deque.offer(i);
                }
            }
            while (deque.size() >= 2) {
                int l = deque.pollFirst();
                int r = deque.pollLast();
                char temp = chs[l];
                chs[l] = chs[r];
                chs[r] = temp;
            }
            return String.valueOf(chs);
        }
    }

}
