package com.coderjiang.DailyPractice.Monthly_2021_08;

/**
 * <p>Creation Time: 2021-08-17 11:32:15</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_08_17 {

    class Solution {
        public boolean checkRecord(String s) {
            int serialL = 0;
            int countA = 0;
            for(char ch: s.toCharArray()) {
                if (ch == 'L') {
                    if(++serialL >= 3) return false;
                } else if(ch == 'A') {
                    countA++;
                    serialL = 0;
                } else {
                    serialL = 0;
                }
            }
            return countA < 2;
        }
    }

}
