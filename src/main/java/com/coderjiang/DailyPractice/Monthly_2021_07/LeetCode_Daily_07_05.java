package com.coderjiang.DailyPractice.Monthly_2021_07;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

/**
 * <p>Creation Time: 2021-07-05 22:28:22</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_07_05 {

    class Solution {
        public String countOfAtoms(String formula) {
            Stack<Map<String, Integer>> stack = new Stack<>();
            stack.add(new TreeMap<>());
            int index = 0;
            while (index < formula.length()) {
                char ch = formula.charAt(index);
                if (ch == '(') {
                    stack.add(new TreeMap<>());
                    index++;
                } else if (ch == ')') {
                    // 后面可能会跟着数字
                    Map<String, Integer> top = stack.pop();
                    int mul = 0;
                    index++;
                    while (index < formula.length() && formula.charAt(index) >= '0' && formula.charAt(index) <= '9') {
                        mul = mul * 10 + (formula.charAt(index) - '0');
                        index++;
                    }
                    // 到这里index指向的要么是末尾，要么是非数字
                    if (mul == 0) {
                        mul = 1;
                    }
                    // 合并两个Map
                    Map<String, Integer> cur = stack.peek();
                    for (Map.Entry<String, Integer> entry : top.entrySet()) {
                        String key = entry.getKey();
                        Integer value = entry.getValue();
                        cur.put(key, cur.getOrDefault(key, 0) + value * mul);
                    }
                } else {
                    // 否则就是指向字母，一定是字母，因为数字直接跳过了
                    // 读取元素的全名，要么是一个大写字母，要么就是大写字母后面跟着小写字母
                    String atom = String.valueOf(formula.charAt(index));
                    if (index + 1 < formula.length() &&
                            (formula.charAt(index + 1) >= 'a' && formula.charAt(index + 1) <= 'z')) {
                        // 如果是小写字母
                        atom += formula.charAt(index + 1);
                        index++;
                    }
                    index++;
                    // 到此index指向的是元素名称的后一个位置
                    int count = 0;
                    while (index < formula.length() && formula.charAt(index) >= '0' && formula.charAt(index) <= '9') {
                        count = count * 10 + (formula.charAt(index) - '0');
                        index++;
                    }
                    if (count == 0) {
                        count = 1;
                    }
                    // 到此index要么指向字符串结束，要么就是下一个元素的名称的开头
                    // 将当前元素加到现在的map里
                    Map<String, Integer> cur = stack.peek();
                    cur.put(atom, cur.getOrDefault(atom, 0) + count);
                }
            }
            // 到这里获得一个Map
            StringBuilder sb = new StringBuilder();
            Map<String, Integer> map = stack.peek();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                sb.append(entry.getKey());
                if(entry.getValue() >= 2) {
                    sb.append(entry.getValue());
                }
            }
            return sb.toString();
        }
    }

}
