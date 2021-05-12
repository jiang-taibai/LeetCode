package com.coderjiang.DailyPractice.Monthly_2021_05;

/**
 * <p>创建时间：2021/5/12 12:55</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_05_12 {

    class Solution {
        public int[] xorQueries_bad(int[] arr, int[][] queries) {
            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int res = 0;
                for (int j = queries[i][0]; j <= queries[i][1] ; j++) {
                    res ^= arr[j];
                }
                ans[i] = res;
            }
            return ans;
        }

        public int[] xorQueries(int[] arr, int[][] queries) {
            int[] aoxs = new int[arr.length + 1];
            for (int i = 0; i < arr.length; i++) {
                aoxs[i + 1] = aoxs[i] ^ arr[i];
            }
            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                ans[i] = aoxs[queries[i][1] + 1] ^ aoxs[queries[i][0]];
            }
            return ans;
        }
    }

}
