package com.coderjiang.DailyPractice.Monthly_2021_05;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>创建时间：2021/5/19 13:09</p>
 * <p>主要功能：TODO</p>
 *
 * @author 太白
 */
public class LeetCode_Daily_05_19 {

    class Solution {
        public int kthLargestValue(int[][] matrix, int k) {
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] dp = new int[m+1][n+1];
            PriorityQueue<Integer> que = new PriorityQueue<Integer>(Comparator.reverseOrder());
            for(int i=1;i<=m;++i) {
                for(int j=1;j<=n;++j) {
                    dp[i][j] = dp[i-1][j] ^ dp[i][j-1] ^ dp[i-1][j-1] ^ matrix[i-1][j-1];
                    que.add(dp[i][j]);
                }
            }
            for (int i = 1; i < k ; i++) {
                que.poll();
            }
            return que.poll();
        }
    }

}
