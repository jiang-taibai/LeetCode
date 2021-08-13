package com.coderjiang.DailyPractice.Monthly_2021_08;

/**
 * <p>Creation Time: 2021-08-13 11:17:40</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_08_13 {

    class Solution {
        public int countDigitOne(int n) {
            int high = n / 10;
            int low = 0;
            int digit = n % 10;
            int pow = 1;
            int res = 0;
            while (high != 0 || digit != 0) {
                if (digit == 0) res += high * pow;
                else if (digit == 1) res += high * pow + low + 1;
                else res += (high + 1) * pow;
                low += digit * pow;
                digit = high % 10;
                high /= 10;
                pow *= 10;
            }
            return res;
        }
    }


}
