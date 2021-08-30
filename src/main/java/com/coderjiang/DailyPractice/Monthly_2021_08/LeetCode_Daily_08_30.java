package com.coderjiang.DailyPractice.Monthly_2021_08;

/**
 * <p>Creation Time: 2021-08-30 09:28:59</p>
 * <p>Description: TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_08_30 {

    class Solution {

        private final long[] pre;
        private long sum = 0;

        public Solution(int[] w) {
            int n = w.length;
            pre = new long[n];
            for (int j : w) sum += j;
            pre[0] = w[0];
            for (int i = 1; i < n; ++i) {
                pre[i] = pre[i - 1] + w[i];
            }
        }

        public int pickIndex() {
            long seed = (long) (Math.random() * sum) + 1;
            return binarySearch(seed);
        }

        private int binarySearch(long x) {
            int l = 0, r = pre.length;
            while (l < r) {
                int mid = (l + r) / 2;
                if(pre[mid] < x) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */

}
