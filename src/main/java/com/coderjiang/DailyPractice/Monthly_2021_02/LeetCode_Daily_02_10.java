package com.coderjiang.DailyPractice.Monthly_2021_02;

import java.util.Arrays;

/**
 * <p>创建时间：2021/2/10 11:06</p>
 * <p>主要功能：TODO</p>
 *
 * @author 刘江
 */
public class LeetCode_Daily_02_10 {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if(s1.length() > s2.length()) return false;

            int[] count1 = new int[26];
            for (char c : s1.toCharArray()) {
                count1[c - 'a']++;
            }

            int n = s2.length();
            int lhs = 0, rhs = 0;
            int[] count2 = new int[26];
            for (; rhs < s1.length(); ++rhs) {
                count2[s2.charAt(rhs) - 'a']++;
            }
            if (sameArr(count1, count2)) return true;
            System.out.println("count1 = " + Arrays.toString(count1));
            System.out.println("count2 = " + Arrays.toString(count2));
            while (rhs < n) {
                count2[s2.charAt(rhs++) - 'a']++;
                count2[s2.charAt(lhs++) - 'a']--;
                System.out.println("count1 = " + Arrays.toString(count1));
                System.out.println("count2 = " + Arrays.toString(count2));
                if (sameArr(count1, count2)) return true;
            }
            return false;
        }

        private boolean sameArr(int[] arr1, int[] arr2) {
            for (int i = 0; i < arr1.length; i++) {
                if (arr2[i] != arr1[i]) return false;
            }
            return true;
        }
    }
}
