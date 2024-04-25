package com.coderjiang.RegularPractice;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>Creation Time: 2023-03-19 14:36:07</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class T241_为运算表达式设计优先级 {

    class Solution {
        public List<Integer> diffWaysToCompute(String expression) {
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < expression.length(); ++i) {
                if (Character.isDigit(expression.charAt(i))) continue;
                List<Integer> leftValues = diffWaysToCompute(expression.substring(0, i));
                List<Integer> rightValues = diffWaysToCompute(expression.substring(i + 1));
                for (Integer leftValue : leftValues) {
                    for (Integer rightValue : rightValues) {
                        switch (expression.charAt(i)) {
                            case '+':
                                list.add(leftValue + rightValue);
                                break;
                            case '-':
                                list.add(leftValue - rightValue);
                                break;
                            case '*':
                                list.add(leftValue * rightValue);
                                break;
                        }
                    }
                }
            }
            if (list.size() == 0) {
                list.add(Integer.parseInt(expression));
            }
            return list;
        }
    }

}
