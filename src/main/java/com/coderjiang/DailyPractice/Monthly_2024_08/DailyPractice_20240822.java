package com.coderjiang.DailyPractice.Monthly_2024_08;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-08-22 10:33:42</p>
 */
public class DailyPractice_20240822 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minEnd(2, 4));
    }

    static class Solution {
        public long minEnd(int n, int x) {
            if (n == 1) return x;
            String xBit = Integer.toBinaryString(x);
            int xBit1 = Integer.bitCount(x);
            int xBit01 = xBit.length();
            int xBit0 = xBit01 - xBit1;
            long numBit0Set1Condition = 1L << xBit0;
            long upper = (n - 1) / numBit0Set1Condition;
            long lastNumBit0Set1 = (n - 1) % numBit0Set1Condition;
            long res = upper;
            String lastNumBitNotAligned = Long.toBinaryString(lastNumBit0Set1);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < xBit0 - lastNumBitNotAligned.length(); i++) {
                sb.append('0');
            }
            String lastNumBit = sb.append(lastNumBitNotAligned).toString();
//            System.out.println("upper = " + upper);
//            System.out.println("xBit = " + xBit);
//            System.out.println("xBit01 = " + xBit01);
//            System.out.println("lastNumBit = " + lastNumBit);

            int lastNumBitIndex = 0;
            for (int i = 0; i < xBit01; i++) {
                res <<= 1;
                if (xBit.charAt(i) == '1') {
                    res += 1;
                } else {
                    res += lastNumBit.charAt(lastNumBitIndex) == '1' ? 1 : 0;
                    lastNumBitIndex++;
                }
            }
            return res;
        }
    }

}
