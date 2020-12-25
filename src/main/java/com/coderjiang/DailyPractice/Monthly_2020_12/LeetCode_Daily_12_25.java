package com.coderjiang.DailyPractice.Monthly_2020_12;

import java.util.Arrays;

/**
 * @author 刘江
 * @modifyTime 2020/12/25 13:05
 * @description TODO
 */
public class LeetCode_Daily_12_25 {
    public static void main(String[] args) {

    }

    static class Solution {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);

            int index = 0;
            int count = 0;
            for (int appetite : g) {
                while(index<s.length && appetite > s[index]) index++;
                if(index >= s.length) break;
                count++;
                index++;
            }
            return count;
        }
    }
}
