package com.coderjiang.DailyPractice.Monthly_2021_06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_Daily_06_21 {

    static class Solution {
        public List<String> readBinaryWatch(int turnedOn) {
            List<String> res = new ArrayList<>();
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 60; j++) {
                    if(Integer.bitCount(i) + Integer.bitCount(j) == turnedOn) {
                        res.add(String.format("%2d:%2d", i, j));
                    }
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 0; i <= 10; i++) {
            List<String> res = solution.readBinaryWatch(i);
            System.out.println(Arrays.toString(res.toArray()));
        }
    }

}