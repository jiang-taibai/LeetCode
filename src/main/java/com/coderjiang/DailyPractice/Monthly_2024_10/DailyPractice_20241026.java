package com.coderjiang.DailyPractice.Monthly_2024_10;

import java.math.BigInteger;
import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-10-26 10:58:14</p>
 */
public class DailyPractice_20241026 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int maxTotalReward(int[] rewardValues) {
            int n = rewardValues.length;
            Arrays.sort(rewardValues);
            if (n >= 2 && rewardValues[n - 2] == rewardValues[n - 1] - 1) {
                return 2 * rewardValues[n - 1] - 1;
            }
            BigInteger f = BigInteger.ONE;
            for (int x : Arrays.stream(rewardValues).distinct().toArray()) {
                BigInteger mask = BigInteger.ONE.shiftLeft(x).subtract(BigInteger.ONE);
                f = f.or(f.and(mask).shiftLeft(x));
            }
            return f.bitLength() - 1;
        }
    }

}
