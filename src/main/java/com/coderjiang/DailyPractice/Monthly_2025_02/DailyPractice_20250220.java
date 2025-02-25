package com.coderjiang.DailyPractice.Monthly_2025_02;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2025-02-20 12:55:15</p>
 */
public class DailyPractice_20250220 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int[] evenOddBit(int n) {
            int even = 0, odd = 0;
            boolean evenIndex = true;
            while(n!=0) {
                if((n&1)==1) {
                    if(evenIndex) even++;
                    else odd++;
                }
                n>>=1;
                evenIndex = !evenIndex;
            }
            return new int[]{even, odd};
        }
    }

}
