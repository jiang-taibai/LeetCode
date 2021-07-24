package com.coderjiang.DailyPractice.Monthly_2021_07;

/**
 * <p>Creation Time: 2021-07-24 10:00:22</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_07_24 {

    class Solution {
        public String maximumTime(String time) {
            char[] chs = time.toCharArray();

            if (chs[0] == '?') {
                switch (chs[1]) {
                    case '?':
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                        chs[0] = '2';
                        break;
                    default:
                        chs[0] = '1';
                }
            }

            if (chs[1] == '?') {
                switch (chs[0]) {
                    case '0':
                    case '1':
                        chs[1] = '9';
                        break;
                    case '2':
                        chs[1] = '3';
                }
            }

            if (chs[3] == '?') {
                chs[3] = '5';
            }
            if (chs[4] == '?') {
                chs[4] = '9';
            }

            return String.valueOf(chs);
        }
    }

}
