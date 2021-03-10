package com.coderjiang.DailyPractice.Monthly_2021_03;

import java.util.Stack;

/**
 * <p>创建时间：2021/3/10 19:10</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_03_10 {
    public static void main(String[] args) {

    }

    static class Solution {
        public int calculate(String s) {
            Stack<Integer> nums = new Stack<>();
            Stack<Character> operators = new Stack<>();
            StringBuilder sb = new StringBuilder();
            for (Character ch : s.toCharArray()) {
                // 如果是运算符符号了，那么就将符号加入到运算集中，比较优先级，如果优先级大那么就运算
                if (isOperator(ch)) {
                    int num = 0;
                    if (sb.length() != 0) {
                        num = Integer.parseInt(sb.toString());
                        sb.delete(0, sb.length());
                    }
                    while (!operators.isEmpty() && operators.peek() != '(') {
                        int preNum = nums.pop();
                        char op = operators.pop();
                        nums.push(cal(preNum, op, num));
                    }
                } else if(ch == '(') {
                    operators.push(ch);
                } else if(ch == ')') {
                    int num = 0;
                    if(sb.length() != 0) {
                        num = Integer.parseInt(sb.toString());
                        sb.delete(0, sb.length());
                    }
                    while(!operators.isEmpty()) {
                        if(operators.peek() == '(') {
                            operators.pop();
                            break;
                        }
                        int preNum = nums.pop();
                        char op = operators.pop();
                        nums.push(cal(preNum, op, num));
                    }
                }
            }
            return 0;
        }

        private boolean isOperator(Character ch) {
            return ch == '+' || ch == '-';
        }

        private boolean isBracket(Character ch) {
            return ch == '(' || ch == ')';
        }

        private int cal(int n1, char op, int n2) {
            if (op == '+') return n1 + n2;
            return n1 - n2;
        }

        // 返回o1优先级是否大于o2
//        private boolean upper(Character o1, Character o2) {
//            Operator op1 = Operator.getInstance(o1);
//            Operator op2 = Operator.getInstance(o2);
//
//        }

        enum Operator {
            ADD('+', 1),
            SUB('-', 1),
            L('(', 2),
            R(')', 2);

            private Character symbol;
            private Integer priority;

            private Operator(Character symbol, Integer priority) {
                this.symbol = symbol;
                this.priority = priority;
            }

            public static Operator getInstance(Character ch) {
                for (Operator operatorEnum : Operator.values()) {
                    if (operatorEnum.symbol == ch) {
                        return operatorEnum;
                    }
                }
                return null;
            }
        }
    }


}
