package com.coderjiang.DailyPractice.Monthly_2024_03;

import java.util.*;

/**
 * <p>Creation Time: 2024/3/30</p>
 * <p>Description: TODO</p>
 *
 * @author Jiang
 */
public class LeetCode_Daily_03_30 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins = new int[]{1, 4, 10};
        int target = 19;
        System.out.println(solution.minimumAddedCoins(coins, target));
    }

    static class Solution {
        public int minimumAddedCoins_NONONO(int[] coins, int target) {
            int n = coins.length;
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
            Arrays.sort(coins);
            pq.offer(new int[]{0, 0});
            boolean[] vis = new boolean[target + 1];
            vis[0] = true;
            int res = 0;
            List<Integer> coinsList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                coinsList.add(coins[i]);
            }
            int preSum = 0;
            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                int nextCoin = coinsList.get(cur[1]);
                if (cur[1] < n) {
                    int sum = cur[0] + nextCoin;
                    // 判断是否是连续的和
                    if (sum != preSum + 1) {
                        coinsList.add(preSum + 1);
                        Collections.sort(coinsList);
                        res++;
//                        pq.add();
                        continue;
                    }
                    preSum++;
                    // 加上当前数字
                    int[] next = new int[]{sum, nextCoin + 1};
                    if (sum <= target) {
                        vis[sum] = true;
                        pq.add(next);
                    }
                    // 不加上当前数字
                    cur[1]++;
                    pq.add(cur);
                }
            }
            List<Integer> exists = new ArrayList<>();
            List<Integer> absents = new ArrayList<>();
            for (int i = 1; i <= target; i++) {
                if (vis[i]) exists.add(i);
                else absents.add(i);
            }
            while (!absents.isEmpty()) {
                int absent = absents.get(0);
                vis[absent] = true;
                res++;
                List<Integer> newAbsents = new ArrayList<>();
                for (int j = absents.size() - 1; j >= 1; --j) {
                    if (vis[absents.get(j) - absent]) vis[absents.get(j)] = true;
                    else newAbsents.add(absents.get(j));
                }
                Collections.reverse(newAbsents);
                absents = newAbsents;
            }
            return res;
        }

        public int minimumAddedCoins(int[] coins, int target) {
            Arrays.sort(coins);
            int res = 0;
            int x = 1;
            int index = 0;
            while (x <= target) {
                if (index < coins.length && coins[index] <= x) {
                    x += coins[index++];
                } else {
                    x <<= 1;
                    res++;
                }
            }
            return res;
        }
    }

}
