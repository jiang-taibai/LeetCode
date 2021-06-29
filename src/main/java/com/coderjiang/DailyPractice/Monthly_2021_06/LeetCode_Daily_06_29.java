package com.coderjiang.DailyPractice.Monthly_2021_06;

public class LeetCode_Daily_06_29 {

    class Solution {
        public String convertToTitle(int columnNumber) {
            StringBuilder sb = new StringBuilder();
            while(columnNumber != 0) {
                columnNumber--;
                sb.append((char) ('A' + columnNumber % 26));
                columnNumber /= 26;
            }
            return sb.reverse().toString();
        }
    }

}