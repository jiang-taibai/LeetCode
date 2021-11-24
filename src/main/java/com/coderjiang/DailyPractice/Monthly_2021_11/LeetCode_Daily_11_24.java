package com.coderjiang.DailyPractice.Monthly_2021_11;

/**
 * <p>Creation Time: 2021-11-24 21:26:33</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_11_24 {

    class Solution {

        private String[] nums = {
                "zero", "one", "tow", "three", "four", "five",
                "six", "serven", "eight", "nine"
        };

        private char[] keyOfNum = {
                'z', 'o', 'w', 't', 'u', 'v', 'x', 's', 'g', 'i'
        };

        public String originalDigits(String s) {
            int[] cnt = new int[26];
            int[] res = new int[10];
            char[] chars = s.toCharArray();
            for(char ch:chars) cnt[ch-'a']++;
            delNum(cnt, res, 0);
            delNum(cnt, res, 2);
            delNum(cnt, res, 4);
            delNum(cnt, res, 6);
            delNum(cnt, res, 8);
            delNum(cnt, res, 7);
            delNum(cnt, res, 5);
            delNum(cnt, res, 3);
            delNum(cnt, res, 9);
            delNum(cnt, res, 1);
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<10;++i) {
                for(int k=0;k<res[i];++k) {
                    sb.append(i);
                }
            }
            return sb.toString();
        }

        private void delNum(int[] cnt, int[] res, int n) {
            while(cnt[keyOfNum[n]-'a'] != 0) {
                for(char ch:nums[n].toCharArray()) {
                    cnt[ch-'a']--;
                }
                res[n]++;
            }
        }
    }

}
