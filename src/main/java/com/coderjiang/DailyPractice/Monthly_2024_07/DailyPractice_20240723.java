package com.coderjiang.DailyPractice.Monthly_2024_07;

import java.math.BigInteger;
import java.util.*;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-07-23 00:03:59</p>
 */
public class DailyPractice_20240723 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {

        final long MOD = (long) (1e9 + 7);
        final long MAX_COUNT = (long) (Long.MAX_VALUE / (2 * 1e8));
        long[][][] memo;

        public int sumOfPowers(int[] nums, int k) {
            Arrays.sort(nums);
            int n = nums.length;
            Set<Integer> powers = new HashSet<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    powers.add(nums[i] - nums[j]);
                }
            }
            long res = 0;
            for (Integer power : powers) {
                long count = 0;
                this.initMemo(n);
                for (int i = 0; i < n; i++) {
                    count += countOfValidSubSeq(nums, i, k - 1, power, false) % MOD;
                    count %= MOD;
                }
                // 这里会溢出，(a*b)%c=(a%c * b%c) % c
                res += ((long) power * count % MOD) % MOD;
                res %= MOD;
            }
            return (int) res;
        }

        private void initMemo(int n) {
            this.memo = new long[n][n][2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < 2; k++) {
                        memo[i][j][k] = -1;
                    }
                }
            }
        }

        private long countOfValidSubSeq(int[] nums, int cur, int k, int power, boolean existPower) {
            if (k == 0) {
                return existPower ? 1 : 0;
            }
            if (memo[cur][k][existPower ? 1 : 0] != -1) return memo[cur][k][existPower ? 1 : 0];
            int n = nums.length;
            int minMaxIndex = binarySearchMinMax(nums, cur + 1, n - 1, nums[cur] + power);
            if (n - cur - 1 < k || minMaxIndex == -1) {
                memo[cur][k][existPower ? 1 : 0] = 0;
                return 0;
            }
            long res = 0;
            for (int i = minMaxIndex; i < n; i++) {
                res += countOfValidSubSeq(nums, i, k - 1, power, existPower || (nums[i] - nums[cur] == power));
            }
            memo[cur][k][existPower ? 1 : 0] = res;
            return res;
        }

        private int binarySearchMinMax(int[] nums, int l, int r, int target) {
            int res = -1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (nums[mid] >= target) {
                    res = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return res;
        }

    }

}

/*
1,2,5,7,10,11,12

先把序列排序，计算能力值就是子序列相邻两个元素的最小值

选择子序列，能量值只跟最小的差额有关
反过来思考，如果要获得能量值为 p 的子序列，那么必然满足相邻两个元素差值的最小值为 p
那么选择 p=2 时

选择 1，下一个数字必须是 5 之后的
选择 5，下一个数字必须是 7 之后的
选择 7，下一个数字必须是 10 之后的
选择 10，下一个数字必须是 12 之后的

可以看到，前面选择的数字不影响后面的选择，只和最后一个数字有关
那么就可以得到长度为 3 的子序列
1 5 7
1 7 10
1 10 12

通过能量 p 反推长度为 k 的子序列是一件容易的事情

那么关键在于，如何找到 p 的范围？遍历 10^8 是一个不太合理的事情

----------------------------------------------------------------

有了，能力值必然是二者之差，又考虑到数组长度只有 50，所以完全可以二重循环找到所有可能的能力值
然后再遍历所有的能力值，找到所有可能的子序列

----------------------------------------------------------------

BUG：在找序列的时候，不但要保证子序列能量大于 p，还要保证至少有一个 p

----------------------------------------------------------------

BUG：超时了，考虑使用记忆化搜索

----------------------------------------------------------------

BUG：溢出？？考虑使用模运算 (a*b)mod n = ((a mod n)*(b mod n)) mod n，并且拉高 count 为 long

----------------------------------------------------------------

终于！拿下困难题。睡觉！

 */
