package com.coderjiang.DailyPractice.Monthly_2021_06;

import java.util.regex.Pattern;

public class LeetCode_Daily_06_17 {

    class Solution {
        public boolean isNumber(String s) {
//            String pattern_decimals = "[-+]?(\\d+\\.\\d*)|(\\.\\d+)";
//            String pattern_integer = "[-+]?\\d+";
            String pattern = "^[-+]?(((\\d+\\.\\d*)|(\\.\\d+))|([-+]?\\d+))([eE]([-+]?\\d+))?$";
//            Pattern.matches(pattern_decimals, s);
//            Pattern.matches(pattern_integer, s);
            return Pattern.matches(pattern, s);
        }
    }

}