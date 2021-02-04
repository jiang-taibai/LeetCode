package com.coderjiang.DailyPractice.Monthly_2021_02;

/**
 * <p>创建时间：2021/2/5 10:21</p>
 * <p>主要功能：TODO</p>
 *
 * @author 刘江
 */
public class LeetCode_Daily_02_04 {
    public static void main(String[] args) {

    }

    class Solution {
        public int equalSubstring(String s, String t, int maxCost) {
            int lhs = 0, rhs = 0;
            int n = s.length();
            int cost = 0;
            while (rhs < n) {
                cost += getCharChangeCost(s, t, rhs);
                if(cost > maxCost) {
                    cost -= getCharChangeCost(s, t, lhs);
                    lhs++;
                }
                rhs++;
            }
            return rhs - lhs;
        }

        private int getCharChangeCost(String s, String t, int index) {
            return Math.abs(s.charAt(index) - t.charAt(index));
        }
    }
}
