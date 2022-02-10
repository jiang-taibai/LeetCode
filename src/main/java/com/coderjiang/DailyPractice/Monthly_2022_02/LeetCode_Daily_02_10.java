package com.coderjiang.DailyPractice.Monthly_2022_02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>Creation Time: 2022-02-10 00:30:12</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_02_10 {

    class Solution {

        private int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }

        public List<String> simplifiedFractions(int n) {
            Set<String> set = new HashSet<>();
            List<String> res = new ArrayList<>();
            for (int i = 2; i <= n; ++i) {
                for (int j = 1; j < i; ++j) {
                    if (gcd(i, j) == 1) {
                        res.add("" + j + "/" + i);
                    }
                }
            }
            return res;
        }
    }

}
