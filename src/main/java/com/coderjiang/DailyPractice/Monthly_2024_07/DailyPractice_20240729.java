package com.coderjiang.DailyPractice.Monthly_2024_07;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-07-29 14:07:16</p>
 */
public class DailyPractice_20240729 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int calPoints(String[] operations) {
            Stack<Integer> stack = new Stack<>();
            for (String operation : operations) {
                switch (operation) {
                    case "+":
                        int pre = stack.pop();
                        int cur = stack.peek() + pre;
                        stack.push(pre);
                        stack.push(cur);
                        break;
                    case "D":
                        stack.push(stack.peek() * 2);
                        break;
                    case "C":
                        stack.pop();
                        break;
                    default:
                        stack.push(Integer.valueOf(operation));
                }
            }
            int res = 0;
            while (!stack.isEmpty()) res += stack.pop();
            return res;
        }
    }

}
