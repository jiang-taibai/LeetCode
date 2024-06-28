package com.coderjiang.DailyPractice.Monthly_2024_06;

import java.util.*;
import java.util.stream.IntStream;

/**
 * @author Jiang
 *
 * <p>Description:</p>
 * <p>Date: 2024-06-28 20:51:44</p>
 */
public class DailyPractice_20240628 {

    public static void main(String[] args) {
        Solution solution = new Solution();
    }

    static class Solution {
        public int paintWalls(int[] cost, int[] time) {
            int n = cost.length;
            int[] orderOfPaidWorker = IntStream.range(0, n).boxed()
                    .sorted((a, b) -> {
                        int left = cost[a] * time[b];
                        int right = cost[b] * time[a];
                        if (left != right) {
                            return Integer.compare(left, right);
                        }
                        if (cost[a] != cost[b]) {
                            return Integer.compare(cost[a], cost[b]);
                        }
                        return Integer.compare(time[b], time[a]);
                    })
                    .mapToInt(i -> i).toArray();
//            int[] orderOfFreeWorker = IntStream.range(0, n).boxed()
//                    .sorted((a, b) -> {
//                        if (cost[b] != cost[a]) {
//                            return cost[b] - cost[a];
//                        }
//                        return time[a] - time[b];
//                    })
//                    .mapToInt(i -> i).toArray();
            int[] orderOfFreeWorker = new int[n];
            for (int i = 0; i < n; i++) {
                orderOfFreeWorker[i] = orderOfPaidWorker[n - i - 1];
            }
//            System.out.println(Arrays.toString(orderOfPaidWorker));
//            System.out.println(Arrays.toString(orderOfFreeWorker));

            boolean[] completed = new boolean[n];
            int countOfCompleted = 0;
            int totalCost = 0;
            int indexOfPaidWorker = 0, indexOfFreeWorker = 0;
            while (indexOfPaidWorker < n && indexOfFreeWorker < n && countOfCompleted < n) {
                while (indexOfPaidWorker < n && completed[orderOfPaidWorker[indexOfPaidWorker]]) indexOfPaidWorker++;
                if (indexOfPaidWorker >= n) break;
                int paidFor = orderOfPaidWorker[indexOfPaidWorker];
                // 尝试找到时间大于剩余墙数，并且金钱少于现在的钱
//                System.out.println("n - countOfCompleted - 1 = " + (n - countOfCompleted - 1));
                for (int i = indexOfPaidWorker + 1; i < n; i++) {
                    int localPaidFor = orderOfPaidWorker[i];
                    if (time[localPaidFor] >= (n - countOfCompleted - 1) && cost[localPaidFor] < cost[paidFor]) {
                        paidFor = localPaidFor;
                    }
                }
                completed[paidFor] = true;
                countOfCompleted++;
//                System.out.println("paidFor = " + paidFor);

                int workerTime = time[paidFor];
                totalCost += cost[paidFor];

                while (indexOfFreeWorker < n && workerTime > 0) {
                    int freeFor = orderOfFreeWorker[indexOfFreeWorker];
//                    System.out.println("freeFor = " + freeFor);
                    if (!completed[freeFor]) {
                        workerTime--;
                        countOfCompleted++;
                        completed[freeFor] = true;
                    }
                    indexOfFreeWorker++;
                }
            }
            return totalCost;
        }
    }

    class Solution2 {
        public int paintWalls(int[] cost, int[] time) {
            int n = cost.length;
            int[] f = new int[n * 2 + 1];
            Arrays.fill(f, Integer.MAX_VALUE / 2);
            f[n] = 0;
            for (int i = 0; i < n; ++i) {
                int[] g = new int[n * 2 + 1];
                Arrays.fill(g, Integer.MAX_VALUE / 2);
                for (int j = 0; j <= n * 2; ++j) {
                    // 付费
                    g[Math.min(j + time[i], n * 2)] = Math.min(g[Math.min(j + time[i], n * 2)], f[j] + cost[i]);
                    // 免费
                    if (j > 0) {
                        g[j - 1] = Math.min(g[j - 1], f[j]);
                    }
                }
                f = g;
            }
            int ans = f[n];
            for (int i = n + 1; i <= n * 2; i++) {
                ans = Math.min(ans, f[i]);
            }
            return ans;
        }
    }

}
/*
cost = [1,2,3,2], time = [1,2,3,2]
换一个思路想
如果挑选 第2堵墙，那么付费工人就会消掉 cost[1] 和 time[1]
与此同时免费工人就会利用这 time[1]=2 时间去消除 2 堵墙，那么他自然会选择费用最高的也就是 cost[2] cost[3]

那么该怎么选择付费工人刷哪赌墙呢？
如果有堵墙很便宜，又需要花很多时间，那么就是最优的选择
y=c/t，当y越小时也就是 cost[i]/time[i] 越小，那么就越好，如果相同，那么先选 c 最小的，再选 t 最大的
cost[i]/time[i] < cost[j]/time[j] = cost[i] * time[j] < cost[j] * time[i]
 */
