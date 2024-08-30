package com.coderjiang.DailyPractice.Monthly_2024_08;

import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-08-30 18:59:08</p>
 */
public class DailyPractice_20240830 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public long sumDigitDifferences(int[] nums) {
            long[][] cnt = new long[10][10];
            for (int num : nums) {
                if (num == 0) cnt[0][0]++;
                int index = 0;
                while (num != 0) {
                    cnt[index++][num % 10]++;
                    num /= 10;
                }
            }
            long res = 0;
            for (int index = 0; index < 10; index++) {
                for (int i = 0; i < 10; i++) {
                    for (int j = i + 1; j < 10; j++) {
                        res += cnt[index][i] * cnt[index][j];
                    }
                }
            }
            return res;
        }


    }

}
/*
[13,23,12]
对应的 cnt 数组为
cnt[0] = [0,0,1,2,0,...]
cnt[1] = [0,2,1,0,...]
那么个位数不同的组合有 1*2，十位数不同的组合有 2*1

[13,12,14]
对应的 cnt 数组为
cnt[0] = [0,1,1,1,0,...]
cnt[1] = [0,3,0,0,...]
那么个位数不同的组合有 1，十位数不同的组合有 0
 */
