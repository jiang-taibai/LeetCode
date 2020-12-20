package com.coderjiang.DailyPractice.Monthly_2020_12;

import java.util.*;

/**
 * @author 0194161刘江
 * @modifyTime 2020/12/20 10:43
 * @description: 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。
 * 需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 */
public class LeetCode_Daily_12_20 {
    public static void main(String[] args) {

    }

    static class Solution {
        public String removeDuplicateLetters(String s) {
            Deque<Character> deque = new LinkedList<>();
            Map<Character, Integer> map = new HashMap<>();
            for (Character ch : s.toCharArray()) {
                if (map.containsKey(ch)) map.put(ch, map.get(ch) + 1);
                else map.put(ch, 1);
            }

            for (Character ch : s.toCharArray()) {
                // 如果之前没有加入过，则本次应当加入
                if (!deque.contains(ch)) {
                    while (!deque.isEmpty() && map.get(deque.peekLast()) > 0 && ch < deque.peekLast()) {
                        deque.pollLast();
                    }
                    deque.offerLast(ch);
                }
                // 将该字母出现次数-1
                map.put(ch, map.get(ch) - 1);
            }

            StringBuilder sb = new StringBuilder();
            while(!deque.isEmpty()) {
                sb.append(deque.pollFirst());
            }

            return sb.toString();
        }
    }
}
