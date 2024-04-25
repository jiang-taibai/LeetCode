package com.coderjiang.RegularPractice;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 0194161刘江
 * @modifyTime 2020/12/20 11:22
 * @description: 给定一个以字符串表示的非负整数num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * <p>
 * 注意:
 * num 的长度小于 10002 且≥ k。
 * num 不会包含任何前导零。
 */
public class LeetCode_402 {
    public static void main(String[] args) {

    }

    static class Solution {
        public String removeKdigits(String num, int k) {
            Deque<Character> deque = new LinkedList<Character>();
            for (Character ch : num.toCharArray()) {
                while (k > 0 && !deque.isEmpty() && ch < deque.peekLast()) {
                    deque.pollLast();
                    k--;
                }
                deque.offerLast(ch);
            }
            // 没有丢弃掉k个数，那么就删掉尾部
            while (k > 0) {
                deque.pollLast();
                k--;
            }

            // 删除前导0
            StringBuilder result = new StringBuilder();
            boolean flag = true;
            while (!deque.isEmpty()) {
                char ch = deque.pollFirst();
                if (flag && ch == '0') {
                    continue;
                }
                flag = false;
                result.append(ch);
            }
            return result.length() == 0 ? "0" : result.toString();
        }
    }
}
